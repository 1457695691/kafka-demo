package com.lh.kafka.service.user;

import com.alibaba.fastjson.JSONObject;
import com.lh.kafka.enums.StatusEnum;
import com.lh.kafka.error.BaseErrorCodeEnum;
import com.lh.kafka.exception.AppException;
import com.lh.kafka.feign.WeChatSnsFeign;
import com.lh.kafka.feign.WeChatTokenFeign;
import com.lh.kafka.request.user.LoginRequest;
import com.lh.kafka.request.user.RegisterRequest;
import com.lh.kafka.request.wechat.WechatLoginRequest;
import com.lh.kafka.service.wechat.WeChatService;
import com.lh.kafka.test.dao.UsersDAO;
import com.lh.kafka.test.dao.WechatUserDAO;
import com.lh.kafka.test.entity.UsersDO;
import com.lh.kafka.test.entity.WechatUserDO;
import com.lh.kafka.utils.JwtUtil;
import com.lh.kafka.utils.MD5Util;
import com.lh.kafka.vo.user.UserVO;
import com.lh.kafka.vo.wechat.JsCodeSessionVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author: ywx
 * @description
 * @Date: 2022/07/18
 */
@Service
public class UserServiceImpl implements UserService {
    private static final String GRANT_TYPE = "client_credential";
    private static final String APP_ID_SNS = "";
    private static final String APP_SECRET_SNS = "";
    private static final String AUTHORIZATION_CODE = "authorization_code";

    @Autowired(required = false)
    private WeChatTokenFeign weChatTokenFeign;

    @Autowired
    private WeChatSnsFeign weChatSnsFeign;

    @Autowired
    private UsersDAO usersDAO;

    @Autowired
    private WeChatService weChatService;

    @Autowired
    private WechatUserDAO wechatUserDAO;

    @Override
    public UserVO login(LoginRequest request) {
        if (ObjectUtils.isEmpty(request.getUserName()) || ObjectUtils.isEmpty(request.getPassword())) {
            throw new AppException(BaseErrorCodeEnum.ERROR_SYS_1002);
        }
        UsersDO usersDO = usersDAO.getByUsersUserName(request.getUserName());
        if (ObjectUtils.isEmpty(usersDO)) {
            throw new AppException(BaseErrorCodeEnum.ERROR_USER_1002);
        }
        String pwd = MD5Util.MD5Encode(request.getPassword());
        if (!pwd.equals(usersDO.getUserPwd())) {
            throw new AppException(BaseErrorCodeEnum.ERROR_SYS_1003);
        }
        UserVO vo = new UserVO();
        BeanUtils.copyProperties(usersDO, vo);
        String phone = usersDO.getPhone().substring(0, 3) + "****" + usersDO.getPhone().substring(7, 11);
        vo.setPhone(phone);
        String token = JwtUtil.generate(usersDO.getId());
        vo.setUserToken(token);
        return vo;
    }

    @Override
    public UserVO wechatLogin(WechatLoginRequest request) {
        UserVO vo = new UserVO();
        JsCodeSessionVO jsCodeSessionVO = weChatService.getJsCodeSession(request);
        if (jsCodeSessionVO == null || ObjectUtils.isEmpty(jsCodeSessionVO.getSessionKey())) {
            return vo;
        }
        String sessionKey = jsCodeSessionVO.getSessionKey();
        String result = decryptS5(request.getEncryptedData(), sessionKey, request.getIv());
        if (ObjectUtils.isEmpty(result)) {
            return vo;
        }
        JSONObject jsonObject = JSONObject.parseObject(result);
        String phone = jsonObject.getString("phoneNumber");
        vo = this.saveUser(phone, jsCodeSessionVO.getOpenId(), jsCodeSessionVO.getUnionId());
        String token = JwtUtil.generate(vo.getId());
        vo.setUserToken(token);
        return vo;
    }

    @Override
    public void register(RegisterRequest request) {
        if (ObjectUtils.isEmpty(request.getPhone()) || ObjectUtils.isEmpty(request.getPassword())) {
            throw new AppException(BaseErrorCodeEnum.ERROR_SYS_1002);
        }
        UsersDO uDO = usersDAO.getByUsersPhone(request.getPhone());
        if (!ObjectUtils.isEmpty(uDO)) {
            throw new AppException(BaseErrorCodeEnum.ERROR_USER_1001);
        }
        UsersDO usersDO = new UsersDO();
        usersDO.setPhone(request.getPhone());
        usersDO.setRealName("用户" + request.getPhone().substring(7, 11));
        String pwd = MD5Util.MD5Encode(request.getPassword());
        usersDO.setUserPwd(pwd);
        usersDO.setStatus(StatusEnum.NORMAL.getCode());
        // 用户名默认为手机号
        usersDO.setUserName(request.getPhone());
        usersDAO.insert(usersDO);
    }

    /**
     * 微信小程序登录，微信加密串解密
     *
     * @param sSrc
     * @param sKey
     * @param ivParameter
     * @return
     */
    private static String decryptS5(String sSrc, String sKey, String ivParameter) {
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] raw = decoder.decodeBuffer(sKey);
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            IvParameterSpec iv = new IvParameterSpec(decoder.decodeBuffer(ivParameter));
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] myendicod = decoder.decodeBuffer(sSrc);
            byte[] original = cipher.doFinal(myendicod);
            String originalString = new String(original, "UTF-8");
            return originalString;
        } catch (Exception e) {
            e.printStackTrace();
            throw new AppException("FAIL", "获取微信授权信息失败");
        }
    }

    private UserVO saveUser(String phone, String openId, String unionId) {
        UserVO vo = new UserVO();
        UsersDO usersDO = usersDAO.getByUsersPhone(phone);
        UsersDO userDO = new UsersDO();
        if (usersDO == null) {
            userDO.setPhone(phone);
            userDO.setRealName("用户" + phone.substring(7, 11));
            userDO.setUserPwd(null);
            userDO.setStatus(StatusEnum.NORMAL.getCode());
            // 用户名默认为手机号
            userDO.setUserName(phone);
            usersDAO.insert(userDO);
        }
        if (!ObjectUtils.isEmpty(openId) || !ObjectUtils.isEmpty(unionId)) {
            WechatUserDO wechatDO = this.saveGetUserWechat(userDO.getId(), openId, unionId);
            vo.setOpenId(wechatDO.getOpenId());
        }
        vo.setRealName(userDO.getRealName());
        vo.setId(userDO.getId());
        vo.setPhone(phone.substring(0, 3) + "****" + phone.substring(7, 11));
        return vo;
    }

    private WechatUserDO saveGetUserWechat(Long userId, String openId, String unionId){
        WechatUserDO userWechatDO = wechatUserDAO.getByWechatUserUserId(userId);
        /**
         * 当存在wechat数据时，对比openId和unionId，若不同，则更新
         * 当不存在wechat数据时，直接插入一条新的wechat
         */
        if (userWechatDO != null && (!openId.equals(userWechatDO.getOpenId()) ||
                !unionId.equals(userWechatDO.getUnionId()))) {
            userWechatDO.setOpenId(openId);
            userWechatDO.setUnionId(unionId);
            wechatUserDAO.updateByWechatUserUserId(userWechatDO);
        } else {
            userWechatDO = new WechatUserDO();
            userWechatDO.setUserId(userId);
            userWechatDO.setUnionId(unionId);
            userWechatDO.setOpenId(openId);
            wechatUserDAO.insert(userWechatDO);

        }
        return userWechatDO;
    }

    private JsCodeSessionVO getJsCodeSession(WechatLoginRequest request) {
        String response = weChatSnsFeign.jsCodeSession(APP_ID_SNS, APP_SECRET_SNS, request.getCode(), AUTHORIZATION_CODE);
        JSONObject jsonObject = JSONObject.parseObject(response);
        if (jsonObject == null || jsonObject.get("session_key") == null || jsonObject.get("openid") == null) {
            return null;
        }
        JsCodeSessionVO vo = new JsCodeSessionVO();
        vo.setSessionKey(jsonObject.get("session_key").toString());
        vo.setOpenId(jsonObject.get("openid").toString());
        /**
         * 添加unionId
         */
        if (jsonObject.get("unionid") != null) {
            vo.setUnionId(jsonObject.get("unionid").toString());
        }
        return vo;
    }

    private String getAccessToken() {
        JSONObject jsonObject = weChatTokenFeign.getAccessToken(GRANT_TYPE, APP_ID_SNS, APP_SECRET_SNS);
        if (jsonObject == null || jsonObject.get("access_token") == null) {
            throw new AppException((String) jsonObject.get("errcode"), (String) jsonObject.get("errmsg"));
        }
        String accessToken = (String) jsonObject.get("access_token");
        return accessToken;
    }
}

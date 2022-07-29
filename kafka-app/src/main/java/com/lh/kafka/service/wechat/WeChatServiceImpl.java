package com.lh.kafka.service.wechat;

import com.alibaba.fastjson.JSONObject;
import com.lh.kafka.exception.AppException;
import com.lh.kafka.feign.WeChatSnsFeign;
import com.lh.kafka.feign.WeChatTokenFeign;
import com.lh.kafka.request.wechat.WechatLoginRequest;
import com.lh.kafka.vo.wechat.JsCodeSessionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author: ywx
 * @description
 * @Date: 2022/07/19
 */
@Service
public class WeChatServiceImpl implements WeChatService {
    private static final String GRANT_TYPE = "client_credential";
    private static final String APP_ID_SNS = "12345";
    private static final String APP_SECRET_SNS = "231213";
    private static final String AUTHORIZATION_CODE = "authorization_code";

    @Autowired(required = false)
    private WeChatTokenFeign weChatTokenFeign;

    @Autowired
    private WeChatSnsFeign weChatSnsFeign;

    @Override
    public String getAccessToken() {
        JSONObject jsonObject = weChatTokenFeign.getAccessToken(GRANT_TYPE, APP_ID_SNS, APP_SECRET_SNS);
        if (jsonObject == null || jsonObject.get("access_token") == null) {
            throw new AppException((String) jsonObject.get("errcode"), (String) jsonObject.get("errmsg"));
        }
        String accessToken = (String) jsonObject.get("access_token");
        return accessToken;
    }

    @Override
    public JsCodeSessionVO getJsCodeSession(WechatLoginRequest request) {
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

    @Override
    public String wechatPayCallBack(String callBackXml) {
        return null;
    }

    @Override
    public String wechatRefundCallBack(String callBackXml) {
        return null;
    }
}

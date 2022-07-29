package com.lh.kafka.service.user;


import com.lh.kafka.request.user.LoginRequest;
import com.lh.kafka.request.user.RegisterRequest;
import com.lh.kafka.request.wechat.WechatLoginRequest;
import com.lh.kafka.vo.user.UserVO;

/**
 * @author: ywx
 * @description
 * @Date: 2022/07/18
 */
public interface UserService {

    /**
     * 登录
     * @param request
     * @return
     */
    UserVO login(LoginRequest request);

    /**
     * wechat登录
     * @param request
     * @return
     */
    UserVO wechatLogin(WechatLoginRequest request);

    /**
     * 注册
     * @param request
     * @return
     */
    void register(RegisterRequest request);

}

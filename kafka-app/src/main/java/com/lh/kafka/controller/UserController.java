package com.lh.kafka.controller;

import com.lh.kafka.entitys.JsonResponse;
import com.lh.kafka.request.user.LoginRequest;
import com.lh.kafka.request.user.RegisterRequest;
import com.lh.kafka.request.wechat.WechatLoginRequest;
import com.lh.kafka.service.user.UserService;
import com.lh.kafka.vo.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author: ywx
 * @description
 * @Date: 2022/07/18
 */
@RestController
@RequestMapping("/user")
public class UserController {

    public static final String USER_TOKEN = "User-Token";

    @Autowired
    private UserService userService;

    /**
     * 登录
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/login")
    public JsonResponse<UserVO> login(HttpServletRequest httpServletRequest,
                                      @RequestBody @Valid LoginRequest request) {

        return JsonResponse.success(userService.login(request));
    }

    @PostMapping(value = "/wechatLogin")
    public JsonResponse<UserVO> wechatLogin(HttpServletRequest httpServletRequest,
                                      @RequestBody @Valid WechatLoginRequest request) {

        return JsonResponse.success(userService.wechatLogin(request));
    }

    /**
     * 注册
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/register")
    public JsonResponse<UserVO> register(@RequestBody @Valid RegisterRequest request) {
        userService.register(request);
        return JsonResponse.success();
    }

}

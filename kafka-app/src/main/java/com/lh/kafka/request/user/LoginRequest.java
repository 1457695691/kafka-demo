package com.lh.kafka.request.user;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author: ywx
 * @description
 * @Date: 2022/07/18
 */
@Data
public class LoginRequest {
    @NotNull(message = "用户名不能为空")
    String userName;
    String password;
}

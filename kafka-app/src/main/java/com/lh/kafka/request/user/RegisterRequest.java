package com.lh.kafka.request.user;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author: ywx
 * @description
 * @Date: 2022/07/18
 */

@Data
public class RegisterRequest {
    @Size(min = 11,max = 11,message = "手机号格式不正确")
    @NotNull(message = "手机号不能为空")
    String phone;
    String password;
}

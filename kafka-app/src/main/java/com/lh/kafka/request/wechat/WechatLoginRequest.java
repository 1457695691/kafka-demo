package com.lh.kafka.request.wechat;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author: ywx
 * @description
 * @Date: 2022/07/19
 */

@Data
public class WechatLoginRequest implements Serializable {
    @NotNull(message = "code不能为空")
    private String code;
    @NotNull(message = "iv属性不能为空")
    private String iv;
    @NotNull(message = "encryptedData不能为空")
    private String encryptedData;
}


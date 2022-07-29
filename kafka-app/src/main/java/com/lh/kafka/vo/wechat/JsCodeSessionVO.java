package com.lh.kafka.vo.wechat;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: ywx
 * @description
 * @Date: 2022/07/19
 */
@Data
public class JsCodeSessionVO implements Serializable {
    private String sessionKey;
    private String jwtToken;
    private String openId;
    private String unionId;
}

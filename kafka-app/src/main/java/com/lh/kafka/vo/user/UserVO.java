package com.lh.kafka.vo.user;

import lombok.Data;

/**
 * @author: ywx
 * @description
 * @Date: 2022/07/18
 */
@Data
public class UserVO {
    Long id;
    String realName;
    String phone;
    String userToken;
    String openId;
}

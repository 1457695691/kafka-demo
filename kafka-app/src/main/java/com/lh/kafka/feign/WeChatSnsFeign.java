package com.lh.kafka.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: ywx
 * @description
 * @Date: 2022/07/19
 */
@FeignClient(name = "WeChatSnsClient", url = "https://api.weixin.qq.com/sns")
public interface WeChatSnsFeign {

    /**
     * 获取登陆session_key
     * @param appid
     * @param secret
     * @param js_code
     * @param grant_type
     * @return
     */
    @GetMapping("/jscode2session")
    String jsCodeSession(@RequestParam("appid") String appid,
                         @RequestParam("secret") String secret,
                         @RequestParam("js_code") String js_code,
                         @RequestParam("grant_type") String grant_type);
}

package com.lh.kafka.feign;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: ywx
 * @description
 * @Date: 2022/07/19
 */

//@FeignClient(name= "WeChatTokenFeign",url = "https://api.weixin.qq.com/cgi-bin")
public interface WeChatTokenFeign {

    /**
     * 获取token
     * @param grant_type
     * @param appid
     * @param secret
     * @return JSONObject
     */
    @GetMapping("/token")
    JSONObject getAccessToken(@RequestParam("grant_type")String grant_type,
                              @RequestParam("appid")String appid,
                              @RequestParam("secret")String secret);

}

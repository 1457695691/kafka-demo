package com.lh.kafka.service.wechat;

import com.lh.kafka.request.wechat.WechatLoginRequest;
import com.lh.kafka.vo.wechat.JsCodeSessionVO;

/**
 * @author: ywx
 * @description
 * @Date: 2022/07/19
 */

public interface WeChatService {
    /**
     * 获取accessToken
     *
     * @return
     */
    String getAccessToken();

    /**
     * 小程序获取登陆session
     *
     * @param request
     * @return
     */
    JsCodeSessionVO getJsCodeSession(WechatLoginRequest request);

    /**
     * 微信交互，生成下单对象
     * 统一下单 (支持微信支付、gat支付)
     * @param
     * @return
     */
//    WXPayVO generatePrePayId(WXPrePayVO wxPrePayVO);

    /**
     * 微信支付回调(vip、order支付)
     *
     * @param callBackXml
     * @return
     */
    String wechatPayCallBack(String callBackXml);

    /**
     * 微信退款回调(vip、order退款)
     *
     * @param callBackXml
     * @return
     */
    String wechatRefundCallBack(String callBackXml);


}

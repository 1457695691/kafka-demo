package com.lh.kafka.entitys;

import lombok.Data;

/**
 * 生产者request
 *
 * @author lh
 */
@Data
public class ProducerRequest {

    /**
     * 银行卡号
     */
    private String idCard;
}

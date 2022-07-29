package com.lh.kafka.service.producer;

/**
 * 生产者service
 *
 * @author lh
 */
public interface ProducerService {

    /**
     * 接受数据存储到Kafka
     *
     * @param idCard
     */
    void produce(String idCard);
}

package com.lh.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 生产者实现类
 *
 * @author lh
 */
@Service
public class ProducerServiceImpl implements ProducerService {

    private static final String TOPIC_NAME = "demo";

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void produce(String idCard) {
        //使用kafka模板发送信息
        if (!StringUtils.hasLength(idCard)) {
            return;
        }
        kafkaTemplate.send(TOPIC_NAME, idCard);
    }
}

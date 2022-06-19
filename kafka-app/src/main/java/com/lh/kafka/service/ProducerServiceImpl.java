package com.lh.kafka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * 生产者实现类
 *
 * @author lh
 */
@Service
@Slf4j
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
        ListenableFuture<SendResult<String, Object>> result = kafkaTemplate.send(TOPIC_NAME, idCard);
        result.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("producer send faild: {}", ex);
            }

            @Override
            public void onSuccess(SendResult<String, Object> result) {
                log.info("producer send success：{}", result.toString());
            }
        });
    }
}

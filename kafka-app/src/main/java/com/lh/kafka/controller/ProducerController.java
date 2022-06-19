package com.lh.kafka.controller;

import com.lh.kafka.entitys.JsonResponse;
import com.lh.kafka.entitys.ProducerRequest;
import com.lh.kafka.error.BaseErrorCodeEnum;
import com.lh.kafka.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * Kafka生产者controller
 *
 * @author lh
 */

@RestController
@RequestMapping("/producer")
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @RequestMapping("/send")
    public JsonResponse send(@RequestBody ProducerRequest producerRequest) {
        if (Objects.isNull(producerRequest) || !StringUtils.hasLength(producerRequest.getIdCard())) {
            return JsonResponse.fail(BaseErrorCodeEnum.ERROR_SYS_1002);
        }
        producerService.produce(producerRequest.getIdCard());
        return JsonResponse.success();
    }

}

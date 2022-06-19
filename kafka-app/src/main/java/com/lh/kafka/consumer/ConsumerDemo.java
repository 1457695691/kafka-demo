package com.lh.kafka.consumer;

import com.lh.kafka.test.dao.CardDAO;
import com.lh.kafka.test.entity.CardDO;
import com.lh.kafka.utils.CardUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 消费者实现demo
 *
 * @author lh
 */
@Component
@Slf4j
public class ConsumerDemo {

    private static final String TOPIC_NAME = "demo";
    private static final String GROUP_ID = "test";

    @Autowired
    private CardDAO cardDAO;


    /**
     * 定义此消费者接收topics = "demo"的消息，与controller中的topic对应上即可
     *
     * @param record 变量代表消息本身，可以通过ConsumerRecord<?,?>类型的record变量来打印接收的消息的各种信息
     */
    @Transactional(rollbackFor = Exception.class)
    @KafkaListener(groupId = GROUP_ID, topics = TOPIC_NAME, containerFactory = "kafkaListenerContainerFactory")
    public void consumer(ConsumerRecord<?, ?> record, Acknowledgment ack) throws Exception {
        log.info("topic is {}, offset is {}, value is {} ", record.topic(), record.offset(), record.value());
        //校验卡号是否有效
        if (CardUtils.isBankCard(String.valueOf(record.value()))) {
            CardDO cardDO = new CardDO();
            cardDO.setIdCard(String.valueOf(record.value()));
            cardDAO.insert(cardDO);
        } else {
            //业务错误处理
            log.error("topic:{} is error ,offset is {}, value is {}.", record.topic(), record.offset(), record.value());
        }
        //手动ack
        ack.acknowledge();
        log.info("kafka processMessage end");
    }
}

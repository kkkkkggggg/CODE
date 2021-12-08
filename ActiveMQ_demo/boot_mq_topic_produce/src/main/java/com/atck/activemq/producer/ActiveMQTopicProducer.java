package com.atck.activemq.producer;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Topic;
import java.util.UUID;

@Component
// @EnableScheduling
public class ActiveMQTopicProducer
{
    @Autowired
    private Topic activeMQTopic;

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Scheduled(fixedDelay = 3000L)
    public void produceMsg()
    {
        jmsMessagingTemplate.convertAndSend(activeMQTopic,"boot_mq_topic_producer" + UUID.randomUUID().toString().substring(1,5));
    }
}

package com.atck.activemq.produce;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Component
@EnableScheduling
public class Queue_Produce
{
    //JmsMessagingTemplate是Springboot的Jms模板,Spring的是JmsTemplate
    @Autowired
    private  JmsMessagingTemplate jmsMessagingTemplate;

    //把ConfigBean类的ActiveMQQueue注入进来
    @Autowired
    private  ActiveMQQueue activeMQQueue;

    //构造注入对象(推荐)
    // @Autowired
    // public Queue_Produce(JmsMessagingTemplate jmsMessagingTemplate, ActiveMQQueue activeMQQueue) {
    //     this.jmsMessagingTemplate = jmsMessagingTemplate;
    //     this.activeMQQueue = activeMQQueue;
    // }

    //发送Queue的方法
    //间隔时间三秒钟定投
    @Scheduled(fixedDelay = 3000L)
    public void produceMsg() {
        jmsMessagingTemplate.convertAndSend(activeMQQueue, "**************" + UUID.randomUUID().toString());
    }





}

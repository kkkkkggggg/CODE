package com.atck.activemq.consumer;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Service
public class ActiveMQTopicConsumer
{
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @JmsListener(destination = "${my.topic.name}")
    public void receiveMsg(TextMessage textMessage) throws JMSException
    {
       System.out.println(textMessage.getText());
   }
}

package com.atck.activemq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Service
public class Queue_Consumer
{
    //监听接收的方法
    @JmsListener(destination = "${my.queue.name}")
    public void consumerMsg(TextMessage textMessage) throws JMSException {
        String text = textMessage.getText();
        System.out.println("***:    " + text);
    }
}

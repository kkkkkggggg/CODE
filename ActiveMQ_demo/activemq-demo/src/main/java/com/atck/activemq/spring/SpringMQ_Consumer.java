package com.atck.activemq.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.StreamMessage;
import javax.jms.TextMessage;

@Service
public class SpringMQ_Consumer
{
    @Autowired
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) throws JMSException
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        SpringMQ_Consumer spring_consumer = (SpringMQ_Consumer) context.getBean("springMQ_Consumer");

        // TextMessage textMessage = (TextMessage) spring_consumer.jmsTemplate.receive();
        // System.out.println(textMessage.getText());

        String s = (String) spring_consumer.jmsTemplate.receiveAndConvert();
        System.out.println(s);
    }
}

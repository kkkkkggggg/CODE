package com.atck.activemq.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.DeliveryMode;

@Service
public class SpringMQ_Produce
{
    @Autowired
    private JmsTemplate jmsTemplate;

    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        SpringMQ_Produce springMQ_produce = (SpringMQ_Produce) context.getBean("springMQ_Produce");


        springMQ_produce.jmsTemplate.send((session) -> {
            return session.createTextMessage("*******spring和activeMQ的整合case********");
        });

        System.out.println("******send task over*********");
    }
}

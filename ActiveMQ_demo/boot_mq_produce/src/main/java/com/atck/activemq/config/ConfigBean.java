package com.atck.activemq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@Configuration
@EnableJms
public class ConfigBean
{
    @Value("${my.queue.name}")
    private String myQueueName;

    @Bean
    public ActiveMQQueue queue() {
        //创建一个ActiveMQQueue
        return new ActiveMQQueue(myQueueName);
    }
}

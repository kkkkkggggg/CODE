package com.atck.activemq.Config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsMessagingTemplate;

import javax.jms.Topic;

@Configuration
@EnableJms
public class ConfigBean
{
    @Value("${my.topic.name}")
    private String myTopicName;

    @Bean
    public Topic topic() {
        //创建一个ActiveMQQueue
        return new ActiveMQTopic(myTopicName);
    }
}

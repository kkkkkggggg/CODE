package com.atck.atck.hello.auto;

import com.atck.atck.hello.bean.HelloProperties;
import com.atck.atck.hello.service.HelloService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

@EnableConfigurationProperties(HelloProperties.class)//默认HelloProperties放在容器中
public class HelloServiceAutoConfiguration
{
    @ConditionalOnMissingBean(HelloService.class)
    @Bean
    public HelloService helloService()
    {
        HelloService helloService = new HelloService();

        return helloService;
    }
}

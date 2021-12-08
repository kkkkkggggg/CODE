package com.atck.boot.config;

import com.atck.atck.hello.bean.HelloProperties;
import com.atck.atck.hello.service.HelloService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig
{
    @Bean
    public HelloService helloService()
    {
        HelloService helloService = new HelloService();

        return helloService;
    }
}

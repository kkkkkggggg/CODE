package com.atck.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration//作为配置类，替代xml文件
@ComponentScan(basePackages = {"com.atck"})
public class SpringConfig
{
}

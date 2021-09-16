package com.atck.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.atck"})
@EnableAspectJAutoProxy(proxyTargetClass = true )
public class ConfigAOP
{
}

package com.atck.gmall;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ImportResource;

/**
 * 1.导入依赖；
 *      1.导入dubbo-starter
 *      2.导入dubbo的其他依赖
 */
// @EnableDubbo//开启基于注解的dubbo功能，通过注解方式整合springboot
@SpringBootApplication
// @ImportResource(locations = "classpath:provider.xml") //保留xml配置文件，通过配置文件的方式整合springboot
@EnableDubbo(scanBasePackages = "com.atck.gmall")
@EnableHystrix//开启服务容错
public class BootUserServiceProviderApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(BootUserServiceProviderApplication.class, args);
    }

}

package com.atck.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

// @MapperScan("com.atck.admin.mapper")
@SpringBootApplication(exclude = RedisAutoConfiguration.class)
@ServletComponentScan(basePackages = "com.atck.admin")//指定原生Servlet组件都放在哪，原生的会直接响应，没有经过Spring的拦截
public class Boot05WebAdminApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(Boot05WebAdminApplication.class, args);
    }


}

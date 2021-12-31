package com.atck.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.atck.springcloud.dao"})
public class MyBatisConfig
{

}

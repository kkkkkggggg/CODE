package com.atck.boot.listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component//应用启动，做一个一次性事情
@Order(1)
public class MyApplicationRunner implements ApplicationRunner
{
    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        System.out.println("MyApplicationRunner......run......");
    }
}

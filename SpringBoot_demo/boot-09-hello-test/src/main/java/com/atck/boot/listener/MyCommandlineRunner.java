package com.atck.boot.listener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class MyCommandlineRunner implements CommandLineRunner
{
    @Override
    public void run(String... args) throws Exception
    {
        System.out.println("MyCommandlineRunner......run......");
    }
}

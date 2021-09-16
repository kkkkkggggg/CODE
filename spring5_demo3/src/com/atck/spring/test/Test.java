package com.atck.spring.test;

import com.atck.spring.config.SpringConfig;
import com.atck.spring.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test
{
    @org.junit.Test
    public void test()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        UserService userService = context.getBean("userService",UserService.class);

        userService.add();
    }

    @org.junit.Test
    public void test1()
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean("userService",UserService.class);

        userService.add();
    }
}

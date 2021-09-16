package com.atck.spring.test;

import com.atck.spring.aopanno.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOP
{
    @Test
    public void testAopAnno()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        User user = context.getBean("user", User.class);

        user.add();
    }
}

package com.atck.spring.test;

import com.atck.spring.collectiontype.Course;
import com.atck.spring.factorybean.MyBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactoryBean
{
    @Test
    public void test()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");

        Course myBean = context.getBean("myBean", Course.class);

        System.out.println(myBean);

    }
}

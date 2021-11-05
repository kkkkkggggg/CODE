package com.atck.spring.test;

import com.atck.spring.autowire.Emp;
import com.atck.spring.bean.Orders;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBean
{
    @Test
    public void test()
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");

        Orders order = context.getBean("order", Orders.class);

        System.out.println(order);


        //手动销毁bean实例
        context.close();
    }

    @Test
    public void test1()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean5.xml");
        Emp emp = context.getBean("emp", Emp.class);

        System.out.println(emp);
    }
}

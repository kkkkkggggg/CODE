package com.atck.spring.testdemo;

import com.atck.spring.Book;
import com.atck.spring.Order;
import com.atck.spring.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.awt.AppContext;

public class TestSpring5
{
    @Test
    public void testAdd()
    {
        //1.加载Spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        //获取配置创建的对象
        User user = context.getBean("user", User.class);
        System.out.println(user);
        user.add();
    }

    @Test
    public void testBook()
    {
        //1.加载Spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        //获取配置创建的对象
        Book book = context.getBean("book", Book.class);
        System.out.println(book);
    }

    @Test
    public void testOrder()
    {
        //1.加载Spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        //获取配置创建的对象
        Order order = context.getBean("order", Order.class);
        System.out.println(order);
    }
}

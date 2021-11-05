package com.atck.spring.testdemo;

import com.atck.spring.bean.Employee;
import com.atck.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBean
{
    @Test
    public void testAdd()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");

        UserService userService = context.getBean("userService", UserService.class);

        userService.add();


    }

    @Test
    public void testEmployee()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Employee employee = context.getBean("employee",Employee.class);

        System.out.println(employee);
    }

    @Test
    public void testEmployee1()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        Employee employee = context.getBean("employee",Employee.class);

        System.out.println(employee);
    }

    @Test
    public void testEmployee2()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean5.xml");
        Employee employee = context.getBean("employee",Employee.class);

        System.out.println(employee);
    }
}

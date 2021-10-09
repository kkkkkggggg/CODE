package com.atck.test;

import com.atck.bean.Boss;
import com.atck.bean.Car;
import com.atck.bean.Color;
import com.atck.config.MainConfigOfAutowired;
import com.atck.dao.BookDAO;
import com.atck.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOVTest_Autowired
{
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);

    private void printBeanNames(AnnotationConfigApplicationContext context)
    {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();

        for (String s : beanDefinitionNames)
        {
            System.out.println(s);
        }
    }

    @Test
    public void test01()
    {
        printBeanNames(context);

        System.out.println("=========================");

        BookService bookService = context.getBean("bookService", BookService.class);

        bookService.print();
    }


    @Test
    public void test02()
    {
        printBeanNames(context);

        System.out.println("=========================");
        Car car = context.getBean("car", Car.class);

        Boss boss = context.getBean("boss", Boss.class);
        System.out.println(boss);


        Color color = context.getBean("color", Color.class);
        System.out.println(color);

        System.out.println(boss.getCar() == car && car == color.getCar());

        System.out.println(context);
        context.close();
    }
}

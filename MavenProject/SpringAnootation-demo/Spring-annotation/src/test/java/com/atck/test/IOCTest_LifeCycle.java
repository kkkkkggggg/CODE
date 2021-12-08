package com.atck.test;

import com.atck.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_LifeCycle
{


    @Test
    public void test01()
    {
        //1.创建ioc容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器构建完成。。。。。。");

        Object car = context.getBean("car");

        System.out.println(car);

        //2.关闭容器
        context.close();
    }

    @Test
    public void test02()
    {
        //1.创建ioc容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器构建完成。。。。。。");

        Object cat = context.getBean("cat");

        System.out.println(cat);

        //2.关闭容器
        context.close();
    }

    @Test
    public void test03()
    {
        //1.创建ioc容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器构建完成。。。。。。");

        Object dog = context.getBean("dog");

        System.out.println(dog);

        //2.关闭容器
        context.close();
    }

    @Test
    public void test04()
    {
        //1.创建ioc容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器构建完成。。。。。。");

        Object myBeanPostProcessor = context.getBean("myBeanPostProcessor");

        System.out.println(myBeanPostProcessor);

        //2.关闭容器
        context.close();
    }
}

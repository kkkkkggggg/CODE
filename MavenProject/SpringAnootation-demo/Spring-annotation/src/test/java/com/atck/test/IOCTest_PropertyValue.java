package com.atck.test;

import com.atck.bean.Person;
import com.atck.config.MainConfigOfPropertyValues;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class IOCTest_PropertyValue
{
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);

    @Test
    public void test01()
    {
        printBeanNames(context);

        System.out.println("=========================");

        Person person = context.getBean("person", Person.class);

        System.out.println(person);

        ConfigurableEnvironment environment = context.getEnvironment();
        System.out.println(environment.getProperty("person.nickName"));

        context.close();
    }

    private void printBeanNames(AnnotationConfigApplicationContext context)
    {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();

        for (String s : beanDefinitionNames)
        {
            System.out.println(s);
        }
    }
}

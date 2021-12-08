package com.atck.test;

import com.atck.config.MainConfig;
import com.atck.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest
{
    public static void main(String[] args)
    {
        // ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        //
        // Person person = applicationContext.getBean("person", Person.class);
        //
        // System.out.println(person);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);

        System.out.println(applicationContext.getBean("person"));

        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);

        for (String s : beanNamesForType)
        {
            System.out.println(s);
        }
    }
}

package com.atck.test;

import com.atck.bean.Blue;
import com.atck.bean.Person;
import com.atck.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

public class MainTest02
{
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);


    @Test
    public void test()
    {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String s : beanDefinitionNames)
        {
            System.out.println(s);
        }

        //默认是单实例的
        Person person = context.getBean("person", Person.class);
        Person person1 = context.getBean("person", Person.class);

        System.out.println(person);
        System.out.println(person1);
        System.out.println(person==person1);

    }

    @Test
    public void test01()
    {
        String[] beanDefinitionNames = context.getBeanNamesForType(Person.class);
        ConfigurableEnvironment environment = context.getEnvironment();
        //获取环境变量的值：windows10
        String property = environment.getProperty("os.name");

        for (String s : beanDefinitionNames)
        {
            System.out.println(s);
        }

        Map<String, Person> beansOfType = context.getBeansOfType(Person.class);

        System.out.println(beansOfType);

        System.out.println(property);
    }

    @Test
    public void test02()
    {
        String[] beanDefinitionNames = context.getBeanNamesForType(Person.class);



        for (String s : beanDefinitionNames)
        {
            System.out.println(s);
        }

        Map<String, Person> beansOfType = context.getBeansOfType(Person.class);

        System.out.println(beansOfType);


    }

    private void printBeans(AnnotationConfigApplicationContext context)
    {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();

        for (String s : beanDefinitionNames)
        {
            System.out.println(s);
        }
    }

    @Test
    public void testImport()
    {

        printBeans(context);
        Blue bean = context.getBean(Blue.class);

        System.out.println(bean);

        //工厂bean获取的是调用getObject创建的对象
        Object colorFactory = context.getBean("colorFactory");
        Object colorFactory2 = context.getBean("colorFactory");
        System.out.println("beanD的类型：" + colorFactory.getClass());

        System.out.println(colorFactory == colorFactory2);

        //获取时在id前加&，可以获取到工厂bean
        Object colorFactory3 = context.getBean("&colorFactory");
        System.out.println(colorFactory3);
    }
}

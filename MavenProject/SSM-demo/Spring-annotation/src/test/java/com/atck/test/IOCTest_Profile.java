package com.atck.test;

import com.atck.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.StringValueResolver;

public class IOCTest_Profile
{





    //1.使用命令行动态参数切换环境，在虚拟机参数位置加载:  -Dspring.profiles.active=test
    //2.代码的方式激活环境
    @Test
    public void test01()
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //1.创建一个applicationContext
        //2.设置需要激活的环境
        context.getEnvironment().setActiveProfiles("test","dev");
        //3.注册主配置类
        context.register(MainConfigOfProfile.class);
        //4.启动刷新容器
        context.refresh();

        printBeanNames(context);




        context.close();
    }

    private void printBeanNames(ApplicationContext context)
    {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();

        for (String s : beanDefinitionNames)
        {
            System.out.println(s);
        }
    }
}

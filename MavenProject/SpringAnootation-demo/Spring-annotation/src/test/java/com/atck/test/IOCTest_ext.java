package com.atck.test;

import com.atck.ext.ExtConfig;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_ext
{
    @Test
    public void test()
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ExtConfig.class);

        context.publishEvent(new ApplicationEvent(new String("我发布的事件"))
        {});


        context.close();
    }

    @Test
    public void test02()
    {

    }
}

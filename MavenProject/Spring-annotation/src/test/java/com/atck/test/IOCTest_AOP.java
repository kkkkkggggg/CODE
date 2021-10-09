package com.atck.test;

import com.atck.aop.MathCalculator;
import com.atck.config.MainConfigOfAOP;
import org.junit.Test;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_AOP
{
    @Test
    public void test01()
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);

        MathCalculator mathCalculator = context.getBean("mathCalculator", MathCalculator.class);

        int div = mathCalculator.div(6, 2);
        // org.springframework.beans.factory.support.DefaultListableBeanFactory
    }
}

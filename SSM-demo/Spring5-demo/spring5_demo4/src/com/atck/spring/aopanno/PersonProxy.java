package com.atck.spring.aopanno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class PersonProxy
{
    @Before(value = "execution(* com.atck.spring.aopanno.User.add(..))")
    public void before()
    {
        System.out.println("person before......");
    }
}

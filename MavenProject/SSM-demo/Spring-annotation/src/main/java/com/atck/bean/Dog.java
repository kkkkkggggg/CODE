package com.atck.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Dog implements ApplicationContextAware
{
    public Dog()
    {
        System.out.println("dog constructor....");
    }

    private ApplicationContext applicationContext;
    //对象创建并赋值之后调用
    @PostConstruct
    public void init()
    {
        System.out.println("dog ....@PostConstruct......");
    }

    //在容器移除对象之前
    @PreDestroy
    public void destroy()
    {
        System.out.println("dog....@PreDestroy......");
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {
        this.applicationContext = applicationContext;
    }
}

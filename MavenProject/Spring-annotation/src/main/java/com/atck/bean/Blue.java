package com.atck.bean;

import org.springframework.beans.factory.config.BeanPostProcessor;

public class Blue
{
    public Blue()
    {
        System.out.println("blue.....constructor...");
    }

    public void init()
    {
        System.out.println("blue...init....");
    }

    public void destroy()
    {
        System.out.println("blue...destroy...");
    }
}

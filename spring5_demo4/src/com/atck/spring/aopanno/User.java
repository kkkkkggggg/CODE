package com.atck.spring.aopanno;

import org.springframework.stereotype.Component;

@Component
public class User
{
    //被增强的方法
    public void add()
    {

        System.out.println("add.........");
    }


}

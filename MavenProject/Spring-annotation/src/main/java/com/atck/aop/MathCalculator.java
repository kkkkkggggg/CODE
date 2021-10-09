package com.atck.aop;


import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;

public class MathCalculator
{

    public int div(int i,int j)
    {
        System.out.println("MathCalculator....div.....");
        return i / j;


    }
}

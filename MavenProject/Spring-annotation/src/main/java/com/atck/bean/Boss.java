package com.atck.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//默认加在ioc容器中的组件，容器启动会调用无参构造器创建对象，再进行初始化赋值操作
@Component
public class Boss
{
    private Car car;

    //构造器要用的组件，都是从容器中获取
    //当前类只有一个有参构造器@Autowired可以省略
    // @Autowired
    private Boss(/*@Autowired*/ Car car)
    {
        this.car = car;
        System.out.println("Boss...有参构造器");
    }

    @Override
    public String toString()
    {
        return "Boos{" + "car=" + car + '}';
    }

    public Car getCar()
    {
        return car;
    }

    //@Autowired//标注在方法上，Spring容器创建当前对象，就会调用方法，完成赋值
    //方法使用的参数，自定义类型的值从IOC容器中获取
    public void setCar(Car car)
    {
        this.car = car;
    }
}

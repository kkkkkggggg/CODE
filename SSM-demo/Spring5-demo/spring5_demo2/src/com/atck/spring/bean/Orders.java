package com.atck.spring.bean;

public class Orders
{
    private String oName;

    public Orders()
    {
        System.out.println("第一步 执行无参构造器创建bean实例");
    }

    public void setoName(String oName)
    {
        System.out.println("第二步 调用det方法设置属性的值");
        this.oName = oName;
    }

    //创建bean的初始化方法
    public void initMethod()
    {
        System.out.println("第三步 执行bean的初始化方法");
    }

    //创建销毁的方法
    public void desMethod()
    {
        System.out.println("第五步 执行bean的销毁方法");
    }


    @Override
    public String toString()
    {
        return "Orders{" + "oName='" + oName + '\'' + '}';
    }
}

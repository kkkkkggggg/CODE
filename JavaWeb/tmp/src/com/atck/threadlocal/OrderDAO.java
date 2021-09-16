package com.atck.threadlocal;

public class OrderDAO
{
    public void svaOrder()
    {
        String name = Thread.currentThread().getName();
        // System.out.println("OrderDAO  当前线程["+ name +"]中保存的数据是：" + ThreadLocalTest.data.get(name));
        System.out.println("OrderDAO  当前线程["+ name +"]中保存的数据是：" + ThreadLocalTest.threadLocal.get());
    }
}

package day07;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 如何自定义泛型结构：泛型类、泛型接口、泛型方法
 * 1.关于自定义泛型类、泛型接口
 *
 *
 *
 *
 *
 * @acthor KKKKK
 * @creay 2021-04-22-{TIME}
 */
public class GenericTest1
{
    @Test
    public void test()
    {
        //如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型
        //要求：如果定义了泛型类，那么在使用时建议指明类的泛型
        Order order = new Order();
        order.setOrderT(123);
        order.setOrderT("ABC");

        //建议，实例化时指明类的泛型
        Order<String> order1 = new Order<String>("orderAA",1001,"order:AA");

        order1.setOrderT("AA:hello");
    }

    @Test
    public void test1()
    {
        SubOrder subOrder = new SubOrder();
        //由于子类在继承带泛型的父类时指明了泛型的类型，则实例化子类对象时，不需要再指明泛型类型
        subOrder.setOrderT(1122);

        SubOrder1<String> subOrder1 = new SubOrder1<String>();
        subOrder1.setOrderT("order2....");

    }

    @Test
    public void test2()
    {
        ArrayList<String> list = null;
        ArrayList<Integer> list1 = null;
        //泛型类型不同的引用不能互相赋值
//        list = list1;
    }


    //测试泛型方法
    @Test
    public void test3()
    {
        Order<String> order = new Order<String>();

        Integer[] arr = new Integer[]{1,2,3,4};

        //泛型方法在调用时，指明泛型参数的类型
        List<Integer> list = order.copyFromArrayToList(arr);

        System.out.println(list);
    }


}

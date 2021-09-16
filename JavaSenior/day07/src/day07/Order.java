package day07;

import java.util.ArrayList;
import java.util.List;

/**
 * @acthor KKKKK
 * @creay 2021-04-22-{TIME}
 */
public class Order<T>
{
    String orderName;
    int orderId;

    //类的内部结构就可以使用类的泛型

    T orderT;

    public Order()
    {
        //编译不通过
//        T[] arr = new T[10];

//        T[] arr = (T[]) new Object()[10];

    };

    public Order(String orderName,int orderId,T orderT)
    {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }


    //如下的方法不是泛型方法
    public T getOrderT()
    {
        return  orderT;
    }

    public void setOrderT(T orderT)
    {
        this.orderT = orderT;
    }

    //静态方法中不能使用类的泛型
//    public static void show(T orderT)
//    {
//        System.out.println(orderT);
//    }


    @Override
    public String toString()
    {
        return "Order{" + "orderName='" + orderName + '\'' + ", orderId=" + orderId + ", orderT=" + orderT + '}';
    }

    public void show()
    {
        //编译不通过
//        try
//        {
//
//        }catch(T t)
//        {
//
//        }
    }

    //泛型方法：在方法声明处出现了泛型结构，泛型参数与类的泛型参数没有任何关系
    //换句话说，泛型方法所在的类是不是泛型类都没有关系
    //泛型方法可以声明为静态的，原因：泛型参数是在调用时确定的，并非在实例化时确定
    public <E> List<E> copyFromArrayToList(E[] arr)
    {
        ArrayList<E> list = new ArrayList<E>();

        for(E e :arr)
        {
            list.add(e);
        }
        return list;
    }
}

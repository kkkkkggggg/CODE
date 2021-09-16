package day05_02_Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 *jdk5.0新增了foreach循环，用于遍历数组，集合
 *
 * @acthor KKKKK
 * @creay 2021-04-20-{TIME}
 */
public class ForTest
{
    @Test
    public void test()
    {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new java.lang.String("tom"));
        coll.add(new Person("jerry",20));
        coll.add(false);

        //for(集合中元素的类型 局部变量 : 集合对象)
        //内部仍然调用了迭代器
        for(Object obj:coll)
        {
            System.out.println(obj);
        }
    }

    @Test
    public void test1()
    {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};

        for(int i : arr)
        {
            System.out.println(i);
        }

        int[][] arr1 = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        for(int[] i : arr1)
        {
           for(int j : i)
           {
               System.out.println(j);
           }
        }
    }

    @Test
    public void test2()
    {
        String[] arr = new String[]{"MM","MM","MM"};

        //方式一：普通for赋值
//        for(int i = 0; i < arr.length;i++)
//        {
//            arr[i] = "GG";
//        }

        //方式二：增强for赋值
        for(String s : arr)
        {
            s = "GG";
        }

        for(int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }
    }
}

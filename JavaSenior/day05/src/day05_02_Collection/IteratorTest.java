package day05_02_Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合元素遍历操作，使用迭代器Iterator接口
 * 1.内部的方法hasNext()和next()
 * 2.集合对象每次调用iterator()方法都会的到一个全新的迭代器对象，默认游标都在集合的第一个元素之前
 * 3.内部定义了remove(),可以在便利的是否，删除集合中的元素，此方法不同于集合中直接调用remove()
 *
 * @acthor KKKKK
 * @creay 2021-04-20-{TIME}
 */
public class IteratorTest
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

        Iterator iterator = coll.iterator();
        //方式一
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        //报异常：NoSuchElementException
//        System.out.println(iterator.next());

        //方式二
//        for(int i = 0; i < coll.size(); i++)
//        {
//            System.out.println(iterator.next());
//        }

        //方式三：推荐
        //hasNext():判断是否还有下一个元素
        while(iterator.hasNext())
        {
            //next()：①指针下移②将下移后集合位置上的元素返回
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test1()
    {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new java.lang.String("tom"));
        coll.add(new Person("jerry",20));
        coll.add(false);

        //错误方式一：
//        Iterator iterator = coll.iterator();
//        while(iterator.next() != null)
//        {
//            System.out.println(iterator.next());
//        }

        //错误方式二,死循环
        //集合对象每次调用iterator()方法都会的到一个全新的迭代器对象，默认游标都在集合的第一个元素之前
//        while(coll.iterator().hasNext())
//        {
//            System.out.println(coll.iterator().next());
//        }

        //测试Iterator中的remove
        //如果还未调用next()或在上一次调用next方法后已经调用了remove方法再调remove都会报IllegalStateExpection
        Iterator iterator = coll.iterator();

        while(iterator.hasNext())
        {
            Object obj = iterator.next();

            //删除集合中“tom”数据
            if("tom".equals(obj))
            {
                iterator.remove();
            }
        }

        //遍历集合
        Iterator iterator1 = coll.iterator();
        while(iterator1.hasNext())
        {
            System.out.println(iterator1.next());
        }
    }
}

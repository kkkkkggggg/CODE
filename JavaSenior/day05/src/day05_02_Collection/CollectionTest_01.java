package day05_02_Collection;

import org.junit.Test;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Collection中常用方法的测试
 * 向Collection接口的实现类的对象中添加数据obj时，要求obj所在类重写equals()
 *
 * @acthor KKKKK
 * @creay 2021-04-20-{TIME}
 */
public class CollectionTest_01
{
    @Test
    public void test()
    {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new java.lang.String("tom"));
        coll.add(false);
//       Person p = new Person("jerry",20);
//        coll.add(p);
        coll.add(new Person("jerry",20));

        //1.contains(Object obj):判断当前集合中是否包含obj
        //我们在判断时会调用obj对象所在类的equals(),
        boolean contains = coll.contains(123);
        System.out.println(contains);//true
        System.out.println(coll.contains(new java.lang.String("tom")));//true
//        System.out.println(coll.contains(p));//true

        //当Person类中没有重写equals()方法时，相当于调用 == ，此时返回false，重写equals()后
        //比较的时两个对象的实际内容，此时返回true
        System.out.println(coll.contains(new Person("jerry",20)));//true


        //2.containsAll(Collection coll1):判断形参coll1中所有的元素是否都在当前集合中
        Collection coll1 = Arrays.asList(123,456);

        System.out.println(coll.containsAll(coll1));
    }

    @Test
    public void test1()
    {
        //3.remove(Object obj):从当前集合中移除obj元素
        //移除obj元素时也会调用obj所在类的equals()进行判断
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new java.lang.String("tom"));
        coll.add(new Person("jerry",20));
        coll.add(false);

        coll.remove(123);
        System.out.println(coll);

        coll.remove(new Person("jerry",20));
        System.out.println(coll);

        //4.removeAll(Collection coll1):从当前集合中移除coll1中所有的元素
        Collection coll1 = Arrays.asList(123,4567);
        coll.removeAll(coll1);
        System.out.println(coll);
    }

    @Test
    public void test2()
    {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new java.lang.String("tom"));
        coll.add(new Person("jerry",20));
        coll.add(false);

        //5.retainAll(Collection coll1):交集：获取当前集合和coll1集合的交集，并返回给当前集合
//        Collection coll1 = Arrays.asList(123,456,789);
//        coll.retainAll(coll1);
//        System.out.println(coll);

        //6.equals(Object obj):要想返回true，需要当前集合和形参集合的元素都相同
        // ArrayList是有序的，此时比较的两个集合必须元素顺序也一致
        Collection coll1 = new ArrayList();
        coll1.add(123);
        coll1.add(456);
        coll1.add(new java.lang.String("tom"));
        coll1.add(new Person("jerry",20));
        coll1.add(false);

        System.out.println(coll.equals(coll1));
    }

    @Test
    public void test3()
    {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new java.lang.String("tom"));
        coll.add(new Person("jerry",20));
        coll.add(false);

        //7.hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());

        //8.集合--->数组：toArray()
        Object[] arr = coll.toArray();
        for(int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }

        //数组--->集合:调用Arrays类的静态方法asList()
        List<String> list = Arrays.asList(new String[]{"AA","BB","CC"});
        System.out.println(list);

        List<int[]> arr1 =  Arrays.asList(new int[]{123,456});
        System.out.println(arr1);//[[I@722c41f4]
        System.out.println(arr1.size());//1  此时new int[]{123,456}被识别为一个元素

        List arr2 =  Arrays.asList(123,456);
        System.out.println(arr2);//123,456

        List arr3 = Arrays.asList(new Integer[]{123,456});
        System.out.println(arr3.size());//2


        //9.iterator():返回Iterator接口的实例，用于遍历集合元素，放在IteratorTest.java中讲
    }
}



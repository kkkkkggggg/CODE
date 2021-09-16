package day07;

import org.junit.Test;

import java.util.*;

/**
 *
 * 泛型的使用
 * 1.JDK5.0新增的特性
 * 2.在集合中使用泛型
 * 总结：
 * ①集合接口或集合类在JDK5.0的时候都修改为带泛型的结构
 * ②在实例化集合类时可以指明具体的泛型类型
 * ③指明完以后，在集合类或接口中方式定义类或接口时，内部结构使用到类的泛型的位置，都指定为实例化时指定的泛型类型
 * 比如:add(E e) ----> 实例化以后：add(Integer e)
 * ④注意泛型的类型必须是一个类，不能是基本数据类型，需要用到基本数据类型的地方，用包装类替换
 * ⑤如果实例化时没有指明泛型的类型，则默认类型为java.lang.Object类型
 *
 * 3.如何自定义泛型结构：泛型类、泛型接口、泛型方法//见GenericTest1
 *
 *
 *
 * @acthor KKKKK
 * @creay 2021-04-22-{TIME}
 */

public class GenericTest
{
    @Test
    //在集合中没有使用泛型的情况
    public void test()
    {
        ArrayList list = new ArrayList();

        //需求：存放学生的成绩
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);

        //问题一：类型不安全
        list.add("Tom");

        for(Object score : list)
        {
            //问题二：强转时有可能出现类型转换异常ClassCastException
            int stuScore = (int) score;

            System.out.println(stuScore);
        }
    }

    //在集合中使用泛型的情况
    @Test
    public void test1()
    {
        ArrayList<Integer> list = new ArrayList<>();

        //编译时，就会进行类型检查，保证数据的安全
//        list.add("Tom");
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);


        //方式一
//        for(Integer score : list)
//        {
//            //避免了强转操作
//            int stuScore = score;
//            System.out.println(stuScore);
//        }

        //方式二
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext())
        {
            int score = iterator.next();

            System.out.println(score);
        }
    }

    //在集合中使用泛型的情况：以HashMap为例
    @Test
    public void test2()
    {
//        HashMap<String, Integer> map = new HashMap<String, Integer>();
        //JDK7新特性，类型推断
        HashMap<String, Integer> map = new HashMap();


        map.put("Tom",87);
        map.put("Jerry",87);
        map.put("Jack",67);

//        map.put(123,"ABC");

        //泛型的嵌套
        //Entry是Map的内部类，要使用到Map的内部结构：Map.Entry,如果要去掉Map，则需要导包java.util.Map.*;
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = set.iterator();

        while(iterator.hasNext())
        {
            Map.Entry<String, Integer> next = iterator.next();
            String key = next.getKey();
            Integer value = next.getValue();
            System.out.println(key + "-----" + value);
        }
    }



}

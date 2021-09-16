package day06_MapTest;

import org.junit.Test;

import java.util.*;

/**
 * @acthor KKKKK
 * @creay 2021-04-22-{TIME}
 */
public class TreeMapTest
{
    //向TreeMap中添加key-value，要求key必须是由同一个类创建的对象
    //因为要按照key进行排序：自然排序、定制排序

    @Test
    public void test()
    {
        //自然排序
        TreeMap map = new TreeMap();

        User u1 = new User("A",23);
        User u2 = new User("B",32);
        User u3 = new User("C",20);
        User u4 = new User("D",18);

        map.put(u1,98);
        map.put(u2,89);
        map.put(u3,76);
        map.put(u4,100);

        Set set = map.entrySet();

        Iterator iterator = set.iterator();

        while(iterator.hasNext())
        {
            Map.Entry entry = (Map.Entry) iterator.next();

            Object key = entry.getKey();
            Object value = map.get(key);

            System.out.println(key + "---" + value);
        }
    }

    @Test
    public void test1()
    {
        //定制排序
        TreeMap map = new TreeMap(new Comparator()
        {
            @Override
            public int compare(Object o1, Object o2)
            {
                if(o1 instanceof User && o2 instanceof User)
                {
                    User e1 = (User) o1;
                    User e2 = (User) o2;
                    return Integer.compare(e1.getAge(),e2.getAge());
                }
                throw new RuntimeException("输入的数据类型不符合要求");
            }
        });

        User u1 = new User("A",23);
        User u2 = new User("B",32);
        User u3 = new User("C",20);
        User u4 = new User("D",18);

        map.put(u1,98);
        map.put(u2,89);
        map.put(u3,76);
        map.put(u4,100);

        Set set = map.entrySet();

        Iterator iterator = set.iterator();

        while(iterator.hasNext())
        {
            Map.Entry entry = (Map.Entry) iterator.next();

            Object key = entry.getKey();
            Object value = map.get(key);

            System.out.println(key + "---" + value);
        }

    }
}

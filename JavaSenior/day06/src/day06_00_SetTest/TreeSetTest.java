package day06_00_SetTest;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @acthor KKKKK
 * @creay 2021-04-21-{TIME}
 */
public class TreeSetTest
{

    /*
    1.向TreeSet中添加的数据，要求是相同类的对象
    2.两种排序方式：自然排序 和 定制排序


    3.自然排序中，比较两个对象是否相同的标准为：compareTo()返回0，不再是equals()返回true
    4.定制排序中，比较两个对象是否相同的标准为：compareTo()返回0，不再是equals()返回true
     */
    @Test
    public void test()
    {
        TreeSet set = new TreeSet();

        //失败，不能添加不同类的对象
//        set.add(123);
//        set.add(456);
//        set.add("AA");
//        set.add(new User("tom",12));

        //举例一
//        set.add(34);
//        set.add(-34);
//        set.add(43);
//        set.add(11);
//        set.add(8);

        //举例二
        set.add(new User("tom",12));
        set.add(new User("jerry",32));
        set.add(new User("jim",2));
        set.add(new User("nike",65));
        set.add(new User("jack",33));
        set.add(new User("jack",56));

        Iterator iterator = set.iterator();

        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }


    }

    @Test
    public void test1()
    {
        Comparator com = new Comparator()
        {
            //按照年龄从小到大排列
            @Override
            public int compare(Object o1, Object o2)
            {
                if(o1 instanceof User && o2 instanceof User)
                {
                    User user1 = (User)o1;
                    User user2 = (User)o2;

                    return Integer.compare(user1.getAge(),user2.getAge());
                }
                throw new RuntimeException("输入的数据类型不一致");
            }
        };
        TreeSet set = new TreeSet(com);
        set.add(new User("tom",12));
        set.add(new User("jerry",32));
        set.add(new User("jim",2));
        set.add(new User("nike",65));
        set.add(new User("jack",33));
        set.add(new User("jack",56));

        Iterator iterator = set.iterator();

        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }
}

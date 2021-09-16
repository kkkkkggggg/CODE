package day07_exer;

import org.junit.Test;

import java.util.*;

/**
 * @acthor KKKKK
 * @creay 2021-04-21-{TIME}
 */
public class SetTest
{
    //使用自然排序
    @Test
    public void test()
    {
        TreeSet set = new TreeSet();
        set.add(new Employee("d",23,new MyDate(1998,2,16)));
        set.add(new Employee("h",35,new MyDate(1987,6,19)));
        set.add(new Employee("a",41,new MyDate(1981,12,1)));
        set.add(new Employee("f",27,new MyDate(1995,6,21)));
        set.add(new Employee("q",31,new MyDate(1991,4,15)));

        Iterator iterator = set.iterator();

        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }

    }

    @Test
    public void test1()
    {
        //按照生日的顺序排
        TreeSet<Employee> set = new TreeSet<Employee>(new Comparator<Employee>()
        {
            //指明泛型后的写法
            @Override
            public int compare(Employee o1, Employee o2)
            {
                if(o1.getBirthDay().getDate().equals(o2.getBirthDay().getDate()))
                    {
                        //如果生日相同,比较名字
                        return o1.compareTo(o2);
                    }
                    return o1.getBirthDay().getDate().compareTo(o2.getBirthDay().getDate());
            }

            //没有指明泛型时的写法
            //            @Override
//            public int compare(Object o1, Object o2)
//            {
//                if(o1 instanceof Employee && o2 instanceof Employee)
//                {
//                    Employee e1 = (Employee)o1;
//                    Employee e2 = (Employee)o2;
//                    if(e1.getBirthDay().getDate().equals(e2.getBirthDay().getDate()))
//                    {
//                        //如果生日相同,比较名字
//                        return e1.compareTo(e2);
//                    }
//                    return e1.getBirthDay().getDate().compareTo(e2.getBirthDay().getDate());
//                }
//                throw  new RuntimeException("输入的数据不符合要求");
//            }
        });

        set.add(new Employee("d",23,new MyDate(1998,2,16)));
        set.add(new Employee("h",35,new MyDate(1987,6,19)));
        set.add(new Employee("a",41,new MyDate(1981,12,1)));
        set.add(new Employee("f",27,new MyDate(1995,6,21)));
        set.add(new Employee("q",31,new MyDate(1991,4,15)));

        Iterator<Employee> iterator = set.iterator();

        while(iterator.hasNext())
        {
            Employee next = iterator.next();
            System.out.println(next);
        }
    }

    @Test
    public void test2()
    {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(12);
        list.add(13);
        list.add(1723);
        list.add(1233);
        list.add(1234);
        list.add(1283);
        list.add(1723);
        list.add(2123);
        list.add(3123);
        list.add(1123);
        list.add(1023);

        LinkedHashSet set = new LinkedHashSet();

        //将list的所有元素放进set
        //方法一
//        for(int i = 0; i < list.size(); i++)
//        {
//            set.add(list.get(i));
//        }

        //方法二
        set.addAll(list);

//        Iterator iterator = set.iterator();

        //将set中的元素放回list
        //方法一
//        int i = 0;
//        while(iterator.hasNext())
//        {
//            list.set(i,iterator.next());
//            i++;
//        }

        //方法二
        list.clear();
        list.addAll(set);


        Iterator iterator1 = list.iterator();

        while(iterator1.hasNext())
        {
            System.out.println(iterator1.next());
        }
    }


}

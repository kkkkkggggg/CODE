package day07_02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 1.泛型在继承方面的体现
 *
 *
 * 2.通配符的使用
 *
 * @acthor KKKKK
 * @creay 2021-04-22-{TIME}
 */
public class GenericTest
{
    /*
    1.在继承方面的体现

    虽然类A是类B的父类，但是G<A> 和 G<B>二者不具备子父类关系

    补充：类A是类B的父类，A<G>和B<G>仍然是子父类关系
     */

    @Test
    public void test()
    {
        Object obj = null;
        String str = null;

        obj = str;

        Object[] arr1 = null;
        Object[] arr2 = null;
        arr1 = arr2;


        //编译不通过
//        Date date = new Date();
//        str = date;
        List<Object> list = null;
        List<String> list1 = null;
        //此时的list和list1不具有子父类关系
        //编译不通过
//        list = list1;

        show(list);
//        show(list1);
    }

    public void show(List<Object> list)
    {

    }

    /*
    2.通配符的使用
    通配符：?

    虽然类A是类B的父类，但是G<A> 和 G<B>二者不具备子父类关系,二者共同的父类是:G<?>
     */
    @Test
    public void test3()
    {
        List<Object> list = null;
        List<String> list1 = null;

        List<?> list2 = null;

        list2 = list;
        list2 = list1;

        //编译通过
//        print(list);
//        print(list1);

        //
        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list2 = list3;
        //添加:对于List<?>来将，不能向其内部添加数据
        //除了添加null之外
//        list2.add("DD");

        list.add(null);

        //获取(读取)：允许读取数据，读取的数据类型为Object
        System.out.println(list2.get(0));
        Object o = list2.get(0);
    }

    public void print(List<?> list)
    {
        Iterator<?> iterator = list.iterator();
        while(iterator.hasNext())
        {
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }

    /*
    3.有限制条件的通配符的使用
    通配符指定上限
    上限extends：使用时指定的类型必须是继承某个类，或者实现某个接口，即<=
     通配符指定下限
    下限super：使用时指定的类型不能小于操作的类，即>=
     举例：
     <? extends Number> (无穷小 , Number]
    只允许泛型为Number及Number子类的引用调用
     <? super Number> [Number , 无穷大)
    只允许泛型为Number及Number父类的引用调用
     <? extends Comparable>
    只允许泛型为实现Comparable接口的实现类的引用调用
     */

    //? extends Person:只允许泛型为Person及Person子类的引用调用
    //? super Person:只允许泛型为Person及Person父类的引用调用
    @Test
    public void test4()
    {
        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<Student> list3 = new ArrayList<>();
        List<Person> list4 = new ArrayList<>();
        List<Object> list5 = new ArrayList<>();


        list1 = list3;
        list1 = list4;
//        list1 = list5;

//        list2 = list3;
        list2 = list4;
        list2 = list5;

        //读取数据
        list1 = list4;
        Person person = list1.get(0);
        //编译不通过
//        Student student = list1.get(0);

        list2 = list4;
        Object obj = list2.get(0);
//        Person person1 = list2.get(0);

        //写入数据
        //编译不通过
//        list1.add(new Person());
//        list1.add(new Student());

        //编译通过
        list2.add(new Person());
        list2.add(new Student());
    }

}

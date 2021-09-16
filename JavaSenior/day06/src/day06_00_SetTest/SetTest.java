package day06_00_SetTest;

import day05_02_Collection.Person;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 1.Set接口的框架结构
 * |-----Collection接口：单列集合，用来存储一个一个的对象
 *  *
 *  *          |-----Set接口：存储无序的、不可重复的数据---->高中讲的"集合"
 *  *              |-----HashSet：作为Set接口的主要实现类，线程不安全的，可以存储null值
 *                      |-----LinkedHashSet：作为HashSet的子类：遍历其内部数据时可以按照添加的顺序遍历
 *                                          对于频繁的遍历操作，LinkedHashSet效率高于HashSet
 *                 |-----TreeSet：可以按照添加对象的指定属性，进行排序。底层是红黑树
 *
 *
 * 2.Set接口中没有额外定义新的方法,使用的都是Collection中声明过的方法
 *
 * 3.要求：向Set中添加的数据，其所在的类一定要重写hashCode()和equals()
 *   要求：重写的hashCode()和equals()一定要保持一致性：相同的对象必须具有相同的散列码
 *
 * @acthor KKKKK
 * @creay 2021-04-21-{TIME}
 */
public class SetTest
{

    /*
    一、Set接口：存储无序的、不可重复的数据
    以HashSet为例说明
    1.无序性：不等于随机性,存储的数据在底层数组中并非按照数组索引的顺序添加，而是根据数据的哈希值决定的

    2.不可重复性：保证添加的元素按照equals()判断时不能返回true，即：相同的元素只能添加一个

    二、添加元素的过程：以HashSet为例：
        我们向hashSet中添加元素a，首先调用元素a所在类的hashCode()方法，计算元素a的哈希值，此哈希值
        接着通过某种算法计算出在Hashset底层数组中的存放位置(即为：索引位置)，判断数组此位置上是否已经有元素：
            如果此此位置上没有其他元素，则元素a添加成功 --->情况一
            如果此位置上有其他元素b(或以链表形式存在的多个元素)，则比较元素a与元素b的hash值：
                如果hash值不相同，则元素a添加成功  --->情况二
                如果hash值相同，进而调用元素a所在类的equals()方法
                    equals()返回true，元素a添加失败
                    equals()返回false，则元素a添加成功  --->情况三


        对于添加成功的情况二和情况三而言：元素a与已经存在指定索引位置上的数据以链表的方式存储》
        JDK7：元素a放到数组中，指向原来的元素
        JDK8：原来的元素在数组中，指向元素a
        总结：七上八下

        HashSet底层：数组加链表，当底层数组使用率达到75%时，将底层数组扩容为原来的二倍，初始底层数组长度为16
        当数组使用率达到16 * 0.75 = 12时，将底层数组扩容到32

     */

    @Test
    public void test()
    {
        Set set = new HashSet();
        set.add(456);
        set.add(123);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new User("tom",12));
        set.add(new User("tom",12));
        set.add(129);

        Iterator iterator = set.iterator();

        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }


    //LinkedHashSet的使用
    //LinkedHashSet作为Hash的子类，在添加数据的同时，每个数据还维护了两个引用，记录此数据的前一个数据和
    //后一个数据
    //优点，对于频繁的遍历操作，LinkedHashSet效率高于HashSet
    @Test
    public void test1()
    {
        Set set = new LinkedHashSet();
        set.add(456);
        set.add(123);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new User("tom",12));
        set.add(new User("tom",12));
        set.add(129);

        Iterator iterator = set.iterator();



        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }

}

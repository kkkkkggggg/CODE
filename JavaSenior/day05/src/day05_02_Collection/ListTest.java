package day05_02_Collection;

import day05_02_Collection.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *  1.List接口框架
 *      |-----Collection接口：单列集合，用来存储一个一个的对象
 *  *          |-----List接口：存储有序的可重复的数据---->"动态"数组,替换原有的数组
 *  *              |-----ArrayList：作为List接口的主要实现类，线程不安全的，效率高,底层使用Object[]存储
 *                 |-----LinkedList：对于频繁的插入和删除操作，使用此类效率比ArrayList效率高，底层使用双向链表
 *                 |-----Vector：作为List接口的古老实现类，线程安全的，效率低，底层使用Object[]存储
 *  2.ArrayList的源码分析
 *   2.1 JDK7 情况下
 *      ArrayList a = new ArrayList();//底层创建了一个长度是10的Object[]数组elementData
 *      List.add(123);//elementData[0] = new Integer(123);
 *      ....
 *      list.add(11);//如果此次的添加导致底层elementData数组容量不够，则扩容
 *      默认情况下，扩容为原来的1.5倍，同时将原有数组中的数据复制到新的数组中
 *
 *      结论：建议开发中使用带参的构造器，ArrarList list = new ArrayList(int copacity)
 *
 *  2.2 JDK8中ArrayList的变化：
 *      ArrarList list = new ArrayList();//底层Object[] elementData初始化为{}，并没有创建长度为10的数组
 *
 *      list.add(123);//第一次调用add()，底层才创建了长度为10的数组，并将数据123添加到elementData数组中
 *      。。。
 *      后续的添加和扩容与JDK7无异
 *  2.3小结：JDK7中的ArrayList的对象的创建类似于单例的懒汉式，而JDK8中的ArrayList的对象的创建
 *          类似于单例的懒汉式，延迟了数组的创建，节省内存
 *
 * 3.LinkedList的源码分析
 * LinkedList list = new LinkedList();内部声明了Node类型的first和last属性，默认值为null
 * List.add(123);//将123封装到Node中，创建了Node对象
 *
 *
 * 其中Node定义为：体现了LinkedList的双向链表的说法
 * private static class Node<E> {
 *         E item;
 *         Node<E> next;
 *         Node<E> prev;
 *
 *         Node(Node<E> prev, E element, Node<E> next) {
 *             this.item = element;
 *             this.next = next;
 *             this.prev = prev;
 *         }
 *     }
 *
 * 4.Vector的源码分析：JDK7和JDK8中通过Vector()构造器创建对象时，底层创建了长度为10的数组，在扩容方面
 * 扩容为二倍
 *
 *
 *
 *  面试题：ArrayList、LinkedList、Vector三者的异同？
 *  同：三个类都实现了List接口，存储数据的特点相同：存储有序的、可重复的数据
 *  不同：见上
 *  5.List接口中的常用方法
 * 1.void add(int index, Object ele):在index位置插入ele元素
 * 2.boolean addAll(int index, Collection eles):从index位置开始将eles中
 * 的所有元素添加进来
 * 3.Object get(int index):获取指定index位置的元素
 * 4.int indexOf(Object obj):返回obj在集合中首次出现的位置
 * 5.int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
 * 6.Object remove(int index):移除指定index位置的元素，并返回此元素
 * 7.Object set(int index, Object ele):设置指定index位置的元素为ele
 * 8.List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex
 * 位置的子集合
 *
 * 总结：常用方法
 * 增：add(Object obj)
 * 删：remove(int index)/remove(Object obj)
 * 改：set(int index,Object ele)
 * 查：get(int index)
 * 插：add(int index,Object obj)
 * 长度：size()
 * 遍历：①：Iterator迭代器方式
 *      ②：增强for循环
 *      ③：普通for循环
 *
 * @acthor KKKKK
 * @creay 2021-04-20-{TIME}
 */
public class ListTest
{
    @Test
    public void test()
    {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("tom",12));
        list.add(456);
        System.out.println(list);

        //void add(int index,Object ele):在index位置插入ele元素
        list.add(1,"BB");
        System.out.println(list);

        //boolean addAll(int index,Collection eles):从index开始将eles中的所有元素添加到list中
        List list1 = Arrays.asList(1,2,3);
        list.addAll(list1);
        System.out.println(list.size());//9

        //Object get(int index):获取指定index位置的元素
        System.out.println(list.get(1));

        //int indexOf(Object obj):返回obj在集合中首次出现的位置
        System.out.println(list.indexOf(456));

        //int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
        System.out.println(list.lastIndexOf(456));

        //Object remove(int index):移除指定index位置的元素，并返回此元素
        System.out.println(list.remove(1));

        //Object set(int index, Object ele):设置指定index位置的元素为ele
        list.set(2,"CC");
        System.out.println(list);

        //List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex
        System.out.println(list.subList(4,7));


    }

    @Test
    public void test1()
    {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");

        //①：Iterator迭代器方式
        Iterator l = list.iterator();

        while(l.hasNext())
        {
            System.out.println(l.next());
        }

        // ②：增强for循环
        for(Object o : list)
        {
            System.out.println(o);
        }

        //③：普通for循环
        for(int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }

    }


    //区分remove(int index)和remove(Object obj)
    @Test
    public void teat2()
    {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        updateList(list);
        System.out.println(list);
    }

    public static void updateList(List list)
    {
        list.remove(2);
    }

}

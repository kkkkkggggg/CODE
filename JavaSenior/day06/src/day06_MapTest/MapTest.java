package day06_MapTest;

import org.junit.Test;

import java.security.Key;
import java.util.*;

/**
 * 一、Map的实现类的结构
 * |-----Map:双列数据，存储key-value对的数据 ----类似于高中的函数：y = f(x)
 *          |-----HashMap：作为Map的主要实现类：线程不安全的，效率高：存储null的key-value
 *                  |-----LinkedHashMap:保证在遍历map元素时，可以按照添加的顺序实现遍历
 *                                  原因：在原有的HashMap基础上，添加了一对指针，指向前一个和后一个元素
 *                                  对于频繁的遍历操作，此类执行效率高于HashMap
 *          |-----TreeMap：可以按照添加的key-value对进行排序，实现排序遍历，此时考虑key的自然排序或定制排序
 *                          底层使用红黑树
 *          |-----Hashtable：作为古老的实现类：线程安全的，效率低：不能存储null的key-value
 *                  |-----Properties：用来处理配置文件，key和value都是String类型
 *
 *       HashMap的底层：数组+链表 （JDK7及之前）
 *                      数组+链表+红黑树（JDK8）
 *
 * 面试题：
 * 1.HashMap的底层实现原理?
 *
 * 2.HashMap和Hashtable的异同？
 *
 * 3.CurrentHashMap 与 Hashtable的异同
 *
 * 二、Map结构的理解
 * Map中的key：无序的、不可重复的，使用Set存储所有的key --->key所在的类重写equals()和hashCode()(以HashMap为例)
 * map中的value：无序的、可重复的，使用Collection存储所有的value --->value所在类要重写equals()
 * 一个键值对：key-value构成了一个Entry对象
 * Map中的Entry：无序的、不可重复的，使用Set存储所有的Entry
 *
 * 三、HashMap的底层实现原理：以JDK7为例说明：
 *    HashMap map = new HashMap();
 *    在实例化以后，底层创建了长度是16的一维数组Entry[] table
 *    ...可能已经执行过多次put()...
 *    map.put(key1,value1);
 *    首先，调用key1所在类的hashCode()计算key1的哈希值，此哈希值经过某种算法计算以后，得到在Entry数组
 *    中的存放位置，如果此位置上没有数据，此时key1-value1添加成功  ----情况一
 *    如果此位置上的数据不为空，(意味着此位置上存在一个或多个数据(以链表形式存在))，比较key1和已经存在的
 *    一个或多个数据的哈希值：
 *                      如果key1的哈希值与已经存在的数据的哈希值都不同，此时key1-value1添加成功  ----情况二
 *                      如果key1的哈希值和已经存在的某个数据(key2-value2)的哈希值相同，继续比较：调用key1所在类的
 *                      equals()方法，比较：
 *                                      如果equals()返回false：此时key1-value1添加成功  ----情况三
 *                                      如果equals()返回true：使用value1t替换原来的value2
 *
 *    补充：关于情况二和情况三：此时key1-value1和原来的数据以链表的方式存储
 *
 *    在不断的添加过程中，会涉及到扩容问题，当超出临界值且要存放key1-value1的位置不为空(如果存放，会生
 *    成链表)时进行扩容默认扩容方式，扩容为原来的二倍，再将原来的数据复制过来
 *
 *    JDK8相较于JDK7在底层实现方面的不同
 *    1.new HashMap():底层没有创建一个长度为16的数组
 *    2.JDK8底层数组是：Node[],而非Entry[]
 *    3.首次调用put()方法时，底层创建长度为16的数组
 *    4.JDK7底层结构只有：数组 + 链表，JDK8中底层数据结构：数组 + 链表 + 红黑树
 *      当数组的某个索引位置上的元素以链表形式存在的数据个数 >8 时且当前数组的长度 >64 时，此时索引位置
 *      上的数据改为使用红黑树存储
 *
 *      DEFAULT_INITIAL_CAPACITY:HashMap的默认容量 16
 *      DEFALULT_LOAD_FACTOR:HashMap的默认加载因子：0.75
 *      threshold:扩容的临界值， = 容量 * 加载因子：16 * 0.75 => 12
 *      TREEIFY_THRESHOLD:Bucket中链表长度大于该默认值，转换为红黑数：8
 *      MIN_TREEIFY_CAPACITY：Bucket中的Node被转换为红黑树时最小的hash表容量：64
 *
 *  四、LinkedHashMap的底层实现原理(了解)
 *  源码中：
 *  static class Entry<K,V> extends HashMap.Node<K,V> {
 *         Entry<K,V> before, after;//能够记录添加的元素的先后顺序
 *         Entry(int hash, K key, V value, Node<K,V> next) {
 *             super(hash, key, value, next);
 *         }
 *     }
 *
 *  五：Map中定义的方法
 * 添加、删除、修改操作：
 *  Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
 *  void putAll(Map m):将m中的所有key-value对存放到当前map中
 *  Object remove(Object key)：移除指定key的key-value对，并返回value
 *  void clear()：清空当前map中的所有数据
 *  元素查询的操作：
 *  Object get(Object key)：获取指定key对应的value
 *  boolean containsKey(Object key)：是否包含指定的key
 *  boolean containsValue(Object value)：是否包含指定的value
 *  int size()：返回map中key-value对的个数
 *  boolean isEmpty()：判断当前map是否为空
 *  boolean equals(Object obj)：判断当前map和参数对象obj是否相等
 *  元视图操作的方法：
 *  Set keySet()：返回所有key构成的Set集合
 *  Collection values()：返回所有value构成的Collection集合
 *  Set entrySet()：返回所有key-value对构成的Set集合
 *
 * 总结：常用方法
 * 添加：Object put(Object key,Object value)
 * 删除：Object remove(Object key)
 * 修改：Object put(Object key,Object value)
 * 查询：Object get(Object key)
 * 长度：int size()
 * 遍历：Set keySet()/Collection values()/Set entrySet()
 *
 * @acthor KKKKK
 * @creay 2021-04-21-{TIME}
 */
public class MapTest
{


    @Test
    public void test()
    {
         Map map = new HashMap();
         map.put(null,null);
        System.out.println(map);

        //Hashtable不能存储值为null的key-value数据，会报错：NullPointerException
//        Map map1 = new Hashtable();
//        map1.put(null,123);
    }

    @Test
    public void test1()
    {
        LinkedHashMap map = new LinkedHashMap();

        map.put(123,1);
        map.put(456,2);
        map.put(789,3);
        map.put(910,4);
        map.put(101,5);
        map.put(111,6);
        map.put(121,7);

        System.out.println(map);
    }

    @Test
    public void test2()
    {
        /*
        添加、删除、修改操作：
 *  Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
 *  void putAll(Map m):将m中的所有key-value对存放到当前map中
 *  Object remove(Object key)：移除指定k
         */
        Map map = new HashMap();

        map.put("AA",1);
        map.put("BB",2);
        map.put("CC",3);
        map.put("DD",4);
        map.put("EE",5);
        map.put("FF",6);
        map.put("GG",7);

        System.out.println(map);

        Map map1 = new HashMap();
        map1.put("HH",8);
        map1.put("II",9);
        map1.put("JJ",10);
        map1.put("KK",11);

        map.putAll(map1);

        System.out.println(map);

        map.remove("AA");

        System.out.println(map);

        map.clear();
        System.out.println(map);
        System.out.println(map.size());

    }

    @Test
    public void test3()
    {
        Map map = new HashMap();

        map.put("AA",1);
        map.put("BB",2);
        map.put("CC",3);
        map.put("DD",4);
        map.put("EE",5);
        map.put("FF",6);
        map.put("GG",7);

        System.out.println(map.get("AA"));

        System.out.println(map.containsKey("BB"));

        System.out.println(map.containsValue(6));

        System.out.println(map.size());

        System.out.println(map.isEmpty());

        Map map1 = new HashMap();
        map1.put("HH",8);
        map1.put("II",9);
        map1.put("JJ",10);
        map1.put("KK",11);

        System.out.println(map.equals(map1));
    }

    @Test
    public void test4()
    {
        /*
         元视图操作的方法：
 *  Set keySet()：返回所有key构成的Set集合
 *  Collection values()：返回所有value构成的Collection集合
 *  Set entrySet()：返回所有key-value对构成的Set集合
         */
        Map map = new HashMap();

        map.put("AA",1);
        map.put("BB",2);
        map.put("CC",3);
        map.put("GG",7);
        map.put("DD",4);
        map.put("EE",5);
        map.put("FF",6);

        Set set = map.keySet();

        Iterator iterator = set.iterator();

        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }

        Collection collection = map.values();

        Iterator iterator1 = collection.iterator();

        while(iterator1.hasNext())
        {
            System.out.println(iterator1.next());
        }

        //遍历所有的key-value
        //方式一：entrySet()
        Set set1 = map.entrySet();

        Iterator iterator2 = set1.iterator();

        while(iterator2.hasNext())
        {
            //set1中每一个元素都是一个Entry
            Map.Entry entry = (Map.Entry) iterator2.next();

            System.out.println(entry.getKey() + "---->" + entry.getValue());
        }

        //方式二
        Set keySet = map.keySet();
        Iterator iterator3 = set.iterator();
        while(iterator3.hasNext())
        {
            Object key = iterator3.next();
            Object value = map.get(key);

            System.out.println(key + "----->" + value);
        }
    }
}

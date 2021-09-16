package day03;

import org.junit.Test;

/**
 * 关于StringBuffer和StringBuilder的使用
 *
 * @acthor KKKKK
 * @creay 2021-04-16-{TIME}
 */
public class StringBufferBuildeTest
{

    /*
    对比StringBuffer、StringBuilder、String三者的效率
    StringBuilder > StringBuffer > String
     */
    @Test
    public void test3()
    {
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");

        //开始对比
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间：" + (endTime - startTime));
    }
    /*
    StringBuffer的常用方法
    StringBuffer append(xxx)：提供了很多的append()方法，用于进行字符串拼接
    StringBuffer delete(int start,int end)：删除指定位置的内容
    StringBuffer replace(int start, int end, String str)：把[start,end)位置替换为str
    StringBuffer insert(int offset, xxx)：在指定位置插入xxx
    StringBuffer reverse() ：把当前字符序列逆转
    public int indexOf(String str):
    public String substring(int start,int end)：返回一个从start开始到end索引结束的左闭右开区间的子字符串
    public int length()
    public char charAt(int n )
    public void setCharAt(int n ,char ch)

    总结：
    增：append(xxx)
    删：delete(int start,int end)
    改：setCharAt(int n,char Ch)/replace(int start,int end,String str)
    查：charAt(int n)
    插：insert(int offset,xxx)
    长度：length();
    遍历：for() + charAt()
     */
    @Test
    public void test1()
    {
        StringBuffer s = new StringBuffer("abc");
        s.append(1);
        s.append('1');
        s.append("dce");
        System.out.println(s);

//        s.delete(2,4);
//        s.replace(2,4,"hello");
        s.insert(2,false);
        String s1 = s.substring(1, 4);
        System.out.println(s1);
        System.out.println(s);
        System.out.println(s.length());
    }


    /*
    String\StringBuffer\StringBuilder三者的异同
    String：不可变的字符序列,底层使用char{}存储
    StringBuffer：可变的字符序列：线程安全的，效率偏低，底层使用char{}存储
    StringBuilder：可变的字符序列：JDK5.0新增的，线程不安全的，效率高，底层使用char{}存储

    源码分析：
    String str = new String();//new char[0];
    String str1 = new String("abc");//new char[]{'a','b','c'};

    StringBuffer s = new StringBuffer();//char[] value = new char[16];底层创建了一个长度为
    16的char[]
    s.append('a');//value[0] = 'a';
    s.append('b');//value[1] = 'b';

    StringBuffer s1 = new StringBuffer("abc");//char[] value = new char["abc".length + 16];

    //问题一，System.out.println(s1.length());//3
    //问题二.扩容问题：如果要添加的数据底层数组盛不下了，那就需要扩容底层的数组
            默认情况下扩容为原来容量的2倍 + 2，同时将原有数组中的元素复制到新的数组中

            指导意义：开发中推荐大家使用：StringBuffer(int capacity) 或 StringBuilder(int capacity)

     */
    @Test
    public void test()
    {
        StringBuffer s = new StringBuffer("abc");
        s.setCharAt(0,'m');
        System.out.println(s);

        StringBuffer s1 = new StringBuffer();
        System.out.println(s1.length());
    }

}

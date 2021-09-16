package day03;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 *
 * 涉及到String类与其他结构之间的转换
 * @acthor KKKKK
 * @creay 2021-04-15-{TIME}
 */
public class StringTest01
{


    /*
    String 与 byte[]之间的转换
    String --> byte[]:调用String的getBytes()
    byte[] --> String:调用String的构造器

    编码：字符串-->字节(看得懂-->看不懂的二进制数据)
    解码：字节-->字符串
     */
    @Test
    public void test2() throws UnsupportedEncodingException
    {
        String str = "abc123中国";
        byte[] bytes = str.getBytes();//使用默认的字符集进行转换-UTF-8,编码
        System.out.println(Arrays.toString(bytes));

        byte[] bytes1 = str.getBytes("gbk");//使用jbk字符集进行编码
        System.out.println(Arrays.toString(bytes1));

        String str1 = new String(bytes);//使用默认的字符集进行转换-UTF-8,解码
        System.out.println(str1);

//        String str2 = new String(bytes1);
//        System.out.println(str2);//出现乱码，原因，编码集和解码集不一致

        String str3 = new String(bytes1, "gbk");
        System.out.println(str3);

    }

    /*
    String 与 char[]之间的转换

    String --> char[]:调用String的toCharArray()
    char[] --> String:调用String的构造器
     */
    @Test
    public void test1()
    {
        String str = "abc123";

        char[] chars = str.toCharArray();
        for(int i = 0; i < chars.length; i++)
        {
            System.out.println(chars[i]);
        }

        char[] arr = new char[]{'a','b','c','d','e'};
        String str1 = new String(arr);
        System.out.println(str1);
    }


    /*
    复习
    String 与基本数据类型、包装类之间的转换
    String --> 基本数据类型、包装类:调用包装类的静态方法：parseXxx(str)

    基本数据类型、包装类 --> String：调用String重载的valueof(xxx),包装类的toString方法
     */

    @Test
    public void test()
    {
        String str = "123";
        int i = Integer.parseInt(str);

        Integer i1 = i;//自动装箱

        int s = 12345;
        String str1 = String.valueOf(s);
        //String str1 = s + "";
        System.out.println(str1);

        String str2 = Integer.toString(i1);
        System.out.println(str2);


    }
}

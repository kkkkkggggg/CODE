package day04;

import org.junit.Test;

import java.util.Date;

/**
 * JDK 8之前日期和时间的API测试
 *
 * @acthor KKKKK
 * @creay 2021-04-16-{TIME}
 */
public class DateTimeTest0
{
    /*
    java.util.Date类
            /---java.sql.Date类
    1.两个构造器的使用

    2.两个方法的使用
        >toString():显式当前的年、月、日、时、分、秒
        >getTime():获取当前Date对象对应的毫秒数

    3.java.sql.Data对应着数据库中的日期类型的变量
    >如何实例化
    >如何将java.util.Date对象转换为java.sql.Date对象
     */
    @Test
    public void test1()
    {
        //构造器一：Date()：创建了一个对应当前时间的Date对象
        Date date = new Date();
        System.out.println(date);//Fri Apr 16 13:28:02 CST 2021

        System.out.println(date.getTime());//1618550960401

        //构造器二:创建指定毫秒数的Date对象
        Date date1 = new Date(1618550960401L);
        System.out.println(date1.toString());

        //创建java.aql.Data对象
        java.sql.Date date2 = new java.sql.Date(1618550960401L);
        System.out.println(date2);//2021-04-16

        //如何将java.util.Date对象转换为java.sql.Date对象
        //情况一：
        //        Date date3 = new java.sql.Date(1618550960401L);
        //        java.sql.Date date4 = (java.sql.Date)date3;
        //情况二：
        Date date3 = new Date();
        java.sql.Date date4 = new java.sql.Date(date3.getTime());

    }

    //1.System类中的currentTimeMillis()
    @Test
    public void test()
    {
        long time = System.currentTimeMillis();
        //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差1618550972175
        //称为时间戳
        System.out.println(time);
    }

}

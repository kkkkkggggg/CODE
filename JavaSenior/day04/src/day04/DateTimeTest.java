package day04;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * JDK 8之前的日期时间的API测试
 * 1.System类中currentTimeMillis();
 * 2.java.util.Date和子类java.sql.Date
 * 3.SimpleDateFormat
 * 4.Calendar
 * @acthor KKKKK
 * @creay 2021-04-17-{TIME}
 */
public class DateTimeTest
{
    /*
    simpleDateFormat的使用：simpleDateFormat对日期和Date类的格式化和解析

    1.两个操作：
    1.1 格式化：日期-->字符串
    1.2 解析：格式化的逆过程，字符串-->日期

    2.simpleDateFormat的实例化
     */

    @Test
    public void testSimpleDateFormat() throws ParseException
    {
        //实例化SimpleDateFormat:使用默认的构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化：日期--->字符串
        Date date = new Date();
//        System.out.println(date);

        String format = sdf.format(date);
        System.out.println(format);

        //解析：格式化的逆过程，字符串-->日期
        String str = "1998-02-17 下午1:00";
        Date date1 = sdf.parse(str);
        System.out.println(date1);

        //*************按照指定的方式格式化和解析：调用带参的构造器*****************
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format1 = sdf1.format(date);
        System.out.println(format1);//2021-04-17 02:29:40

        //解析:要求字符串必须符合SimpleDateFormat识别的格式（通过构造器参数体现），否则会报异常
        Date parse = sdf1.parse("2021-04-17 02:29:40");
        System.out.println(parse);


    }

    /*
    练习一：字符串“2020-09-88”转换为java.sql.Date
    练习二：“三天打渔，两天晒网” 1990-01-01  xxxx-xx-xx 打渔？晒网？
    举例：2020-09-08?  总天数

    总天数 % 5 == 1，2，3：打渔
    总天数 % 5 == 4，0：晒网

     */
    @Test
    public void testExer() throws ParseException
    {
        String string = "2020-09-08";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date date = sdf.parse(string);

        java.sql.Date s = new java.sql.Date(date.getTime());

        System.out.println(s);
    }

    @Test
    public void testExer1() throws ParseException
    {
        String begin = "1990-01-01";
        String end = "2020-09-08";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long oneDay = sdf.parse("1970-01-02").getTime() - sdf.parse("1970-01-01").getTime();


        long totalDay = (sdf.parse(end).getTime() - sdf.parse(begin).getTime()) / oneDay + 1;//加一是因为相除会省略小数点后面的


        int x =(int) totalDay % 5;
        if(x == 1 || x == 2|| x == 3)
        {
            System.out.println("打渔");
        }else
        {
            System.out.println("晒网");
        }
    }

    @Test
    public void test2()
    {
        int a = 3;
        int b = 5;
        float x =(float) b / a;
        System.out.println(x);

    }

    /*
    Calendar（抽象类）日历类的使用
     */
    @Test
    public void testCalendar()
    {
        //1.实例化
        //方式一：创建其子类（GregorianCalendar）的对象
        //方式二：调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar.getClass());

        //2.常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        //set()
        calendar.set(Calendar.DAY_OF_MONTH,22);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        //add()
        calendar.add(Calendar.DAY_OF_MONTH,3);//在这个月的天数上加三天，减的话使用加负数实现
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        //getTime():日历类--->Date类
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime():Date ---> 日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

    }

}



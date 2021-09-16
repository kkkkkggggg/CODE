package day04;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 *
 * JDK 8中日期时间API的测试
 * @acthor KKKKK
 * @creay 2021-04-17-{TIME}
 */
public class JDK8DateTimeTest
{
    @Test
    public void testDate()
    {
        //偏移量：Date中年份从1900年开始，月份从0开始
        Date date = new Date(2020 - 1900,9 - 1,8);
        System.out.println(date);//如果不减1900和减1：Fri Oct 08 00:00:00 CST 3920
        // Tue Sep 08 00:00:00 CST 2020
    }

    /*
    LocalTime
    LocalDate
    LocalDateTime
    1.说明LocalDateTime相较于 LocalTime、LocalDate使用频率更高
    2.类似于Calendar
     */
    @Test
    public void test1()
    {
        //now():获取当前的日期、时间、日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of():设置指定的年月日时分秒，没有偏移量
        LocalDateTime of = LocalDateTime.of(2020, 10, 6, 12, 45, 12);
        System.out.println(of);

        //getXxx()
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getDayOfYear());
        System.out.println(localDateTime.getHour());
        System.out.println(localDateTime.getMonthValue());


        //体现不可变性
        //withXxx(),设置相关的属性
        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(22);
        System.out.println(localDateTime);
        System.out.println(localDateTime1);

        //不可变性
        LocalDateTime localDateTime2 = localDateTime.plusMonths(3);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);

        //不可变性
        LocalDateTime localDateTime3 = localDateTime.minusDays(6);
        System.out.println(localDateTime);
        System.out.println(localDateTime3);


    }

    /*
    Instant的使用

    类似于java.util.Date
     */
    @Test
    public void test3()
    {
        //now():获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);//2021-04-17T09:30:53.346Z,本初子午线的时间

        //添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);


        //toEpochMilli()获取距离1970-01-01 00：00：00 的毫秒数
        long l = instant.toEpochMilli();
        System.out.println(l);

        //ofEpochMilli():通过给定的毫秒数，获取Instant的实例 --->Date(Long millis)
        Instant instant1 = Instant.ofEpochMilli(1618652168663L);
        System.out.println(instant1);
    }

    /*
    DateTimeFormatter:格式化或解析日期、时间，类似于SimpleDateFormat
     */

    @Test
    public void test4()
    {
//        方式一：预定的标准格式，如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        //格式化：日期 ---> 字符串
        LocalDateTime now = LocalDateTime.now();
        String format = formatter.format(now);
        System.out.println(now);
        System.out.println(format);


        //解析：字符串 ---> 日期
        TemporalAccessor parse = formatter.parse("2021-04-17T17:47:47.507");
        System.out.println(parse);



//        方式二：本地化相关的格式：如：ofLocalizedDateTime()
//        FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT:适用于LocalDateTime
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        //格式化
        String str2 = formatter1.format(now);
        System.out.println(str2);//2021年4月17日 下午05时54分59秒


//        方式二：本地化相关的格式：如：ofLocalizedDate()
//        FormatStyle.FULL / FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT:适用于LocalDate
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        //格式化
        String str3 = formatter2.format(now);
        System.out.println(str3);//2021年4月17日 星期六



        //        方式三：自定义的格式，如：ofPattern("yyyy-MM-dd hh:mm:ss E")
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss E");

        //格式化
        String str4 = formatter3.format(LocalDateTime.now());

        System.out.println(str4);//2021-04-17 06:06:25 星期六

        //解析
        TemporalAccessor parse1 = formatter3.parse("2021-04-17 06:06:25 星期六");
        System.out.println(parse1);


    }

}

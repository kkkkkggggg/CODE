package day05;

/**
 * 一、枚举类的使用
 * 1.枚举类的理解：类的对象只有有限个，确定的，我们称之为枚举类
 * 2.当需要定义一组常量时，强烈建议使用枚举类
 * 3.如果枚举类中只有一个对象，则可以看作是枚举类的一种实现方式
 *
 * 二、如何定义枚举类
 * 方式一：JDK5.0之前，自定义枚举类
 * 方式二：JDK5.0，可以使用enum关键字定义枚举类
 *
 * 三、Enum类中的常用方法
 * 1.values()方法：返回枚举类型的对象数组。该方法可以很方便地遍历所有的
 * 枚举值。
 *
 * 2.valueOf(String str)：可以把一个字符串转为对应的枚举类对象。要求字符
 * 串必须是枚举类对象的“名字”。如不是，会有运行时异常：
 * IllegalArgumentException。
 *
 * 3.toString()：返回当前枚举类对象常量的名称
 *
 * 四、使用enum关键字定义的枚举类实现接口的情况
 * 情况一：实现接口在enum类中实现抽象方法
 * 情况二：让枚举类的对象分别实现接口中的抽象方法
 *
 *  @acthor KKKKK
 * @creay 2021-04-19-{TIME}
 */
public class SeasonTest0
{
    public static void main(String[] args)
    {
        Season spring = Season.SPRING;
        System.out.println(spring);


    }

}

//自定义枚举类
class Season
{
    //声明Season对象的属性：private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //1.私有化类的构造器，并给对象属性赋值
    private Season(String seasonName,String seasonDesc)
    {
        this.seasonDesc = seasonDesc;
        this.seasonName = seasonName;

    }


    //提供当前枚举类的多个对象：public static final的
    public static final Season SPRING = new Season("SPRING","1");
    public static final Season SUMMER = new Season("SUMMER","2");
    public static final Season AUTUMN = new Season("AUTUMN","3");
    public static final Season WINTTER = new Season("WINTTER","4");

    //4.其他诉求：获取没去内对象的属性

    public String getSeasonName()
    {
        return seasonName;
    }

    public String getSeasonDesc()
    {
        return seasonDesc;
    }

    //5.其他诉求二：提供toString()

    @Override
    public String toString()
    {
        return "Season{" + "seasonName='" + seasonName + '\'' + ", seasonDesc='" + seasonDesc + '\'' + '}';
    }
}
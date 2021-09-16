package day05;

import java.util.Arrays;

/**
 * 使用enum关键字定义枚举类
 * 说明：定义的枚举类默认继承于java.lang.Enum类
 *
 * @acthor KKKKK
 * @creay 2021-04-19-{TIME}
 */
public class SeasonTest1
{
    public static void main(String[] args)
    {
        Season1 summer = Season1.SUMMER;
        //toString():
        System.out.println(summer.toString());
//        System.out.println(Season1.class.getSuperclass());
        System.out.println("*******************************");
        //values():
        Season1[] values = Season1.values();
        Thread.State[] values1 = Thread.State.values();

        System.out.println(Arrays.toString(values));
        System.out.println("*******************************");

        System.out.println(Arrays.toString(values1));
        System.out.println("*******************************");


        //valueOf(String objName):返回枚举类中对象名是objName的对象
        //如果没有objName的枚举类对象，则抛异常IllegalArgumentException
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);
        System.out.println("*******************************");

        winter.show();
    }
}

interface Info
{
    void show();
}

enum Season1 implements Info
{

    //1.提供当前枚举类的对象，多个对象之间用","隔开，末尾对象";"结束
    SPRING("SPRING", "1"){
        @Override
        public void show()
        {
            System.out.println("这是春天");
        }
    },
    SUMMER("SUMMER", "2"){
        @Override
        public void show()
        {
            System.out.println("这是夏天");
        }
    },
    AUTUMN("AUTUMN", "3") {
        @Override
        public void show()
        {
            System.out.println("这是秋天");
        }
    },
    WINTER("WINTER", "4"){
        @Override
        public void show()
        {
            System.out.println("这是冬天");
        }
    };

    //2.3声明Season对象的属性：private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //3.私有化类的构造器，并给对象属性赋值
    private Season1(String seasonName, String seasonDesc)
    {
        this.seasonDesc = seasonDesc;
        this.seasonName = seasonName;

    }


    //4.其他诉求：获取没去内对象的属性

    public String getSeasonName()
    {
        return seasonName;
    }

    public String getSeasonDesc()
    {
        return seasonDesc;
    }

//    @Override
//    public void show()
//    {
//        System.out.println("这是一个季节");
//    }

    //5.其他诉求二：提供toString()

//    @Override
//    public String toString()
//    {
//        return "Season1{" + "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' + '}';
//    }
}

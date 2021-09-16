package day02_01;

/**
 * 使用同步机制将单例模式中的懒汉式改写为线程安全的
 *
 * @acthor KKKKK
 * @creay 2021-04-13-{TIME}
 */
public class SingleTonTest
{
    public static void main(String[] args)
    {

    }
}

//饿汉式单例模式
class SingleTon
{
    private SingleTon()
    {

    }
    private static SingleTon s = new SingleTon();

    public static SingleTon getTon()
    {
        return s;
    }
}

//懒汉式单例模式，存在线程安全问
class SingleTon1
{
    private SingleTon1()
    {

    }

    private static SingleTon1 x = null;


    //通过同步代码块来解决线程安全问题
    public static SingleTon1 getX()
    {
        //方式一：效率稍差
//        synchronized(SingleTon1.class)
//        {
//            if(x == null)
//            {
//                x = new SingleTon1();
//                return x;
//            }
//            return x;
//        }

        //方式二:效率更高
        if(x == null)
        {
            synchronized(SingleTon1.class)
            {
                if(x == null)
                {
                    x = new SingleTon1();
                    return x;
                }
            }
        }
        return x;
    }

    //通过同步方法解决线程安全问题
    public static synchronized SingleTon1 getSingleTon()//同步监视器：SingleTon.class
    {
        if(x == null)
        {
            x = new SingleTon1();
            return x;
        }

        return x;

    }
}
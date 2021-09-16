package day01exer;

/**
 * 练习：创建两个分线程，其中一个线程遍历100以内的偶数，另一个线程遍历100以内的奇数
 * @acthor KKKKK
 * @creay 2021-04-12-{TIME}
 */
public class ThreadDemo
{
    public static void main(String[] args)
    {
        OuShu o = new OuShu();
        o.run();

        JiShu j = new JiShu();
        j.run();
//      创建Thread类的匿名子类的实名对象
        Thread t = new Thread(){
            @Override
            public void run()
            {
                for(int i = 0; i < 100; i++)
                {
                    System.out.println(i);
                }
            }
        };
        t.start();

//        创建Thread类的匿名子类的匿名对象
        new Thread(){
            @Override
            public void run()
            {
                for(int i = 0; i < 100; i++)
                {
                    System.out.println(i);
                }
            }
        }.start();


    }
}

class OuShu extends Thread
{
    @Override
    public void run()
    {
        for(int i = 0;i <= 100;i++)
        {
            if(i % 2 == 0)
            {
                System.out.println("偶数" + i);
            }
        }
    }



}

class JiShu extends Thread
{
    @Override
    public void run()
    {
        for(int i = 0;i <= 100;i++)
        {
            if(i % 2 != 0)
            {
                System.out.println("奇数" + i);
            }
        }
    }


}
package day01;

/**
 * 多线程的创建:方式一：继承于Thread类
 * 1.创建一个继承于Thread类的子类
 * 2.重写Thread类的run() -->将此线程执行的操作声明在run()中
 * 3.创建Thread类的子类的对象
 * 4.通过此对象调用start
 * @acthor KKKKK
 * @creay 2021-04-12-{TIME}
 */

//1.创建一个继承于Thread类的子类
public class ThreadTest
{
    public static void main(String[] args)
    {
        //        3.创建Thread类的子类对象
        MyThread myThread = new MyThread();

//        4.通过此对象调用start():①启动当前线程②调用当前线程的run()

        myThread.start();

//        问题一：我们不能通过直接调用run()的方式启动线程
//        myThread.run();

//        问题二：再启动一个线程，遍历100以内的偶数,不可以还让已经start()的线程去执行
//        会报IllegalThreadStatusException
//        myThread.start();
//        我们需要重新创建一个线程的对象
        MyThread myThread1 = new MyThread();
        myThread1.start();

        //如下操作仍然是在main线程中进行的
        for(int i = 0;i < 100;i++)
        {
            if(i % 2 == 0)
            {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }

//        System.out.println("hello");
    }
}

class MyThread extends Thread
{
    //    2.重写run()方法

    @Override
    public void run()
    {
        for(int i = 0;i < 100;i++)
        {
            if(i % 2 == 0)
            {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

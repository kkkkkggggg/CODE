package day02_02;

/**
 *线程通信的例子：使用两个线程打印1-100，线程一，线程二，交替打印
 *涉及到的三个方法：
 * wait():一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器
 * notify()：一旦执行此方法，就会唤醒被wait的一个线程，如果有多个线程被wait，就唤醒优先级较高的线程
 * notifyall()：一旦执行此方法，就会唤醒所有被wait的方法
 *
 * 说明：
 * 1.wait(),notify(),notifyall()三个方法必须使用在同步代码块或同步方法中
 * 2.wait(),notify(),notifyall()三个方法的调用者必须是同步代码块或同步方法中的同步监视器
 * 否则会出现IllegalMonitorStateException
 * 3.wait(),notify(),notifyall()三个方法是定义在java.lang.Object类中的
 *
 * 面试题：sleep() 和 wait()的异同
 * 1.相同点：一旦执行方法，都可以使得当前的线程进入阻塞状态
 * 2.不同的：1）两个方法声明的位置不一样：Thread类中声明sleep()，Object类中声明wait()
 *          2)调用要求不同：sleep()可以在任何场景下调用，wait()只能在同步代码块和同步方法中调用
 *          3）如果两个方法都是用在同步代码块或同步方法中，sleep()不会释放锁，wait()会释放锁
 *
 * @acthor KKKKK
 * @creay 2021-04-14-{TIME}
 */

class Number implements Runnable
{
    private int number = 1;
    @Override
    public void run()
    {
        while(true)
        {
            synchronized(this)
            {
                notify();
                if(number <= 100)
                {
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    try
                    {
                        //使得调用如下wait()的线程进入阻塞状态
                        wait();//wait()方法会释放锁
                    }catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }

                }else
                {
                    break;
                }
            }
        }
    }
}


public class CommunicationTest
{
    public static void main(String[] args)
    {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程一");
        t2.setName("线程二");

        t1.start();
        t2.start();


    }
}


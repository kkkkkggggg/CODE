package day02;

/**
 *
 * 使用同步方法解决实现Runnable接口的线程安全问题
 *
 * 关于同步方法的总结：
 * 1.同步方法依然涉及到同步监视器，只是不需要我们显式的声明
 * 2.非静态的同步方法，同步监视器是：this
 *   静态的同步方法，同步监视器是：当前类本身
 * @acthor KKKKK
 * @creay 2021-04-13-{TIME}
 */
public class WindowTest2
{
    public static void main(String[] args)
    {
        Window1 w1 = new Window1();

        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.setName("窗口一");
        t1.start();

        t2.setName("窗口二");
        t2.start();

        t3.setName("窗口三");
        t3.start();


    }
}

class Window2 implements Runnable
{
    private int ticket = 100;
    Object obj = new Object();
    @Override
    public void run()
    {
        while(true)
        {
            show();
        }

    }

    public synchronized void show()//同步监视器：this
    {
//        synchronized(this)
//        {
            if(ticket > 0)
            {
                //                    try
                //                    {
                //                        Thread.sleep(100);
                //                    }catch(InterruptedException e)
                //                    {
                //                        e.printStackTrace();
                //                    }

                System.out.println(Thread.currentThread().getName() + ":" + "卖票，票号是：" + ticket);
                ticket--;
            }
//        }
    }
}
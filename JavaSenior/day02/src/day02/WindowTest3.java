package day02;

/**
 * 使用同步方法来解决继承Thread类创建多线程的线程安全问题
 *
 *
 * @acthor KKKKK
 * @creay 2021-04-13-{TIME}
 */
class Window3 extends Thread
{
    private static int ticket = 100;
    private static Object obj = new Object();
    @Override
    public void run()
    {

        while(true)
        {
            show();
        }
    }

    private static synchronized void show()//同步监视器：Window3.class
    //private synchronized void show()//同步监视器w1\w2\w3,此种解决方式是错误的
    {
        if(ticket > 0)
        {
            System.out.println(Thread.currentThread().getName() + ":卖票，票号为:" + ticket);
            ticket--;
        }

    }
}


public class WindowTest3
{
    public static void main(String[] args)
    {
        Window3 w1 = new Window3();
        Window3 w2 = new Window3();
        Window3 w3 = new Window3();

        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");

        w1.start();
        w2.start();
        w3.start();
    }
}


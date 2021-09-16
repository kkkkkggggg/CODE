package day01exer;

/**
 * 例子：创建三个窗口买票，总票数为100张，使用实现Runnable接口的方法
 *
 * 存在线程安全问题，待解决
 * @acthor KKKKK
 * @creay 2021-04-13-{TIME}
 */
public class WindowTest1
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

class Window1 implements Runnable
{
    private int ticket = 100;

    @Override
    public void run()
    {
        while(true)
        {
            if(ticket > 0)
            {
                System.out.println(Thread.currentThread().getName() + ":" + "卖票，票号是：" + ticket);
                ticket--;
            }else
            {
                break;
            }
        }

    }
}
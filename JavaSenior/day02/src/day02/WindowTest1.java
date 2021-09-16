package day02;

/**
 * 例子：创建三个窗口买票，总票数为100张，使用实现Runnable接口的方法
 *
 * 1.卖票过程中出现了重票、错票-->出现了线程安全问题
 * 2.问题出现的原因：当某个线程操作车票的过程中，尚未完成操作时，另外一个线程参与进来，操作车票
 * 3.如何解决：当一个线程A在操作ticket时其他线程不能参与进来，直到线程A操作完ticket的时候，其他
 * 线程才能对ticket进行操作，这时即使线程A出现了阻塞，也不能被改变
 *
 * 4.在Java中我们通过同步机制来解决线程安全问题
 * 方式一：同步代码块
 * synchronized (同步监视器)
 * {
 *     //需要被同步的代码
 *
 * }
 * 说明：1.操作共享数据的代码，即为需要被同步的代码 -->不能包含代码多了，也不能包含代码少了
 *      2.共享数据：多个线程共同操作的变量，比如：ticket就是共享数据
 *      3.同步监视器，俗称：锁，任何一个类的对象都可以充当锁.
 *          要求：多个线程必须公用同一把锁
 *
 *
 *          补充：在实现Runnable接口创建多线程的方式中，我们可以考虑使用this作为同步监视器
 * 方式二：同步方法
 *      如果操作共享数据的代码完整的声明在一个方法中，我们不妨将此方法定义为同步方法
 *
 *
 * 5.同步的方式：解决了线程的安全问题-->好处
 *   操作同步代码时，只能有一个线程参与，相当于是一个单线程的过程，效率低-->局限性
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
    Object obj = new Object();
    @Override
    public void run()
    {
        while(true)
        {

            synchronized(this)//此时的this：唯一的window1对象//synchronized(obj)
            {
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
                }else
                {
                    break;
                }
            }
        }

    }
}
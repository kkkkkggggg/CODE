package day01;

/**
 * 测试Thread中的常用方法
 * 1.start():启动当前线程，调用当前线程的run()方法
 * 2.run():通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
 * 3.currentThread():静态方法，返回执行当前代码的线程
 * 4.getName():获取当前线程的名字
 * 5.setName():设置当前线程的名字
 * 6.yield():释放当前cpu的执行权
 * 7.join():在线程A中调用线程B的join()，此时线程A进入阻塞状态，直到线程B执行完以后，线程A才结束
 * 阻塞状态
 * 8.stop():已过时，当执行此方法时，强制结束当前线程
 * 9.sleep(long milistime):让当前线程”睡眠“指定的milletime毫秒，在指定的毫秒时间内线程处于阻塞状态
 * 10.isAlive():判断当前线程是否存活
 *
 *
 * 线程的优先级：
 * 1.MAX_PRIORITY = 10;
 * MIN_PRIORITY = 1;
 * NORM_PRIORITY = 5;
 *
 * 2.如何获取和设置当前线程的优先级
 * getPriority():获取线程的优先级
 * setPriority(int p):设置线程的优先级
 *
 * 说明：高优先级的线程要抢占低优先级线程cpu的执行权，但是只是从概率上来讲，高优先级的线程高概率的
 * 情况下被执行，并不一定是高优先级的线程执行完后，低优先级的线程再被执行
 *
 * @acthor KKKKK
 * @creay 2021-04-13-{TIME}
 */
public class ThreadMethodTest
{
    public static void main(String[] args)
    {
        HelloThread h = new HelloThread("Thread:1");
//        h.setName("线程一");

        //设置线程的优先级
        h.setPriority(Thread.MAX_PRIORITY);
        h.start();


                //给主线程命名
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for(int i = 0; i < 100; i++)
        {
            if(i % 2 == 0)
            {
                System.out.println(Thread.currentThread().getName() + ":" + i + "  " + Thread.currentThread().getPriority());
            }

            if(i == 20)
            {
                try
                {
                    h.join();
                }catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
//        System.out.println(h.isAlive());

    }
}

class HelloThread extends Thread
{
    @Override
    public void run()
    {
        for(int i = 0; i < 100; i++)
        {
            if(i % 2 == 0)
            {
//                try
//                {
//                    sleep(10);
//                }catch(InterruptedException e)
//                {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName() + ":" + i + "  " + Thread.currentThread().getPriority());

            }

//            if(i % 20 == 0)
//            {
//                this.yield();
//            }
        }
    }

    public HelloThread(String name)//通过构造器给线程命名
    {
        super(name);
    }
}


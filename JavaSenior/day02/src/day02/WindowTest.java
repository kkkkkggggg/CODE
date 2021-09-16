package day02;

/**
 *  使用同步代码块解决继承Thread类的方式的线程安全问题
 * 例子：创建三个窗口买票，总票数为100张，使用继承Threa类的方法
 *
 * 存在线程安全问题，待解决
 *
 *  说明：在继承Thread类创建多线程的方式，慎用this充当同步监视器，考虑使用当前类充当同步监视器
 * @acthor KKKKK
 * @creay 2021-04-13-{TIME}
 */
class Window extends Thread
{
    private static int ticket = 100;
    private static Object obj = new Object();
    @Override
    public void run()
    {

        while(true)
        {
            //synchronized(this)错误的方式
            synchronized(obj)//synchronized(Window.class)//两种正确的方式,Window.class只会加载一次
                    //Class clazz = Window.class;此时Class是一个类，clazz是一个变量
            {
                if(ticket > 0)
                {
                    System.out.println(getName() + ":卖票，票号为:" + ticket);
                    ticket--;
                }else
                {
                    break;
                }
            }
        }
    }
}


public class WindowTest
{
    public static void main(String[] args)
    {
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();

        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");

        w1.start();
        w2.start();
        w3.start();
    }
}

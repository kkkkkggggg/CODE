package day01;

import sun.print.SunMinMaxPage;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * �����̵߳ķ�ʽ����ʵ��Callable�ӿ� --->JDK5.0����
 *
 * ������ʵ��Callable�ӿڵķ�ʽ�������̱߳�ʵ��Runnable�ӿڴ������̸߳�ǿ��
 * 1.call()�����з���ֵ
 * 2.call()�����׳��쳣��������Ĳ������񣬻�ȡ�쳣��Ϣ
 * 3.callable��֧�ַ��͵�
 * @acthor KKKKK
 * @creay 2021-04-14-{TIME}
 */

//1.����һ��ʵ��Callable��ʵ����
class NumThread implements Callable
{
    //2.ʵ��call�����������߳�ִ�еĲ���������call������
    @Override
    public Object call() throws Exception
    {
        int sum = 0;
        for(int i = 1; i <= 100; i++)
        {
            if(i % 2 == 0)
            {
                System.out.println(i);
                sum += i;
            }
        }

        return sum;
    }
}

public class ThreadTest2
{
    public static void main(String[] args)
    {
        //3.����callable�ӿ�ʵ����Ķ���
        NumThread n = new NumThread();

        //4.����callable�ӿ�ʵ����Ķ�����Ϊʵ�δ��ݵ�FutureTask��Ĺ������У�����FutureTask����
        FutureTask f = new FutureTask(n);

        //5.��FutureTask�Ķ�����Ϊ�������ݵ�Thread��Ĺ������У�����Thread���󣬲�����start
        new Thread(f).start();
        try
        {
            //6.��ȡCallable�ӿ�ʵ������call�����ķ���ֵ
            //get()����ֵ��ΪFutureTask����������Callableʵ������д��call()�ķ���ֵ
            Object sum = f.get();
            System.out.println("�ܺ�Ϊ" + sum);
        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }catch(ExecutionException e)
        {
            e.printStackTrace();
        }
    }
}

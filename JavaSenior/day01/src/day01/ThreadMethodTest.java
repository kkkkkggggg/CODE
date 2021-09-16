package day01;

/**
 * ����Thread�еĳ��÷���
 * 1.start():������ǰ�̣߳����õ�ǰ�̵߳�run()����
 * 2.run():ͨ����Ҫ��дThread���еĴ˷��������������߳�Ҫִ�еĲ��������ڴ˷�����
 * 3.currentThread():��̬����������ִ�е�ǰ������߳�
 * 4.getName():��ȡ��ǰ�̵߳�����
 * 5.setName():���õ�ǰ�̵߳�����
 * 6.yield():�ͷŵ�ǰcpu��ִ��Ȩ
 * 7.join():���߳�A�е����߳�B��join()����ʱ�߳�A��������״̬��ֱ���߳�Bִ�����Ժ��߳�A�Ž���
 * ����״̬
 * 8.stop():�ѹ�ʱ����ִ�д˷���ʱ��ǿ�ƽ�����ǰ�߳�
 * 9.sleep(long milistime):�õ�ǰ�̡߳�˯�ߡ�ָ����milletime���룬��ָ���ĺ���ʱ�����̴߳�������״̬
 * 10.isAlive():�жϵ�ǰ�߳��Ƿ���
 *
 *
 * �̵߳����ȼ���
 * 1.MAX_PRIORITY = 10;
 * MIN_PRIORITY = 1;
 * NORM_PRIORITY = 5;
 *
 * 2.��λ�ȡ�����õ�ǰ�̵߳����ȼ�
 * getPriority():��ȡ�̵߳����ȼ�
 * setPriority(int p):�����̵߳����ȼ�
 *
 * ˵���������ȼ����߳�Ҫ��ռ�����ȼ��߳�cpu��ִ��Ȩ������ֻ�ǴӸ����������������ȼ����̸߳߸��ʵ�
 * ����±�ִ�У�����һ���Ǹ����ȼ����߳�ִ����󣬵����ȼ����߳��ٱ�ִ��
 *
 * @acthor KKKKK
 * @creay 2021-04-13-{TIME}
 */
public class ThreadMethodTest
{
    public static void main(String[] args)
    {
        HelloThread h = new HelloThread("Thread:1");
//        h.setName("�߳�һ");

        //�����̵߳����ȼ�
        h.setPriority(Thread.MAX_PRIORITY);
        h.start();


                //�����߳�����
        Thread.currentThread().setName("���߳�");
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

    public HelloThread(String name)//ͨ�����������߳�����
    {
        super(name);
    }
}


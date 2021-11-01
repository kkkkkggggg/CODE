package com.atck.case2;

import org.apache.zookeeper.KeeperException;
import org.junit.Test;

import java.io.IOException;

public class DistributedLockTest
{
    @Test
   public void test() throws InterruptedException, IOException, KeeperException
    {
       final DistributedLock distributedLock1 = new DistributedLock();

       final DistributedLock distributedLock2 = new DistributedLock();

       new Thread(new Runnable()
       {
           @Override
           public void run()
           {

               try
               {
                   distributedLock1.zkLock();
                   System.out.println("线程1启动，获取到锁");
                   Thread.sleep(5000);
                   distributedLock1.zkUnlock();
                   System.out.println("线程1释放锁");
               } catch (InterruptedException e)
               {
                   e.printStackTrace();
               }
           }
       }).start();

        new Thread(() ->
        {

            try
            {
                distributedLock2.zkLock();
                System.out.println("线程2启动，获取到锁");
                Thread.sleep(5000);
                distributedLock2.zkUnlock();
                System.out.println("线程2释放锁");
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(Long.MAX_VALUE);
   }
}

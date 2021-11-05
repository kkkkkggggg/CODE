package com.atck.zk;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ZkClient
{
    // 注意：逗号前后不能有空格
    private static String connectString = "zookeeper00:2181,zookeeper01:2181,zookeeper02:2181";

    private static int sessionTimeout = 60000;
    private ZooKeeper zkClient = null;

    @Before
    // @Test
    public void init() throws Exception
    {
        zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            public void process(WatchedEvent watchedEvent)
            {
                // // 收到事件通知后的回调函数（用户的业务逻辑）
                // System.out.println(watchedEvent.getType() + "--" + watchedEvent.getPath());
                //
                // System.out.println("---------------------------------------------------");
                // // 再次启动监听
                // try
                // {
                //     List<String> children = zkClient.getChildren("/", true);
                //     for (String child : children)
                //     {
                //         System.out.println(child);
                //     }
                //     System.out.println("-----------------------------------------------");
                // } catch (Exception e)
                // {
                //     e.printStackTrace();
                // }
            }
        });
    }

    // 创建子节点
    @Test
    public void create() throws Exception
    {
        // // 参数1：要创建的节点的路径； 参数2：节点数据 ； 参数3：节点权限 ；参数4：节点的类型
        String 	nodeCreated = zkClient.create("/atck", "shuaige".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

    }


    // 获取子节点
    @Test
    public void getChildren() throws Exception
    {
        List<String> children = zkClient.getChildren("/", true);
        for (String child : children)
        {
            System.out.println(child);
        }
        // 延时阻塞
        Thread.sleep(Long.MAX_VALUE);
    }

    @Test
    public void exists() throws KeeperException, InterruptedException
    {
        Stat stat = zkClient.exists("/atck", false);
        System.out.println(stat == null? false : true);
    }
}



package com.atck.jedis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

/**
 * 演示redis集群操作
 */
public class RedisClusterDemo
{
    public static void main(String[] args)
    {
        //创建对象
        HostAndPort hostAndPort = new HostAndPort("192.168.153.128", 6380);

        JedisCluster jedisCluster = new JedisCluster(hostAndPort);

        jedisCluster.set("b1", "value1");

        String b1 = jedisCluster.get("b1");

        System.out.println(b1);

        jedisCluster.close();
    }
}

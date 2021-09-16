package com.atck.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

public class JedisDemo1
{
    public static void main(String[] args)
    {
        //创建jedis对象
        Jedis jedis = new Jedis("192.168.153.128",6379);

        //测试
        String ping = jedis.ping();
        System.out.println(ping);
//        jedis.set("k1","v1");

    }

    @Test
    public void demo1()
    {
        //创建jedis对象
        Jedis jedis = new Jedis("192.168.153.128",6379);

//        //添加
//        jedis.set("name","lucy");
//        //获取
//        System.out.println(jedis.get("name"));

        //设置多个key-value
        jedis.mset("k1","v1","k2","v2");
        List<String> mget = jedis.mget("k1","k2");
        System.out.println(mget);



//        Set<String> keys = jedis.keys("*");
//
//        for (String key :keys)
//        {
//            System.out.println(key);
//        }
    }

    @Test
    public void demo2()
    {
        //创建jedis对象
        Jedis jedis = new Jedis("192.168.153.128",6379);

        jedis.lpush("key1","lucy","mary","jack");

        List<String> lrange = jedis.lrange("key1", 0, -1);
        System.out.println(lrange);
    }

    @Test
    public void demo3()
    {
        //创建jedis对象
        Jedis jedis = new Jedis("192.168.153.128", 6379);

        jedis.sadd("name1","lucy","jack");

        Set<String> smembers = jedis.smembers("name1");

        System.out.println(smembers);
    }

    @Test
    public void demo4()
    {
        //创建jedis对象
        Jedis jedis = new Jedis("192.168.153.128", 6379);

        jedis.hset("users","age","20");

        String hget = jedis.hget("users", "age");

        System.out.println(hget);
    }

    @Test
    public void demo5()
    {
//        //创建jedis对象
//        Jedis jedis = new Jedis("192.168.153.128", 6379);
//
//        jedis.zadd("china",100d,"shanghai");
//
//        Set<String> china = jedis.zrange("china", 0, -1);
//
//        System.out.println(china);


        //创建jedis对象
        Jedis jedis = new Jedis("192.168.153.128", 6379);

        List<String> lrange = jedis.lrange("phone", 0, -1);

        System.out.println(lrange.size());
    }
}

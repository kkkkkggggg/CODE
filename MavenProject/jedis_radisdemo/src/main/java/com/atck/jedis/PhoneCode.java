package com.atck.jedis;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Random;

public class PhoneCode
{
    public static void main(String[] args)
    {
        //模拟验证码发送
        verifyCode("13755886699");

//        getRedisCode("13755886699","380896");

    }

    //生成六位数字验证码
    public static String getCode()
    {

        Random random = new Random();
        String code = "";

        for (int i = 0; i < 6; i++)
        {
            code +=random.nextInt(10);
        }

        return code;
    }

    //每个手机每天只能发送三次，验证码放到redis中，设置过期时间
    public static void verifyCode(String phone)
    {
        //创建jedis对象
        Jedis jedis = new Jedis("192.168.153.128", 6379);

        //拼接key
        //手机发送次数key
        String countKey = "VerifyCode" + phone + ":count";
        //验证码key
        String codeKey = "VerifyCode" + phone + ":code";

        //每个手机每天只能发送三次
        String count = jedis.get(countKey);
        if (count == null)
        {
            //没有发送次数，第一次发送，设置发送次数是1
            jedis.setex(countKey,24*60*60,"1");
        }else if (Integer.parseInt(count) <= 2)
        {
            jedis.incr(countKey);
        }else if (Integer.parseInt(count) > 2)
        {
            //发送三次，不能再发送了
            System.out.println("今天发送次数已经超过三次");
            jedis.close();
        }

        //发送的验证码放到redis里面
        String vcode = getCode();
        jedis.setex(codeKey,120,vcode);
        jedis.close();

    }

    //验证码校验
    public static void getRedisCode(String phone,String code)
    {
        //创建jedis对象
        Jedis jedis = new Jedis("192.168.153.128", 6379);

        //拼接key
        //验证码key
        String codeKey = "VerifyCode" + phone + ":code";

        String redisCode = jedis.get(codeKey);

        if (code.equals(redisCode))
        {
            System.out.println("成功");
        }else
        {
            System.out.println("失败");
        }

        jedis.close();
    }
}

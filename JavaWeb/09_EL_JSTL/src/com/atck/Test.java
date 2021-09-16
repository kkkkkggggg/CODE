package com.atck;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Test
{
    public static void main(String[] args) throws Exception
    {
        String content = "这是需要Base64编码的内容";

        //创建一个Base64编码器
        BASE64Encoder base64Encoder = new BASE64Encoder();
        //执行Base64编码操作
        String encode = base64Encoder.encode(content.getBytes("UTF-8"));
        System.out.println();

        BASE64Decoder base64Decoder = new BASE64Decoder();

        byte[] bytes = base64Decoder.decodeBuffer(encode);

        System.out.println(new String(bytes));
    }
}

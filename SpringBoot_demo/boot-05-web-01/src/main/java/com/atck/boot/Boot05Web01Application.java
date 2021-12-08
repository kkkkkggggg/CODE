package com.atck.boot;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import org.apache.tomcat.util.buf.HexUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.websocket.Decoder;

@SpringBootApplication
public class Boot05Web01Application
{

    public static void main(String[] args)
    {
        SpringApplication.run(Boot05Web01Application.class, args);

    }


    public static void math(int n)
    {
        n |= n >>> 1;
        System.out.println(n);
    }

}

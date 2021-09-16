package com.ck.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseIOServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        System.out.println(resp.getCharacterEncoding());//默认ISPO-8859-1

//        //通过响应头设置浏览器也使用UTF-8字符集
//        resp.setHeader("Content-Type","UTF-8");
//
//
//        //设置服务器字符集为UTF-8
//        resp.setCharacterEncoding("UTF-8");

        //它会同时设置服务器和客户端都使用UTF-8编码，还设置了响应体
        //注意：此方法一定要在获取流对象之前调用才有效
        resp.setContentType("text/html;charset=UTF-8");




        //往客户端回传 字符串 数据
        PrintWriter writer = resp.getWriter();

        writer.write("送嗲跑");

        System.out.println(resp.getContentType());
    }
}

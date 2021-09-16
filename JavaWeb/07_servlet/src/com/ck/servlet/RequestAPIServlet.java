package com.ck.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestAPIServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
//        i. getRequestURI() 获取请求的资源路径
        System.out.println("URI =>" + req.getRequestURI());

//        ii. getRequestURL() 获取请求的统一资源定位符（绝对路径）
        System.out.println("URl =>" + req.getRequestURL());
//        iii. getRemoteHost() 获取客户端的 ip 地址
        System.out.println("IP =>" + req.getRemoteHost());
        /*在idea中使用Localhost访问时，得到的客户端ip地址是 ===》》127.0.0.1
        在idea中使用127.0.0.1访问时，得到的客户端ip地址是 ===》》127.0.0.1
        在idea中使用真实ip访问时访问时，得到的客户端ip地址是 ===》》真实ip
        * */
//        iv. getHeader() 获取请求头
        System.out.println("Header =>" + req.getHeader("User-Agent"));

//        v. getParameter() 获取请求的参数
//        vi. getParameterValues() 获取请求的参数（多个值的时候使用）
//        vii. getMethod() 获取请求的方式 GET 或 POST
        System.out.println("Method =>" + req.getMethod());
    }
}

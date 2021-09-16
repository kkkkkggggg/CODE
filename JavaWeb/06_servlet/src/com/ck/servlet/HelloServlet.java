package com.ck.servlet;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

public class HelloServlet implements Servlet
{
    public HelloServlet()
    {
        System.out.println("1 构造器方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException
    {

        System.out.println("2 init初始化");

        //1.可以获取Servlet程序的别名
        System.out.println("HelloServlet程序的别名是：" + servletConfig.getServletName());
        //2.获取初始化参数init-param
        System.out.println("初始化参数username的值是" + servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是" + servletConfig.getInitParameter("url"));



        //3.获取ServletContext对象
        servletConfig.getServletContext();
    }

    @Override
    public ServletConfig getServletConfig()
    {
        return null;
    }

    /**
     * service方法是专门用来处理请求和响应的
     *
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException
    {
        System.out.println("3 service == helloservlet被访问了");
        //类型转换
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        //获取请求方式
        String method = httpServletRequest.getMethod();

        if ("GET".equals(method))
        {
            doGet();
        } else if ("POST".equals(method))
        {
            doPost();
        }

    }

    //做Get请求的操作
    public void doGet()
    {
        System.out.println("get请求");
    }

    //做Post请求的操作
    public void doPost()
    {
        System.out.println("post请求");
    }

    @Override
    public String getServletInfo()
    {
        return null;
    }

    @Override
    public void destroy()
    {
        System.out.println("4. destory销毁方法");
    }
}

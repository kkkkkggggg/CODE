package com.ck.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;

public class ContextServlet extends HttpServlet
{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("ContextServlet的doPost方法");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //1.获取web.xml中配置的上下文参数context-param
        ServletContext servletContext = getServletConfig().getServletContext();
        System.out.println("上下文参数username:" + servletContext.getInitParameter("username"));
        System.out.println("上下文参数path:" + servletContext.getInitParameter("path"));

        //2.获取当前的工程路径，格式：/工程路径
        System.out.println("工程路径" + servletContext.getContextPath());


        //3.获取工程部署后在服务器硬盘上的绝对路径
        /*
        / 斜杠被服务器解析地址为：http://ip:port/工程名/  映射到IDEA代码的文本目录
         */
        System.out.println("工程部署的路径是:" + servletContext.getRealPath("/"));

        System.out.println("工程下css目录的绝对路径:" + servletContext.getRealPath("/css"));

        System.out.println("工程下imgs目录0.jpg的绝对路径是：" + servletContext.getRealPath("/imgs/0.jpg"));

//        System.out.println("ContextServlet的doGet方法");
    }
}

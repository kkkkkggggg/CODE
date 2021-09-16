package com.ck.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ContextServlet1 extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("ContextServlet1的doGet方法");

        ServletContext context = getServletContext();
        System.out.println("ContextServlet1中的ServletContext对象" + context);
        System.out.println("保存之前ContextServlet1中获取域数据key1的值是：" + context.getAttribute("key1"));

        context.setAttribute("key1","value1");

        System.out.println("ContextServlet1中获取域数据key1的值是：" + context.getAttribute("key1"));
    }
}

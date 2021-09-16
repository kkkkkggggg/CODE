package com.ck.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ContextServlet2 extends HttpServlet
{


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("ContextServlet2中的ServletContext对象" + getServletContext());

        System.out.println("ContextServlet2中获取域数据key1的值是：" + getServletContext().getAttribute("key1"));
    }
}

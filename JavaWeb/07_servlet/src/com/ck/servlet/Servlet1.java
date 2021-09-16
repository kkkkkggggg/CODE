package com.ck.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet1 extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //获取请求的参数
        String username = req.getParameter("username");
        System.out.println("在servlet1 （柜台一）中查看参数（材料）： " + username);

        //给材料盖一个章并传递到Servlet2（柜台二）去查看
        req.setAttribute("key","柜台一的章");

        //问路：Servlet2（柜台2）怎么走
        /*
        请求转发必须要以斜杠打头，斜杠表示地址为：http://ip:port/工程名/ ,映射到IEDEA代码的web目录
        */
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/servlet2");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/from.html");

        //走向Servlet2
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        super.doPost(req, resp);
    }
}

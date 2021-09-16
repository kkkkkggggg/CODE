package com.ck.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class ParameterServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        System.out.println("--------------------doGet-------------------------");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
//        String hobby = req.getParameter("hobby");
        String[] hobbies = req.getParameterValues("hobby");//当参数有多个值的时候使用getParameterValues
        System.out.println(username + " " + password + " " + Arrays.asList(hobbies));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //设置请求体的字符集为UTF-8从而解决post请求的中文乱码问题
        req.setCharacterEncoding("UTF-8");
        System.out.println("--------------------doPost-------------------------");
        //获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobbies = req.getParameterValues("hobby");

        System.out.println(username + " " + password + " " + Arrays.asList(hobbies));
    }

}

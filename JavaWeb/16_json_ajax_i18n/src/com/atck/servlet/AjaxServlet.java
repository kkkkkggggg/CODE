package com.atck.servlet;

import com.atck.pojo.Person;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AjaxServlet extends BaseServlet
{

    protected void javaScriptAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        System.out.println("Ajax请求过来了");

        Person person = new Person(1,"p1");

        try
        {
            Thread.sleep(3000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        //json格式的字符串
        Gson gson = new Gson();

        String personString = gson.toJson(person);

        resp.getWriter().append(personString);
    }

    protected void jQuaryAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        System.out.println("jQuaryAjax方法调用了");

        Person person = new Person(1,"p1");

        try
        {
            Thread.sleep(3000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        //json格式的字符串
        Gson gson = new Gson();

        String personString = gson.toJson(person);

        resp.getWriter().append(personString);
    }

    protected void jQuerySerialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        System.out.println("jQuerySerialize方法调用了");

        System.out.println("username=" + req.getParameter("username"));
        System.out.println("password=" + req.getParameter("password"));


        Person person = new Person(1,"p1");

        try
        {
            Thread.sleep(3000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        //json格式的字符串
        Gson gson = new Gson();

        String personString = gson.toJson(person);

        resp.getWriter().append(personString);
    }
}

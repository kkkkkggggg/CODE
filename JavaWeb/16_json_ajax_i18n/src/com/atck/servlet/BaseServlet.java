package com.atck.servlet;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public abstract class BaseServlet extends HttpServlet
{


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

        resp.setContentType("text/html;charset=UTF-8");
        // resp.setCharacterEncoding("UTF-8");
        //解决中文响应乱码
        req.setCharacterEncoding("UTF-8");

        String action = req.getParameter("action");

        Class<? extends BaseServlet> userServletClass = this.getClass();

        try
        {
            Method method = userServletClass.getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            // System.out.println(method.toString());
            method.setAccessible(true);
            method.invoke(this,req,resp);
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);//把异常抛给filter过滤器
        }


        // if ("login".equals(action))
        // {
        //     login(req,resp);
        // }else if ("regist".equals(action))
        // {
        //    regist(req,resp);
        // }



    }
}

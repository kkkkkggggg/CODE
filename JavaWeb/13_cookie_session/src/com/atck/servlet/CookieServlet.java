package com.atck.servlet;

import com.atck.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends  BaseServlet
{

    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //1.创建Cookie对象
        Cookie cookie = new Cookie("key1","value1");
        //2.通知客户端保存Cookie
        resp.addCookie(cookie);

        //1.创建Cookie对象
        Cookie cookie1 = new Cookie("key2","value2");
        //2.通知客户端保存Cookie
        resp.addCookie(cookie1);
        resp.getWriter().write("Cookie创建成功");
    }

    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Cookie[] cookies = req.getCookies();


        for (Cookie cookie : cookies)
        {
            //getName方法，返回cookie的key的名称
            resp.getWriter().write("Cookie[" + cookie.getName() + "=" + cookie.getValue() + "]<br>");

        }

        Cookie iwantcookie = CookieUtils.findCookie("key1",cookies);

        if (iwantcookie != null)
        {
           resp.getWriter().write("找到了需要的cookie");
        }

    }

    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        // //方案一
        // //1.先创建一个同名的cookie对象
        // //2.在构造器，同时赋予新的cookie值
        // Cookie cookie = new Cookie("key1","updateValue1");
        // //3.调用response。addCookie（cookie）
        // resp.addCookie(cookie);
        // System.out.println("更新了cookie key1的值");

        //方案二
        //1.先查找到需要修改的cookie对象
        Cookie[] cookies = req.getCookies();

        Cookie newCookie = CookieUtils.findCookie("key2",cookies);


        //2.调用setValue方法赋予新的cookie值
        newCookie.setValue("updateValue2");
        //3.调用response.addcookie()通知客户端保存修改
        resp.addCookie(newCookie);
    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Cookie cookie = new Cookie("defaultLife","defaultLife");

        cookie.setMaxAge(-1);//设置存活时间
        resp.addCookie(cookie);
    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //找到要删除的cookie对象
        Cookie key2 = CookieUtils.findCookie("key2", req.getCookies());

        if(key2 != null)
        {
            //调用setMaxAge(0)
            key2.setMaxAge(0);//表示马上删除，不需要等到浏览器关闭
            //调用resp.addCookie(key2)
            resp.addCookie(key2);
        }


    }

    protected void life3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        // //找到要设置生命周期的cookie对象
        Cookie key1 = CookieUtils.findCookie("key1", req.getCookies());

        if (key1 != null)
        {
            //调用setMaxAge(0)
            key1.setMaxAge(3600);//设置Cookie一小时后被删除

            //调用resp.addCookie(key2)
            resp.addCookie(key1);
        }
    }

    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Cookie cookie = new Cookie("path1","path1");

        //getContextPath() ===>>> 得到工程路径
        cookie.setPath(req.getContextPath() + "/abc");//===>>> /工程路径/abc
        resp.addCookie(cookie);
        resp.getWriter().write("创建了一个带有工程路径的Cookie");
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {


        Cookie[] cookies = req.getCookies();

        if (CookieUtils.findCookie("username",cookies) != null)
        {
            Cookie usernameCookie = CookieUtils.findCookie("username",cookies);

            req.setAttribute("username",usernameCookie.getValue());

            req.getRequestDispatcher("/logincheck.jsp").forward(req,resp);
            return;
        }

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if ("admin".equals(username) && "admin".equals(password))
        {

            Cookie cookie = new Cookie("username",username);
            Cookie cookie1 = new Cookie("password",password);
            resp.addCookie(cookie);
            resp.addCookie(cookie1);
            req.getRequestDispatcher("/loginsucceed.jsp").forward(req,resp);
            return;
        }

        req.getRequestDispatcher("/logincheck.jsp").forward(req,resp);
    }

}

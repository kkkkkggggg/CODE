package com.atck.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class SessionServlet extends BaseServlet
{
    protected void createOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //创建或获取session会话对象
        HttpSession session = req.getSession();

        //判断当前session会话是否是新创建出来的
        boolean aNew = session.isNew();
        //获取session会话的唯一标识id
        String id = session.getId();

        resp.getWriter().write("得到的session，它的id是" + id + "<br/>");
        resp.getWriter().write("这个session，它是否是新创建的" + aNew + "<br/>");


    }

    /**
     * 往session域中保存数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.getSession().setAttribute("key1","value1");
    }

    /**
     * 获取session域中的数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Object key1 = req.getSession().getAttribute("key1");

        resp.getWriter().write("从session中获取的key1的数据是" + key1);
    }

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //获取了session的默认超时时长
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();
        resp.getWriter().write("session的默认超时时长是" + maxInactiveInterval);
    }

    protected void life3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //先获取session对象
        HttpSession session = req.getSession();
        //设置当前session3秒后超时
        session.setMaxInactiveInterval(3);

        resp.getWriter().write("当前session已经设置为3秒后超时");
    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //获取session对象
        HttpSession session = req.getSession();
        //设置session立刻过时
        session.invalidate();

        resp.getWriter().write("当前session已设置为立刻过时");
    }
}

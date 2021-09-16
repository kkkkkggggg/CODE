package com.atck.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //获取session中的验证码0
        String kaptcha_session_key = (String) req.getSession().getAttribute("KAPTCHA_SESSION_KEY");
        //删除验证码
        req.getSession().removeAttribute("KAPTCHA_SESSION_KEY");
        String code = req.getParameter("code");
        if (kaptcha_session_key != null && kaptcha_session_key.equalsIgnoreCase(code))
        {
            //获取用户名
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            System.out.println("保存到数据库：" + username);
            // req.getRequestDispatcher("/ok.jsp").forward(req,resp);
            // try
            // {
            //     Thread.sleep(5000);
            // } catch (InterruptedException e)
            // {
            //     e.printStackTrace();
            // }
            resp.sendRedirect(req.getContextPath() + "/ok.jsp");
        }
    }

}

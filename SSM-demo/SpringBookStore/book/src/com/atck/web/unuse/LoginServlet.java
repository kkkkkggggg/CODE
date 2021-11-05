package com.atck.web.unuse;

import com.atck.pojo.User;
import com.atck.service.UserService;
import com.atck.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet
{
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = userService.login(new User(null, username, password, null));

        if (user == null)
        {
            //把错误信息，和回显的表单项信息，保存到Request域中
            req.setAttribute("msg","用户名或密码错误");
            req.setAttribute("username",username);

            //跳回登录页面
            req.getRequestDispatcher("pages/user/login.jsp").forward(req,resp);
        }else
        {
            //登录成功
            //跳到成功页面login_success.jsp
            req.getRequestDispatcher("pages/user/login_success.jsp").forward(req,resp);
        }

    }
}

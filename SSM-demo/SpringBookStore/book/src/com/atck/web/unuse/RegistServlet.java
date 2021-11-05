package com.atck.web.unuse;

import com.atck.pojo.User;
import com.atck.service.UserService;
import com.atck.service.impl.UserServiceImpl;
import com.atck.utils.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet
{
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //1.获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        //2.检查验证码是否正确
        if ("bnbnp".equalsIgnoreCase(code))
        {
            //正确
            //3.检查用户名是否可用
            if (!(userService.existsUsername(username)))
            {
                //可用,调用Service保存到数据库,跳转到注册成功页面 regist_success.jsp
                userService.registUser(new User(null,username,password,email));

                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }else
            {
                //将注册信息保存到request域中，用于页面回显
                req.setAttribute("errorMsg","用户名不可用");
                req.setAttribute("username",username);
                req.setAttribute("password",password);
                req.setAttribute("email",email);


                //不可用跳,回注册页面

                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }
        }else
        {
            //不正确
            //跳回注册页面
            req.setAttribute("errorMsg","验证码错误");
            req.setAttribute("username",username);
            req.setAttribute("password",password);
            req.setAttribute("email",email);

            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }


    }
}

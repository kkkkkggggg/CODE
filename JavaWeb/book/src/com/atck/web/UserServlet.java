package com.atck.web;

import com.atck.pojo.User;
import com.atck.service.UserService;
import com.atck.service.impl.UserServiceImpl;
import com.atck.utils.JDBCUtils;
import com.atck.utils.WebUtils;
import com.google.gson.Gson;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UserServlet extends BaseServlet
{
    private UserService userService = new UserServiceImpl();
    // private UserService userService = new UserServiceImpl();
    // @Override
    // protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    // {
    //
    //     String action = req.getParameter("action");
    //     Class<? extends UserServlet> userServletClass = this.getClass();
    //
    //     try
    //     {
    //         Method method = userServletClass.getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
    //         System.out.println(method.toString());
    //         method.setAccessible(true);
    //         method.invoke(this,req,resp);
    //     } catch (NoSuchMethodException e)
    //     {
    //         e.printStackTrace();
    //     } catch (IllegalAccessException e)
    //     {
    //         e.printStackTrace();
    //     } catch (InvocationTargetException e)
    //     {
    //         e.printStackTrace();
    //     }
    //
    //
    //     // if ("login".equals(action))
    //     // {
    //     //     login(req,resp);
    //     // }else if ("regist".equals(action))
    //     // {
    //     //    regist(req,resp);
    //     // }
    //
    // }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

        String username = req.getParameter("username");
        // String password = req.getParameter("password");

        User user1 = new User();
        WebUtils.copyParamToBean(req.getParameterMap(),user1);

        User user = userService.login(user1);


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
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            //跳到成功页面login_success.jsp
            req.getRequestDispatcher("pages/user/login_success.jsp").forward(req,resp);
        }
    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //获取用户输入的验证码
        String code = req.getParameter("code");
        //获取系统生成的验证码
        String kaptcha = (String) req.getSession().getAttribute("KAPTCHA_SESSION_KEY");
        //删除session域中的验证码
        req.getSession().removeAttribute("KAPTCHA_SESSION_KEY");

        //1.获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        User user = WebUtils.copyParamToBean(req.getParameterMap(),new User());

        //2.检查验证码是否正确
        if (kaptcha != null && kaptcha.equalsIgnoreCase(code))
        {
            //正确
            //3.检查用户名是否可用
            boolean res = userService.existsUsername(username);


            if (!(res))
            {
                //可用,调用Service保存到数据库,跳转到注册成功页面 regist_success.jsp

                userService.registUser(user);

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

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.getSession().invalidate();

        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }

    protected void checkUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String username = req.getParameter("username");

        boolean b = userService.existsUsername(username);



        String s = "{\"result\":" + "\"" + b + "\"" + "}";

        resp.getWriter().append(s);

    }
}

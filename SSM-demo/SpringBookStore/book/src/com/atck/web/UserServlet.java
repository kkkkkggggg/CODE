package com.atck.web;

import com.atck.pojo.User;
import com.atck.service.UserService;
import com.atck.service.impl.UserServiceImpl;
import com.atck.utils.JDBCUtils;
import com.atck.utils.WebUtils;
import com.google.gson.Gson;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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

    private UserService userService = WebUtils.getBean(UserService.class);
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
            //?????????????????????????????????????????????????????????Request??????
            req.setAttribute("msg","????????????????????????");
            req.setAttribute("username",username);

            //??????????????????
            req.getRequestDispatcher("pages/user/login.jsp").forward(req,resp);
        }else
        {
            //????????????
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            //??????????????????login_success.jsp
            req.getRequestDispatcher("pages/user/login_success.jsp").forward(req,resp);
        }
    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //??????????????????????????????
        String code = req.getParameter("code");
        //??????????????????????????????
        String kaptcha = (String) req.getSession().getAttribute("KAPTCHA_SESSION_KEY");
        //??????session??????????????????
        req.getSession().removeAttribute("KAPTCHA_SESSION_KEY");

        //1.?????????????????????
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        User user = WebUtils.copyParamToBean(req.getParameterMap(),new User());

        //2.???????????????????????????
        if (kaptcha != null && kaptcha.equalsIgnoreCase(code))
        {
            //??????
            //3.???????????????????????????
            boolean res = userService.existsUsername(username);


            if (!(res))
            {
                //??????,??????Service??????????????????,??????????????????????????? regist_success.jsp

                userService.registUser(user);

                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }else
            {
                //????????????????????????request???????????????????????????
                req.setAttribute("errorMsg","??????????????????");
                req.setAttribute("username",username);
                req.setAttribute("password",password);
                req.setAttribute("email",email);


                //????????????,???????????????

                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }
        }else
        {
            //?????????
            //??????????????????
            req.setAttribute("errorMsg","???????????????");
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

package com.atck;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController
{
    @RequestMapping("/hello")
    public String hello()
    {
        //如果想在执行完servlet后去到hello.jsp页面
        //方法一，相对路径
        return "success";
    }

    /**
     * forward:转发到一个页面
     * /hello.jsp:转发到当前项目的hello
     *
     * 一定要加上/,如果不加/就是相对路径，容易出问题
     * forward:/hello.jsp
     *
     * forward:前缀的转发不会由视图解析器进行拼串
     * @return
     */
    @RequestMapping("/handle01")
    public String handle01()
    {
        System.out.println("handle01");
        return "forward:/hello.jsp";
    }

    @RequestMapping("/handle02")
    public String handle02()
    {
        System.out.println("handle02");
        return "forward:/handle01";
    }

    /**
     * 重定向到hello.jsp页面
     * 有前缀的转发和重定向操作，配置的视图解析器就不会进行拼串，
     *
     *
     * 转发       forward:转发的路径
     * 重定向      redirect:重定向的路径
     *              /hello.jsp:代表的就是从当前项目下开始，SpringMVC会为路径自动拼接上项目名
     *
     *
     * 原生的Servlet重定向/路径需要加上项目名才能成功
     * response.sendRedirect("/hello.jsp")
     * @return
     */
    @RequestMapping("/handle03")
    public String handle03()
    {
        System.out.println("handle03");
        return "redirect:/hello.jsp";
    }

    @RequestMapping("/handle04")
    public String handle04()
    {
        System.out.println("handle04");
        return "redirect:/handle03";
    }

    // @RequestMapping("/toLoginPage")
    // public  String toLoginPage()
    // {
    //     return "login";
    // }
}

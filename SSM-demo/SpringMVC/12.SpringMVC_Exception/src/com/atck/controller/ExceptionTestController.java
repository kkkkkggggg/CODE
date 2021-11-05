package com.atck.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionTestController
{
    // @ResponseStatus(reason = "反正我错了",value = HttpStatus.NOT_EXTENDED)
    @RequestMapping("/handle01")
    public String handle01(@RequestParam(value = "i",required = false) Integer i)
    {
        System.out.println("handle01......");
        System.out.println(10 / i);
        return "success";
    }

    @RequestMapping("/handle02")
    public String handle02(@RequestParam(value = "username") String username)
    {
        System.out.println("handle02......");
        if (!"admin".equals(username))
        {
            System.out.println("登录失败");
            throw new UsernameNotFoundException();
        }

        System.out.println("登录成功");
        return "success";
    }

    @RequestMapping(value = "/handle03",method = RequestMethod.POST)
    public String handle03()
    {
        System.out.println("handle03......");
        return "success";
    }

    /**
     * 告诉SpringMVC这个类专门处理这个类发生的所有异常
     * 1、给方法上随便写一个Exception，用来接收发生的异常
     * 2、要携带异常信息不能给参数位置写Model
     * 3、返回modelAndView就行
     * 4、如果有多个@ExceptionHandler都能处理这个异常，精确匹配
     * 5、全局异常处理类域本类异常处理方法同时存在时，本类优先
     */
    @ExceptionHandler(value = {ArithmeticException.class})
    public ModelAndView handleException01(Exception e)
    {

        System.out.println("handleException01........." + e);

        ModelAndView myerror = new ModelAndView("myerror");
        //视图解析器拼串
        myerror.addObject("ex",e);
        return myerror;
    }

    // @ExceptionHandler(value = {NullPointerException.class})
    // public ModelAndView handleException02(Exception e)
    // {
    //
    //     System.out.println("handleException01........." + e);
    //
    //     ModelAndView myerror = new ModelAndView("myerror");
    //     //视图解析器拼串
    //     myerror.addObject("ex",e);
    //     return myerror;
    // }
}

package com.atck.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 集中处理所有异常
 *
 * 1、集中处理所有异常的类需要加入到ioc容器中
 * 2、@ControllerAdvice这个注解表示专门处理异常的类
 */
// @ControllerAdvice
public class MyJiZhongException
{
    @ExceptionHandler(value = {NullPointerException.class})
    public ModelAndView handleException01(Exception e)
    {

        System.out.println("全局的：handleException01........." + e);

        ModelAndView myerror = new ModelAndView("myerror");
        myerror.addObject("ex",e);
        return myerror;
    }

    @ExceptionHandler(value = {ArithmeticException.class})
    public ModelAndView handleException02(Exception e)
    {

        System.out.println("全局的：handleException02........." + e);

        ModelAndView myerror = new ModelAndView("myerror");

        myerror.addObject("ex",e);
        return myerror;
    }
}

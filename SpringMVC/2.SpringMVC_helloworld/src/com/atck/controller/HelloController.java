package com.atck.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController
{
    @RequestMapping("/hello01")
    public String hello01()
    {
        System.out.println("已收到请求，正在处理");
        return "success";
    }

    @RequestMapping("/hello02")
    public String hello02()
    {
        return "error";
    }

    @RequestMapping("/hello03")
    public String hello03()
    {
        return "default";
    }
}

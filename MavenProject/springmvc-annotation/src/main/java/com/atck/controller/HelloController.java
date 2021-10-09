package com.atck.controller;

import com.atck.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController
{
    @Autowired
    HelloService helloService;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello()
    {
        String sayHello = helloService.sayHello("tomcat");
        return sayHello;
    }

    @RequestMapping("/success")
    public String success()
    {
        return "success";
    }
}

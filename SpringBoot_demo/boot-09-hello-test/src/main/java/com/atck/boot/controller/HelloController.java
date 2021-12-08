package com.atck.boot.controller;

import com.atck.atck.hello.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
    @Autowired
    HelloService helloService;

    @GetMapping("/")
    public String sayHello()
    {
        return helloService.sayHello("kkkkk");
    }
}

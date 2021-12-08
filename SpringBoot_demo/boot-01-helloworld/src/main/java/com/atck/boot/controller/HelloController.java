package com.atck.boot.controller;

import com.atck.boot.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
// @ResponseBody
// @Controller
@RestController
public class HelloController
{
    @Autowired
    Car mycar;

    @RequestMapping("/car")
    public Car car()
    {
        return mycar;
    }

    @RequestMapping("/hello")
    public String hello(@RequestParam("name") String name)
    {
        log.info("请求进来了");
        return "hello!springboot 2!你好" + name;
    }
}

package com.atck.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestMVC
{
    @RequestMapping("/hello")
    public String hello()
    {
        return "success";
    }
}

package com.atck.boot.controller;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController
{
    @RequestMapping("/91247180_p0.png")
    public String hello()
    {
        return "aaaaa";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUser()
    {
        return "GET-张三";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    // @PostMapping("/user")
    public String saveUser()
    {
        return "POST-张三";
    }


    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    // @PutMapping("/user")
    public String putUser()
    {
        return "PUT-张三";
    }

    // @DeleteMapping("/user")
    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public String deleteUser()
    {
        return "DELETE-张三";
    }
}

package com.atck.boot.controller;

import com.atck.boot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController
{
    @Autowired
    private Person person;

    @ResponseBody
    @RequestMapping("/hello")
    public Person hello()
    {
        System.out.println(person.getUserName());
        return person;
    }
}

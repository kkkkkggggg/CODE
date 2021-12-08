package com.atck.boot.controller;

import com.atck.boot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
    @Value("${person.name:李四}")
    private String name;

    @Autowired
    private Person person;

    @Value("${MAVEN_HOME}")
    private String msg;

    // @Autowired
    // private Color color;

    @Value("${os.name}")
    private String osName;

    @ResponseBody
    @GetMapping("/hello")
    public Person getPerson()
    {
        return person;
    }

    @GetMapping("/msg")
    public String getMsg()
    {
        return msg + "" + osName;
    }
}

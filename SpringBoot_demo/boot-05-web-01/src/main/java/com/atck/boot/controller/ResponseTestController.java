package com.atck.boot.controller;

import com.atck.boot.bean.Person;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.Date;

@Controller
public class ResponseTestController
{

    /**
     * 1.浏览器发送请求直接返回xml     【application/xml】       jacksonXmlConverter
     * 2.如果是ajax发送的请求，发挥json        [application/json]      jacksonJsonConverter
     * 3.如果app发送请求，返回自定义协议数据        [application/x-atck]  xxxConverter
     * 属性值1;属性值2
     *
     * @return 步骤：
     * 1.添加自定义的MessageConverter进系统底层
     * 2.系统底层就会统计出所有MessageConverter能操作哪些数据类型
     * 3.客户端内容协商【atck--->atck】
     */
    @ResponseBody
    @GetMapping("/test/person")
    public Person getPerson()
    {
        Person person = new Person();
        person.setAge(28);
        person.setBirth(new Date());
        person.setUserName("zhangsan");
        return person;
    }

    @ResponseBody
    @GetMapping("/he11")
    public FileSystemResource fileSystemResource()
    {
        //文件以这样的方式返回看是谁处理的
        //ResourceHttpMessageConverter
        FileSystemResource fileSystemResource = new FileSystemResource("D:\\DevelopmentDocument\\SpringBoot_demo\\boot-05-web-01\\src\\main\\resources\\public\\hahah.txt");

        File file = fileSystemResource.getFile();

        String name = file.getName();
        System.out.println(name);
        System.out.println(file.canRead());

        return fileSystemResource;
    }
}

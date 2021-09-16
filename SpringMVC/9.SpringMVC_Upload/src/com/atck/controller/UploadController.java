package com.atck.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

import java.io.File;
import java.io.IOException;

@Controller
public class UploadController
{
    //单文件上传
    // @RequestMapping("/upload")
    // public String upload(@RequestParam(value = "username",required = false) String uploadUsername, @RequestParam("headering") MultipartFile file, Model model)
    // {
    //
    //     System.out.println("上传文件的信息");
    //     System.out.println(uploadUsername);
    //     System.out.println("文件项的name" + file.getName());
    //     System.out.println("文件的名字" + file.getOriginalFilename());
    //     //文件保存
    //     try
    //     {
    //         file.transferTo(new File("E:\\movies\\" + file.getOriginalFilename()));
    //         model.addAttribute("msg","文件上传成功");
    //
    //     } catch (IOException e)
    //     {
    //         model.addAttribute("msg","文件上传失败" + e.getMessage());
    //
    //         e.printStackTrace();
    //     }
    //
    //
    //     return "forward:/index.jsp";
    // }


    //测试多文件上传
    @RequestMapping("/upload")
    public String upload(@RequestParam(value = "username",required = false) String uploadUsername, @RequestParam("headering") MultipartFile[] files, Model model)
    {

        System.out.println("上传文件的信息");
        System.out.println("上传文件的用户名" + uploadUsername);
       for (MultipartFile file : files)
       {
           if (!file.isEmpty())
           {
               System.out.println("文件项的name" + file.getName());
               System.out.println("文件的名字" + file.getOriginalFilename());
               try
               {
                   file.transferTo(new File("E:\\movies\\" + file.getOriginalFilename()));
                   model.addAttribute("msg","文件上传成功");

               } catch (IOException e)
               {
                   model.addAttribute("msg","文件上传失败" + e.getMessage());

                   e.printStackTrace();
               }
           }
       }
        //文件保存

        return "forward:/index.jsp";
    }
}

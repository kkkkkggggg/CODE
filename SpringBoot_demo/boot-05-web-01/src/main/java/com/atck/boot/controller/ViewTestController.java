package com.atck.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewTestController
{

    @GetMapping("/atck")
    public String atck(Model model)
    {
        //Model中的数据会被放到请求域中
        model.addAttribute("msg", "你好，哈哈哈");
        model.addAttribute("url", "www.baidu.com");
        return "success";
    }
}

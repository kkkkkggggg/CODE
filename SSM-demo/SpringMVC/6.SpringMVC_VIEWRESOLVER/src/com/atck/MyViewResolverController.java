package com.atck;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义视图解析器和视图对象
 */
@Controller
public class MyViewResolverController
{
    @RequestMapping("/handleplus")
    public String handleplus(Model model)
    {
        List<String> vname = new ArrayList<>();
        List<String> imgname = new ArrayList<>();

        vname.add("是的拉伸空间");
        vname.add("在科学减肥");

        imgname.add("送欸人");
        imgname.add("阿松擦");

        model.addAttribute("video",vname);
        model.addAttribute("imgs",imgname);
        return "meinv:/gaoqing";
    }

}

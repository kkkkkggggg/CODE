package com.atck.controller;

import com.atck.bean.Teacher;
import com.atck.service.TeacherService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TeacherController
{
    @Autowired
    TeacherService teacherService;

    @RequestMapping("/getTeacher")
    public String getTeacher(@RequestParam(value = "id",defaultValue = "1") Integer id, Model model)
    {
        Teacher teacher = teacherService.getTeacherById(id);
        model.addAttribute("teacher",teacher);
        return "success";
    }

    @RequestMapping(value = "/getall")
    public String getAll(@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo,Model model)
    {
        //紧跟查询就是一个分页查询
        PageHelper.startPage(pageNo,5);
        List<Teacher> teachers = teacherService.getAllTeacher();

        //我们可以将查询的结果使用:将查询的结果放在PageInfo中，这个PageInfo就有非常多能用的东西
        //第二个传入连续要显示的页数
        PageInfo<Teacher> pageInfo = new PageInfo<>(teachers,6);

        System.out.println("当前页码"+pageInfo.getPageNum());
        System.out.println("总页码"+pageInfo.getPages());
        System.out.println("总记录数" + pageInfo.getTotal());
        System.out.println("当前页有" + pageInfo.getSize() + "条记录");
        System.out.println("当前页的pageSize" + pageInfo.getPageSize() + "条记录");
        System.out.println("前一页"+pageInfo.getPrePage());
        System.out.println("结果：" + pageInfo.getList());//查询结果
        System.out.println("连续分页"+pageInfo.getNavigatepageNums());

        model.addAttribute("pageInfo",pageInfo);
        return "list";
    }
}

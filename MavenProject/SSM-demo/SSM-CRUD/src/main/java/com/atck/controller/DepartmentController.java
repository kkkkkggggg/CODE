package com.atck.controller;

import com.atck.bean.Department;
import com.atck.bean.Massage;
import com.atck.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DepartmentController
{
    @Autowired
    DepartmentService departmentService;

    @RequestMapping("/depts")
    @ResponseBody
    public Massage getDepts()
    {
        List<Department> depts = departmentService.getDepts();



        return Massage.success().add("depts",depts);
    }

}

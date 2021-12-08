package com.atck.admin.controllor;

import com.atck.admin.bean.User;
import com.atck.admin.service.impl.UserServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TableController
{
    @Autowired
    UserServiceImpl userServiceImpl;

    @GetMapping("/basic_table")
    public String   basic_table()
    {
        return "table/basic_table";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUserById(@PathVariable Integer id, @RequestParam(value = "pn",defaultValue = "1")Integer pn,
                                 RedirectAttributes ra)
    {
        userServiceImpl.removeById(id);

        ra.addAttribute("pn",pn);
        return "redirect:/dynamic_table";
    }


    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model)
    {
        // //表格内容的遍历
        // List<User> users = Arrays.asList(new User("zhangsan", "123456"),
        //         new User("lisi", "aaaaa"),
        //         new User("haha", "123444"),
        //         new User("hehe", "aadddd"));
        //
        // // if (users.size() > 3)
        // // {
        // //     throw new UserTooManyException();
        // // }

        //从数据库中查出user表中的用户进行展示
        List<User> users = userServiceImpl.list();


        model.addAttribute("users",users);

        //分页查询数据
        Page<User> userPage = new Page<>(pn, 2);

        //分页查询结果
        Page<User> page = userServiceImpl.page(userPage,null);

        model.addAttribute("page",page);

        return "table/dynamic_table";
    }

    @GetMapping("/editable_table")
    public String editable_table()
    {
        return "table/editable_table";
    }

    @GetMapping("/pricing_table")
    public String pricing_table()
    {
        return "table/pricing_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table()
    {
        return "table/responsive_table";
    }

}

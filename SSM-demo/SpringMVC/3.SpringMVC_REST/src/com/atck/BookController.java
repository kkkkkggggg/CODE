package com.atck;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController
{
    /**
     * 处理添加图书请求
     * @return
     */
    @RequestMapping(value = "/book",method = RequestMethod.POST)
    public String addBook()
    {
        System.out.println("添加了图书");
        return "success";
    }

    @RequestMapping(value = "/book/{id}",method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable("id") String id)
    {
        System.out.println("删除了" + id + "号图书");
        return "success";
    }

    /**
     * 处理更新图书请求
     * @return
     */
    @RequestMapping(value = "/book/{id}",method = RequestMethod.PUT)
    public String updateBook(@PathVariable("id") String id)
    {
        System.out.println("更新了" + id + "号图书");
        return "success";
    }

    /**
     * 处理查询图书请求
     * @param id
     * @return
     */
    @RequestMapping(value = "/book/{id}",method = RequestMethod.GET)
    public String getBook(@PathVariable("id") String id)
    {
        System.out.println("查询到了" + id + "号图书");
        return "success";
    }
}

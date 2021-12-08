package com.atck.boot.controller;

import com.atck.boot.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RequestController
{
    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request)
    {
        request.setAttribute("msg", "成功了。。。。。");
        request.setAttribute("code", "200");
        return "forward:/success"; //转发到 /success请求
    }

    @GetMapping("/success")
    @ResponseBody
    public Map success(@RequestAttribute(value = "msg", required = false) String msg, @RequestAttribute(value = "code", required = false) String code, HttpServletRequest request)
    {
        Map<String, Object> map = new HashMap<>();
        Object msg1 = request.getAttribute("msg");
        map.put("request_msg1", msg1);
        map.put("@RequestAttribute_code", code);
        map.put("@RequestAttribute_msg", msg);

        Object hello = request.getAttribute("hello");
        Object world = request.getAttribute("world");
        Object message = request.getAttribute("message");

        map.put("hello", hello);
        map.put("world", world);
        map.put("message", message);
        return map;
    }

    @GetMapping("/params")
    public String testParam(Map<String, Object> map, Model model, HttpServletRequest request, HttpServletResponse response)
    {
        map.put("hello", "world666");
        model.addAttribute("world", "hello666");
        request.setAttribute("message", "helloworld");
        response.addCookie(new Cookie("c1", "v1"));
        return "forward:/success";
    }


    /**
     * 数据绑定：页面提交的请求数据（GET，POST）都可以和对象属性进行绑定
     *
     * @param person
     * @return
     */
    @PostMapping(value = "/person")
    @ResponseBody
    public String testPOJO(@ModelAttribute Person person)
    {
        return person.toString();
    }

}

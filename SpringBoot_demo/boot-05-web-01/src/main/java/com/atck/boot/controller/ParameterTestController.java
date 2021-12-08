package com.atck.boot.controller;

import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.boot.autoconfigure.web.reactive.WebFluxProperties;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.Servlet;
import javax.servlet.http.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ParameterTestController
{
    @GetMapping("car/{id}/owner/{userName}")
    @ResponseBody
    public Map<String, Object> getCar(@PathVariable("id") Integer id, @PathVariable("userName") String userName, @PathVariable Map<String, String> pv, @RequestHeader("User-Agent") String userAgent, @RequestHeader Map<String, String> header, @RequestParam("age") Integer age, @RequestParam("inters") String[] interests, @RequestParam Map<String, String> params, @CookieValue("_ga") String _ga, @CookieValue("_ga") Cookie cookie)
    {
        Map<String, Object> map = new HashMap<>();

        map.put("id", id);

        map.put("name", userName);
        map.put("pv", pv);
        map.put("userAgent", userAgent);
        map.put("header", header);
        map.put("age", age);
        map.put("interests", interests);
        map.put("params", params);
        map.put("_ga", _ga);
        map.put("cookie", cookie);
        return map;
    }

    @RequestMapping("/cookie")
    @ResponseBody
    public String cookie(HttpServletResponse response)
    {
        Cookie cookie = new Cookie("_ga", "54654621354768465");
        response.addCookie(cookie);
        return "success";
    }

    @RequestMapping("/save")
    @ResponseBody
    public Map<String, Object> postMethod(@RequestBody String content)
    {
        Map<String, Object> map = new HashMap<>();

        map.put("content", content);

        return map;
    }

    //1.语法： /cars/sell;low=34;brand=byd,audi,yd
    //2.SpringBoot默认禁用矩阵变量
    //        手动开启：原理对于路径的处理，UrlPathHelper进行解析，removeSemicolonContent(移除分号及其之后的内容)支持矩阵变量的
    //3.矩阵变量必须要有url路径变量才能被解析
    @GetMapping("/cars/{path}")
    @ResponseBody
    public Map carsSell(@MatrixVariable("low") Integer low, @MatrixVariable("brand") List<String> brand, @PathVariable("path") String path)
    {
        Map<String, Object> map = new HashMap<>();

        map.put("low", low);
        map.put("brand", brand);
        map.put("path", path);
        return map;
    }

    ///boss/1;age=20/2;age=10
    @GetMapping("/boss/{bossId}/{empId}")
    @ResponseBody
    public Map boss(@PathVariable("bossId") Integer bossId, @MatrixVariable(value = "age", pathVar = "bossId") Integer bossAge, @PathVariable("empId") Integer empId, @MatrixVariable(value = "age", pathVar = "empId") Integer empAge)
    {
        Map<String, Object> map = new HashMap<>();
        map.put("bossId", bossId);
        map.put("bossAge", bossAge);
        map.put("empId", empId);
        map.put("empAge", empAge);

        return map;
    }


}

package com.atck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpSession;
import java.util.Locale;

@Controller
public class I18nTestController
{
    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/toLoginPage")
    public String toLoginPage(@RequestParam(value = "locale",defaultValue = "zh_CN") String localeStr, Locale locale, Model model, HttpSession session)
    {
        System.out.println(locale);
        String welcomeinfo = messageSource.getMessage("welcomeinfo", null, locale);
        System.out.println(welcomeinfo);
        model.addAttribute("msg","哈哈哈");

        // Locale l = null;
        // //如果带了locale就用参数指定的区域信息，没有带就用请求头自带的区域信息
        // if (localeStr != null && localeStr != "")
        // {
        //     l = new Locale(localeStr.split("_")[0],localeStr.split("_")[1]);
        // }else
        // {
        //     l = locale;
        // }
        // session.setAttribute(SessionLocaleResolver.class.getName() + ".LOCALE",l);



        return "login";
    }
}

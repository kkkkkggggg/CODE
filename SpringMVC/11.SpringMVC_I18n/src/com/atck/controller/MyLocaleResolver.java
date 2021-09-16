package com.atck.controller;

import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver
{
    /**
     * 解析返回locale
     * @param request
     * @return
     */
    @Override
    public Locale resolveLocale(HttpServletRequest request)
    {
        Locale l = null;
        String localeStr = request.getParameter("locale");
        //如果带了locale就用参数指定的区域信息，没有带就用请求头自带的区域信息
        if (localeStr != null && localeStr != "")
        {
            l = new Locale(localeStr.split("_")[0],localeStr.split("_")[1]);
        }else
        {
            l = request.getLocale();
        }
        return l;
    }

    /**
     * 修改locale
     * @param request
     * @param response
     * @param locale
     */
    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale)
    {
        throw new UnsupportedOperationException(
                "Cannot change HTTP accept header - use a different locale resolution strategy");
    }
}

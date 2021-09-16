package com.view;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

public class MyBeautyViewResolver implements ViewResolver, Ordered
{
    private int order = Ordered.LOWEST_PRECEDENCE;
    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception
    {
        //根据视图名返回视图对象
        if (viewName.startsWith("meinv:"))
        {
            return new MyView();
        }else
        {
            //不能处理，返回null
            return null;
        }

    }

    @Override
    public int getOrder()
    {
        return order;
    }

    //改变视图解析器的优先级
    public void setOrder(int order)
    {
        this.order = order;
    }
}

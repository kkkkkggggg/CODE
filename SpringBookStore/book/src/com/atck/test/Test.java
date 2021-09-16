package com.atck.test;

import com.atck.service.BookService;
import com.atck.utils.WebUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Test
{


    public void contextInitialized(ServletContextEvent sce)
    {

    }

    @org.junit.Test
    public void contextDestroyed()
    {
        System.out.println(Thread.currentThread().getContextClassLoader());

    }

    @org.junit.Test
    public void test()
    {
        BookService bean = WebUtils.getBean(BookService.class);
        System.out.println(bean);
    }
}

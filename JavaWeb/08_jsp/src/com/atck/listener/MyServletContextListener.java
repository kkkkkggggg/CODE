package com.atck.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.jsp.HttpJspPage;
import javax.servlet.jsp.JspWriter;
import javax.swing.*;

public class MyServletContextListener implements ServletContextListener
{

    @Override
    public void contextInitialized(ServletContextEvent sce)
    {
        System.out.println("ServletContext对象被创建了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce)
    {
        System.out.println("ServletContext对象被销毁了");
    }
}

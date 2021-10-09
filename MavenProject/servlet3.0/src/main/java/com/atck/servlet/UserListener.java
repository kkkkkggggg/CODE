package com.atck.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 监听项目的启动和停止
 */
public class UserListener implements ServletContextListener
{
    /**
     * 监听ServletContext启动，初始化
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent)
    {
        System.out.println("UserListener....contextInitialized.....");

        ServletContext servletContext = servletContextEvent.getServletContext();
    }

    /**
     * 监听ServletContext销毁
     * @param servletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent)
    {
        System.out.println("UserListener....contextDestroyed....");
    }
}

package com.atck.admin.servlet;

import com.atck.admin.config.AdminWebConfig;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.Arrays;

/**
 * 1.MyServlet ------> /my
 * 2.DispatcherServlet ------> /
 */
@Configuration(proxyBeanMethods = true)//保证以来的bean始终是单实例的
public class MyRegistConfig
{
    @Bean
    public ServletRegistrationBean myServlet()
    {
        MyServlet myServlet = new MyServlet();


        return new ServletRegistrationBean(myServlet,"/my");
    }

    @Bean
    public FilterRegistrationBean myFilter()
    {
        MyFilter myFilter = new MyFilter();

        // return new FilterRegistrationBean(myFilter,myServlet());
        FilterRegistrationBean<MyFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>(myFilter);

        filterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/my","/css/*"));
        return filterFilterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener()
    {
        MyServletContextListener listener = new MyServletContextListener();

        return new ServletListenerRegistrationBean(listener);
    }


}

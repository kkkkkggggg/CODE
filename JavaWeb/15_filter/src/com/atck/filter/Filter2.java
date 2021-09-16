package com.atck.filter;

import javax.servlet.*;
import java.io.IOException;

public class Filter2 implements Filter
{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        System.out.println("Filter2前置代码1");
        System.out.println("Filter2线程" + Thread.currentThread().getName());
        System.out.println("Filter2 " + request.getParameter("username"));

        chain.doFilter(request,response);
        System.out.println("Filter2后置代码2");
    }

    @Override
    public void destroy()
    {

    }
}

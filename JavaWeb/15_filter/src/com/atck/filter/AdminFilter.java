package com.atck.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminFilter implements Filter
{
    public AdminFilter()
    {
        System.out.println("1.filter构造器方法AdminFilter");
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        System.out.println("2.filter的init(FilterConfig filterConfig)初始化方法");
        // 1、获取 Filter 的名称 filter-name 的内容
        System.out.println("filter-name的值是" + filterConfig.getFilterName());
        // 2、获取在 Filter 中配置的 init-param 初始化参数
        System.out.println("filter中配置的参数user的值是" + filterConfig.getInitParameter("user"));
        // 3、获取 ServletContext 对象
        System.out.println("ServletContext对象：" + filterConfig.getServletContext());
    }

    /**
     * doFilter方法，专门用于拦截请求，权限检查
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        System.out.println("3.filter的doFilter方法");
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpSession session = servletRequest.getSession();
        Object user = session.getAttribute("user");
        //如果等于null说明还没有登录
        if (user == null)
        {
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }else
        {
            //让程序继续往下访问用户的目标资源
            chain.doFilter(request,response);
        }
    }

    @Override
    public void destroy()
    {
        System.out.println("4.filter的destroy方法");
    }
}

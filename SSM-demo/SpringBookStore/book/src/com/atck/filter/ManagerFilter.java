package com.atck.filter;

import com.atck.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ManagerFilter implements Filter
{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest servletRequest = (HttpServletRequest) request;

        User user = (User) servletRequest.getSession().getAttribute("user");

        if (user == null)
        {
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
            return;
        }else
        {
            chain.doFilter(request,response);
        }
    }

    @Override
    public void destroy()
    {

    }
}

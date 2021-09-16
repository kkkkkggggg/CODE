package com.atck.filter;

import com.atck.utils.JDBCUtils;

import javax.servlet.*;
import java.io.IOException;

public class TransactionFilter implements Filter
{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {


        try
        {
            chain.doFilter(request,response);

            JDBCUtils.commitAndClose();//提交事务
        } catch (Exception e)
        {

            JDBCUtils.rollbackAndClose();//回滚事务
            e.printStackTrace();
            throw new RuntimeException(e);//把异常抛给tomcat统一进行友好的错误展示
        }
    }

    @Override
    public void destroy()
    {

    }
}

package com.atck.admin.intercepetor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
登录检查
1.配置好拦截器要拦截哪些请求
2.把这些配置放到拦截器中
 */
// @Log4j2
@Slf4j
public class LoginIntercepetor implements HandlerInterceptor
{

    public LoginIntercepetor()
    {
    }

    /**
     * 目标方法执行之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        //登录检查逻辑
        HttpSession session = request.getSession();
        String requestURI = request.getRequestURI();

        log.info("preHandle拦截的路径:" + requestURI);

        Object loginUser = session.getAttribute("loginUser");

        if (null != loginUser)
        {
            return true;
        }

        //拦截住，未登录，跳转到登录页
        // response.sendRedirect("/");
        request.setAttribute("msg","请先登录");
        request.getRequestDispatcher("/").forward(request,response);
        return false;
    }

    /**
     * 目标方法执行完成之后
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    {
        log.info("当前执行的方法是:postHandle",modelAndView);
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception
    {
        log.info("当前执行的方法是:afterCompletion",ex);
    }
}

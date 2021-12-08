package com.atck.admin.exception;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(value = 0)
public class CustomerHandlerExceptionResolver implements HandlerExceptionResolver
{
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
    {

        try
        {
            response.sendError(511,"我喜欢的错误");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return new ModelAndView();
    }
}

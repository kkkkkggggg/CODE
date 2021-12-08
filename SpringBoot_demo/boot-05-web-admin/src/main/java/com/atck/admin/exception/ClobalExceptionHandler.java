package com.atck.admin.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 处理整个Web Controller的异常
 */
@Slf4j
@ControllerAdvice
public class ClobalExceptionHandler
{
    @ExceptionHandler({ArithmeticException.class,NullPointerException.class})       //处理异常
    public String handlerArithException(Exception e)
    {
        log.error("异常是:{" + e + "}");
        return "login"; //视图地址
    }
}

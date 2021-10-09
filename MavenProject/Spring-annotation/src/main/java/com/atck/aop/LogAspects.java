package com.atck.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.util.StringValueResolver;

import javax.swing.*;
import java.util.Arrays;

/**
 * 切面类
 * @Aspect 告诉spring这是一个切面类
 */
@Aspect
public class LogAspects
{
    //抽取公共的切入点表达式
    //1.本类引用
    //
    @Pointcut("execution(public int com.atck.aop.MathCalculator.div(..))")
    public void pointCut()
    {

    }

    //@Before在目标方法之前切入，切入点表达式（指定在哪个方法切入）
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint)
    {
        System.out.println(joinPoint.getSignature().getName() + "运行了@Before，参数列表是{" + Arrays.asList(joinPoint.getArgs()) + "}");
    }

    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint)
    {
        System.out.println(joinPoint.getSignature().getName() + "结束@After");
    }

    //JoinPoint一定要出现在参数列表的第一个
    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result)
    {

        System.out.println(joinPoint.getSignature().getName() + "正常返回@AfterReturning....运行结果。。。。:{"+ result +"}");
    }

    @AfterThrowing(value = "pointCut()",throwing = "e")
    public void logException(JoinPoint joinPoint,Exception e)
    {
        System.out.println(joinPoint.getSignature().getName() + "异常。。。异常信息@AfterThrowing：{"+ e +"}");
    }

}

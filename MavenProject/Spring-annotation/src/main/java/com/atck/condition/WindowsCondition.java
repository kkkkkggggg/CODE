package com.atck.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 判断是否是windows系统
 */
public class WindowsCondition implements Condition
{
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata)
    {
        Environment environment = context.getEnvironment();
        if (environment.getProperty("os.name").contains("Windows"))
        {
            return true;
        }
        return false;
    }
}

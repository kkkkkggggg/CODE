package com.atck.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 判断是否是linux系统
 */
public class LinuxCondition implements Condition
{
    /**
     *
     * @param context  判断条件能使用的上下文环境
     * @param metadata  当前注解的参数信息
     * @return
     */
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata)
    {
        //1.能获取到ioc使用的beanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //2.获取类的加载器
        ClassLoader classLoader = context.getClassLoader();
        //3.获取当前环境信息
        Environment environment = context.getEnvironment();
        //4.获取bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();

        //可以判断容器中是否有某一个注册的bean,也可以给容器中注册bean
        boolean definition = registry.containsBeanDefinition("person");

        //是否是linux系统
        if (environment.getProperty("os.name").contains("Linux"))
        {
            return true;
        }
        return false;
    }
}

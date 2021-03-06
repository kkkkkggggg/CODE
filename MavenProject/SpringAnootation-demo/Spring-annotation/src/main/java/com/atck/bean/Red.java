package com.atck.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

@Component
public class Red implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware
{

    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {
        this.applicationContext = applicationContext;
        System.out.println("传入的ioc：" + applicationContext);
    }

    public void setBeanName(String name)
    {
        System.out.println("当前Bean的名字" + name);
    }


    public void setEmbeddedValueResolver(StringValueResolver resolver)
    {
        String s = resolver.resolveStringValue("你好${os.name},我是#{20*8}");

        System.out.println("解析的字符串："  + s);
    }
}

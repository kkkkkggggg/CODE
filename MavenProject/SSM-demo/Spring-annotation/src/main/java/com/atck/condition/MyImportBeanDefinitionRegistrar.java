package com.atck.condition;

import com.atck.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar
{
    /**
     *
     * @param importingClassMetadata 当前类的注释信息
     * @param registry  BeanDefinition注册类
     *                     把所有需要添加到容器中的bean：
     *                     调用
     *                     BeanDefinitionRegistry.registerBeanDefinitions手动注册进来
     */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry)
    {
        boolean red = registry.containsBeanDefinition("com.atck.bean.Red");
        boolean blue = registry.containsBeanDefinition("com.atck.bean.Blue");
        if (red && blue)
        {
            /**
             * 指定Bean定义信息（bean的类型，bean的scope）
             */
            RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
            /**
             * 注册一个Bean，指定bean名
             */
            registry.registerBeanDefinition("rainBow",beanDefinition);
        }
    }
}

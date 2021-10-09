package com.atck.ext;

import com.atck.bean.Blue;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;
import org.springframework.stereotype.Component;

@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor
{

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException
    {
        System.out.println("MyBeanDefinitionRegistryPostProcessor...bean的数量" + beanFactory.getBeanDefinitionCount());
    }

    //BeanDefinitionRegistry bean定义信息的保存中心，以后BeanFactory就是按照BeanDefinitionRegistry里面保存的每一个备案定义信息创建备案实例
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException
    {
        System.out.println("MyBeanDefinitionRegistryPostProcessor...bean的数量" + registry.getBeanDefinitionCount());
        // RootBeanDefinition definition = new RootBeanDefinition(Blue.class); 或者用
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Blue.class).getBeanDefinition();

        registry.registerBeanDefinition("hello",beanDefinition);
    }
}

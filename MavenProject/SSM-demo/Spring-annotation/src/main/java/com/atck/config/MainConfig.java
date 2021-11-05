package com.atck.config;

import com.atck.bean.Person;
import com.atck.service.BookService;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

//配置类等同于以前的配置文件
@Configuration//告诉Spring这是一个配置类
@ComponentScan(value = "com.atck",useDefaultFilters = false,includeFilters =
            {
                    // @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class}),
                    // @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookService.class}),
                    @ComponentScan.Filter(type = FilterType.CUSTOM,classes = MyTypeFilter.class)
            })
//包扫描，value指定要扫描的包
//excludeFilters = Filter[] :指定扫描的时候按照哪些规则排除哪些组件
//includeFilters = Filter[] :指定扫描的时候按照哪些规则保留哪些组件
//FilterType.ANNOTATION  :按照注解的方式指定要扫描或派出的组件
//FilterType.ASSIGNABLE_TYPE  :按照给定的类型
//FilterType.ASPECTJ     :使用ASPECTJ表达式
//FilterType.REGEX       :使用正则表达式
//FilterType.CUSTOM      :使用自定义规则

// @ComponentScans(value =  //@ComponentScans声明多个@ComponentScan
//         {
//                 @ComponentScan(value = "com.atck",useDefaultFilters = false,includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class, Service.class})})
//
//         }
// )
public class MainConfig
{
    //给容器中注册一个bean，类型为返回值的类型，id默认使用方法名作为id
    @Bean("person")
    public Person person01()
    {
        return new Person("李四",20);
    }
}

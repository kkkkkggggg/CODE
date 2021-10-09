package com.atck.config;

import com.atck.controller.MyFirstInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.*;

//SpringMVC子容器只扫描带有Controller注解的组件
//useDefaultFilters = false,禁用默认的过滤规则
@EnableWebMvc
@ComponentScan(value = "com.atck",includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})},
        useDefaultFilters = false
        )
public class WebConfig implements WebMvcConfigurer
{
        //定制
        //定制视图解析器
        @Override
        public void configureViewResolvers(ViewResolverRegistry registry)
        {
                //默认所有的页面都从WEB-INF/xxx.jsp
                //registry.jsp()
                registry.jsp("/WEB-INF/views/",".jsp");
        }

        //静态资源访问
        @Override
        public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
        {
                configurer.enable();
        }

        //拦截器
        @Override
        public void addInterceptors(InterceptorRegistry registry)
        {
                registry.addInterceptor(new MyFirstInterceptor()).addPathPatterns("/**");
        }
}

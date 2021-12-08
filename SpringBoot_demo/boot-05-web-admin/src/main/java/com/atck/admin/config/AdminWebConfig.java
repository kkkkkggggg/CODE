package com.atck.admin.config;

import com.atck.admin.intercepetor.LoginIntercepetor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 1.编写一个拦截器实现HandlerInterceptor接口
 * 2.拦截器注册到容器中（实现WebMvcConfigurer的addInterceptor）
 * 3.指定拦截规则【如果是拦截所有，静态资源也会被拦截】
 *
 * @EnableWebMvc：全面接管,需要自己重新配置众多底层规则
 *      1.静态资源？视图解析器？欢迎页？。。。。全部失效
 */
// @EnableWebMvc
@Configuration
public class AdminWebConfig implements WebMvcConfigurer
{
    /**
     * Filter 、 Interceptor 几乎拥有相同的功能
     * 1.Filter是Servlett定义的原生组件，好处，脱离Spring应用也能使用
     * 2.Interceptor是Spring定义的，可以使用Spring的自动装配等功能
     */
    // @Autowired
    // RedisUrlCountInterceptor redisUrlCountInterceptor;

    // @Override
    // public void addResourceHandlers(ResourceHandlerRegistry registry)
    // {
    //     /**
    //      * 访问 /aa/** 所有请求都去 classpath:/static/ 下面进行匹配
    //      */
    //
    //     registry.addResourceHandler("/aa/**")
    //             .addResourceLocations("classpath:/static/");
    // }

    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
            registry.addInterceptor(new LoginIntercepetor())
            .addPathPatterns("/**")// /**所有请求都被拦截，包括静态资源
            .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**","/aa/**");//放行的请求

        // registry.addInterceptor(redisUrlCountInterceptor).addPathPatterns("/**").excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**","/aa/**");
    }

    // @Bean
    // public WebMvcRegistrations webMvcRegistrations()
    // {
    //     return new WebMvcRegistrations()
    //     {
    //         @Override
    //         public RequestMappingHandlerMapping getRequestMappingHandlerMapping()
    //         {
    //             return null;
    //         }
    //     };
    // }

}

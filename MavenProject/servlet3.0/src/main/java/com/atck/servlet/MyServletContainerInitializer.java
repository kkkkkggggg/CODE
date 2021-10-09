package com.atck.servlet;

import com.atck.Service.HelloService;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.util.EnumSet;
import java.util.Set;
//容器启动的时候会将@HandlesTypes指定的这个类型下面的子类(实现类、子接口等)传递过来

//传入感兴趣的类型
@HandlesTypes(value = {HelloService.class})
public class MyServletContainerInitializer implements ServletContainerInitializer
{
    /**
     * 应用启动的时候，会运行onStartUp方法
     *
     * 1.使用ServletContext注册Web组件（Servlet，Filter,Listener）
     * 2.使用编码的方式，在项目启动的时候给ServletContext里面添加组件
     *      必须在项目启动的时候添加
     *          1.ServletContainerInitializer得到的ServletContext
     *          2.ServletContextListener得到的ServletContext
     * @param set  @HandlesTypes指定的类型的所有子类型
     * @param servletContext  ServletContext表示当前引用的ServletContext。一个Web应用一个ServletContext
     * @throws ServletException
     */
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException
    {
        System.out.println("感兴趣的类型。。。。");
        set.forEach(System.out::println);

        //注册组件
        ServletRegistration.Dynamic userServlet = servletContext.addServlet("userServlet", new UserServlet());
        //配置Servlet的映射信息
        userServlet.addMapping("/user");

        //注册Listener
        servletContext.addListener(UserListener.class);

        //注册Filter
        FilterRegistration.Dynamic userFilter = servletContext.addFilter("userFilter", UserFilter.class);
        userFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST),true,"/*");

    }
}

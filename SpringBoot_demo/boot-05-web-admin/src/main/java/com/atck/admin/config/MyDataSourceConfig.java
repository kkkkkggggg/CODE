package com.atck.admin.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.support.spring.stat.BeanTypeAutoProxyCreator;
import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;
import com.atck.admin.controllor.IndexController;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

// @Configuration
public class MyDataSourceConfig
{
    //默认的自动配置是判断容器中没有才会配@ConditionalOnMissingBean(DataSource.class)
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() throws SQLException
    {
        DruidDataSource druidDataSource = new DruidDataSource();


        // druidDataSource.setFilters("stat"); //在配置类中设置监控功能
        // druidDataSource.setFilters("wall");//在配置类中设置防火墙功能
        return druidDataSource;
    }

    /**
     * 配置Druid的监控页功能
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet()
    {
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<Servlet> servletRegistrationBean = new ServletRegistrationBean<>(statViewServlet,"/druid/*");
        servletRegistrationBean.addInitParameter("loginUsername","admin");
        servletRegistrationBean.addInitParameter("loginPassword","123456");

        return servletRegistrationBean;
    }

    /**
     * WebStatFilter用于采集web-jdbc关联监控的数据
     */
    @Bean
    public FilterRegistrationBean webStatFilter()
    {
        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>(webStatFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        filterRegistrationBean.addInitParameter("sessionStatEnable","true");//开启web session 监控
        return filterRegistrationBean;
    }

    @Bean
    public DruidStatInterceptor druidStatInterceptor()
    {
        return new DruidStatInterceptor();
    }

    /**
     * 开启spring监控功能
     * @return
     */
    @Bean
    public BeanTypeAutoProxyCreator beanTypeAutoProxyCreator()
    {
        BeanTypeAutoProxyCreator beanTypeAutoProxyCreator = new BeanTypeAutoProxyCreator();

        beanTypeAutoProxyCreator.setInterceptorNames("druidStatInterceptor");

        beanTypeAutoProxyCreator.setTargetBeanType(IndexController.class);
        return beanTypeAutoProxyCreator;
    }


}

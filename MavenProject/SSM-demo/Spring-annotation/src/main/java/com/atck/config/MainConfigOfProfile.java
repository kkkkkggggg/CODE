package com.atck.config;

import com.atck.bean.Yellow;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.Driver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Profile
 *      Spring为我们提供的可以根据当前环境，动态的激活和切换一系列组件的功能
 *
 * 开发环境、测试环境、生产环境
 * 数据源：(/A)(/B)(/C)
 * @Profile:指定组件在那个环境的情况下才能被注册到容器中，不指定，任何情况下都能指定
 * 1.加了环境标识的bean，只有这个环境被激活时才会被注册到容器中，默认是defaul环境
 * 2.写在配置类上，只有是指定的环境的时候，整个配置类里面的所有配置才会生效
 * 3.没有标注环境标识的bean，任何环境下都是加载的
 */
// @Profile("test")
@PropertySource("classpath:/dbconfig.properties")
@Configuration
public class MainConfigOfProfile implements EmbeddedValueResolverAware
{
    @Value("${db.user}")
    private String user;

    private StringValueResolver valueResolver;

    private String driverClass;

    @Bean
    public Yellow yellow()
    {
        return new Yellow();
    }

    @Profile("test")
    @Bean("testDataSource")
    public DataSource dataSourceTest(@Value("${db.password}") String pwd) throws PropertyVetoException
    {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        dataSource.setUser(user);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");

        dataSource.setDriverClass(driverClass);
        dataSource.setPassword(pwd);

        return dataSource;
    }

    @Profile("dev")
    @Bean("devDataSource")
    public DataSource dataSourceDev(@Value("${db.password}") String pwd) throws PropertyVetoException
    {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        dataSource.setUser("root");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mp");
        dataSource.setDriverClass(driverClass);
        dataSource.setPassword(pwd);

        return dataSource;
    }

    @Profile("prod")
    @Bean("prodDataSource")
    public DataSource dataSourceProd(@Value("${db.password}") String pwd) throws PropertyVetoException
    {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        dataSource.setUser("root");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/ssm_crud");
        dataSource.setDriverClass(driverClass);
        dataSource.setPassword(pwd);

        return dataSource;
    }


    public void setEmbeddedValueResolver(StringValueResolver resolver)
    {
        this.valueResolver = resolver;
        this.driverClass = valueResolver.resolveStringValue("${db.driverClass}");
    }
}

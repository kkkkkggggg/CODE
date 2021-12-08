package com.atck.boot.config;

import ch.qos.logback.core.db.DBHelper;
import com.atck.boot.bean.Car;
import com.atck.boot.bean.Pet;
import com.atck.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * 1.配置类里面使用@Bean标注在方法上给容器中注册组件，默认也是单实例的
 * 2.配置类本身也是组件
 * 3.proxyBeanMethods：代理bean的方法
 *      full（proxyBeanMethods = true），lite（proxyBeanMethods = false）
 * 4.@Import({User.class, DBHelper.class})，给容器中自动创建这两个组件
 *
 * 5.@ImportResource("classpath:beans.xml")导入spring的配置文件
 */
@Import({User.class, DBHelper.class})//默认组件的名字是全类名
@Configuration(proxyBeanMethods = true)//告诉Springboot这是一个配置类 == 配置文件
@ImportResource("classpath:beans.xml")
@EnableConfigurationProperties(Car.class)
//1.开启car的属性配置功能
//2.把这个car组件，自动注册到容器
public class MyConfig
{
    /**
     * 外部无论对配置类中的组件注册方法调用多少次，获取的都是之前注册容器中的单实例对象
     * @return
     */
    @ConditionalOnBean(name = "tomcatPet")//当容器中有tomcatPet名字的组件时，再给容器中注册user01
    @Bean //给容器中添加组件，以方法名作为组件的id，返回值类型是组件的类型，返回的值就是组件在容器中的实例
    public User user01()
    {
        User user = new User("zhangsan",21);

        //user组件依赖了pet组件
        user.setPet(tomcatPet());
        return user;
    }

    // @Bean
    public Pet tomcatPet()
    {
        return new Pet("tomcat");
    }
}

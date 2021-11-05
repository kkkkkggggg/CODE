package com.atck.config;

import com.atck.bean.Color;
import com.atck.bean.ColorFactory;
import com.atck.bean.Person;
import com.atck.bean.Red;
import com.atck.condition.LinuxCondition;
import com.atck.condition.MyImportBeanDefinitionRegistrar;
import com.atck.condition.MyImportSelector;
import com.atck.condition.WindowsCondition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

@Conditional({WindowsCondition.class})
@Configuration
@Import(value = {Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MainConfig2
{

    /**
     * 默认是单实例的
     * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE  多实例:ioc容器并不会调用方法创建对象放在容器中
                                                           每次获取的时候才会
     // * @see ConfigurableBeanFactory#SCOPE_SINGLETON  单实例(默认值)：ioc容器启动时会调用方法，创建对象，放到ioc容器中
                                                     以后每次获取都是直接从容器（map.get()）中拿
     // * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST  同一个请求创建一个实例
     // * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION  同一个session创建一个实例
     * @return
       @Scope调整作用域

        懒加载
            单实例bean：默认在容器启动的时候创建对象；
            懒加载：容器启动不创建对象，第一次获取bean的时候创建对象并初始化
     */
    @Bean("person")
    // @Scope(value = "prototype")
    @Lazy
    public Person person()
    {
        System.out.println("给容器中添加person。。。。");
        return new Person("王五",20);
    }

    /**
     *     @Conditional :按照一定的条件进行判断，满足条件给容器中注册bean
     *     如果系统是windows，给容器中注册(bill)
     *     如果是linux，给容器中注入(linus)
     */
    @Conditional(value = {WindowsCondition.class})
    @Bean("bill")
    public Person person01()
    {
        return new Person("bill",62);
    }

    @Conditional(value = {LinuxCondition.class})
    @Bean("linus")
    public Person person02()
    {
        return new Person("linux",48);
    }

    /**
     * 给容器中注册组件的方式
     * 1.包扫描+组件标注解(@Controller、@Service、@Repository、@Component)【自己写的类】
     * 2。@Bean(导入第三方包里面的组件)
     * 3.@Import【快速给容器中导入一个组件】
     *          1、@Import(要导入容器中的组件)，容器中就会自动注册这个组件，id默认是全类名
     *          2、ImportSelector:返回需要导入的组件的全类名的数组
     *          3、ImportBeanDefinitionRegistrar
     * 4.使用Spring提供的FactoryBean（工厂bean）
     *          1、默认获取到的是工厂bean调用getObject创建的对象
     *          2、要获取工厂bean本身，我们需要给id前面加一个&
     *                  &colorFactory
     */

    @Bean
    public ColorFactory colorFactory()
    {
        return new ColorFactory();
    }
}

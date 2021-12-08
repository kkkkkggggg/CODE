package com.atck.config;

import com.atck.bean.Car;
import com.atck.bean.Color;
import com.atck.dao.BookDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 自动装配
 *      Spring利用依赖注入（DI），完成对IOC容器中各个组件的依赖冠以赋值
 *
 * 1.@Autowired:自动注入
 *      1.默认优先按照类型去容器中找对应的组件context.getBean(BookDAO.class);
 *      2.如果找到多个相同类型的组件，再将属性名称作为组件的id去容器中查找
 *                                  context.getBean("bookDAO);
 *      3.@Qualifier("bookDAO")，使用@Qualifier指定需要装配的组件的id，而不是使用属性名
 *      4.默认一定要将属性赋值好，没有在容器中找到组件就会报错
 *      5.@Primary:让Spring进行自动装配的时候，默认使用首选的bean
 *
 *          BookService{
 *              @Autowired
 *              BookDAO bookDAO;
 *          }
 * 2.Spring还支持@Resource（JSR250）和@Inject（JSR330）【java规范的注释】
 *      @Resource
 *              可以和@AutoWired一样实现自动装配功能，默认是按照主键名称进行装配的
 *              不支持@Primary和@AutoWired(required = false)
 *      @Inject
 *              需要导入javax.inject的包，和AutoWired的功能一样，没有required = false
 * @AutoWired ：Spring定义的，@Resource、@Inject都是java规范
 *
 * AutoWiredAnnotationBeanProcessor：解析完成自动装配功能
 *
 * 3.@AutoWired：构造器、参数、属性、方法，都是从容器中获取参数组建的值
 *      1.标注在方法位置：@Bean+方法参数，参数从容器中获取，默认不写@AutoWired，效果是一样的都能自动装配
 *      2.标在构造器上：如果组件只有一个有参构造器，这个有参构造器的@Autowired可以省略，参数位置的组件还是可以自动从容器中获取
 *      3.放在参数位置：
 * 4.自定义组件想要使用Spring容器底层的一些组件（ApplicationContext，BeanFactory）
 *          自定义组件实现xxxAware：在创建对象的时候，会调用接口规定的方法注入相关组件：Aware
 *          把Spring底层一些组件注入到自定义的Bean中
 *          xxxAware：功能使用xxxProcessor
 *                  ApplicationContextAware ====》  ApplicationContextAwareProcessor
 */
@Configuration
@ComponentScan({"com.atck.service","com.atck.dao","com.atck.controller","com.atck.bean"})
public class MainConfigOfAutowired
{
    @Primary
    @Bean("bookDAO2")
    public BookDAO bookDAO()
    {
        BookDAO bookDAO = new BookDAO();
        bookDAO.setLable("2");
        return bookDAO;
    }

    /**
     * @Bean标注的方法创建对象的时候，方法参数值从容器中获取
     * @param car
     * @return
     */
    @Bean
    public Color color(Car car)
    {
        Color color = new Color();
        color.setCar(car);
        return color;
    }
}

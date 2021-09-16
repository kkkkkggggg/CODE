package com.atck.spring.service;

import com.atck.spring.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Proxy;

//在注解里value属性值可以省略不写
//默认值是类名称，首字母小写
// @Component(value = "userService")//<bean id="userService" class"..."/>
@Service
public class UserService
{
    //定义dao类型属性
    //不需要添加set方法
    //添加注入属性注解

    // @Autowired//根据类型进行注入
    // @Qualifier(value = "userDAOImpl1")//根据名称进行注入

    // @Resource//根据类型进行注入

    @Resource(name = "userDAOImpl1")
    private UserDAO userDAO;

    @Value(value = "abc")
    private String name;

    public void add()
    {
        userDAO.add();
        System.out.println(name); 
        System.out.println("service add........");

    }
}

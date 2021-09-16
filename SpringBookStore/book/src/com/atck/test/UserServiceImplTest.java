package com.atck.test;

import com.atck.pojo.User;
import com.atck.service.UserService;
import com.atck.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UserServiceImplTest
{
    ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

    @Test
    public void registUser()
    {
        UserService userService = context.getBean(UserService.class);
        userService.registUser(new User(null,"asd168","666666","bbj168@qq.com"));
        userService.registUser(new User(null,"zxc168","666666","abc168@qq.com"));
    }

    @Test
    public void login()
    {
        UserService userService = context.getBean(UserService.class);

        User user = userService.login(new User(null, "bbj168", "666666", null));
        System.out.println(user);
    }

    @Test
    public void existsUsername()
    {
        UserService userService = context.getBean(UserService.class);

        System.out.println(userService.existsUsername("bbj168"));
    }


}
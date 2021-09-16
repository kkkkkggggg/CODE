package com.atck.test;

import com.atck.pojo.User;
import com.atck.service.UserService;
import com.atck.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplTest
{
    UserService userService = new UserServiceImpl();

    @Test
    public void registUser()
    {
        userService.registUser(new User(null,"bbj168","666666","bbj168@qq.com"));
        userService.registUser(new User(null,"abc168","666666","abc168@qq.com"));
    }

    @Test
    public void login()
    {
        User user = userService.login(new User(null, "bj168", "666666", null));
        System.out.println(user);
    }

    @Test
    public void existsUsername()
    {
        System.out.println(userService.existsUsername("bbj168"));
    }
}
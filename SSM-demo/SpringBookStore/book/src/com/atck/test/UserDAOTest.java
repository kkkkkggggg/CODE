package com.atck.test;

import com.atck.dao.UserDAO;
import com.atck.dao.impl.UserDAOImpl;
import com.atck.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UserDAOTest
{
    ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
    @Test
    public void queryUserByUsername()
    {
        UserDAO userDAO = context.getBean(UserDAO.class);

        System.out.println(userDAO.queryUserByUsername("abc"));
    }

    @Test
    public void queryUserByUsernameAndPassword()
    {
        UserDAO userDAO = context.getBean(UserDAO.class);

        System.out.println(userDAO.queryUserByUsernameAndPassword("abc","abc"));
    }

    @Test
    public void saveUser()
    {
        UserDAO userDAO = context.getBean(UserDAO.class);

        int i = userDAO.saveUser(new User(null, "haha", "1232213", "ck@123"));
        System.out.println(i);

    }
}
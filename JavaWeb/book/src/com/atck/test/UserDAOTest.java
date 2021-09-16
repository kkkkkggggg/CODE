package com.atck.test;

import com.atck.dao.UserDAO;
import com.atck.dao.impl.UserDAOImpl;
import com.atck.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDAOTest
{

    @Test
    public void queryUserByUsername()
    {
        UserDAO userDAO = new UserDAOImpl();
        System.out.println(userDAO.queryUserByUsername("abc"));
    }

    @Test
    public void queryUserByUsernameAndPassword()
    {
        UserDAO userDAO = new UserDAOImpl();
        System.out.println(userDAO.queryUserByUsernameAndPassword("abc","abc"));
    }

    @Test
    public void saveUser()
    {
        UserDAO userDAO = new UserDAOImpl();
        int i = userDAO.saveUser(new User(null, "ck", "1232213", "ck@123"));
        System.out.println(i);

    }
}
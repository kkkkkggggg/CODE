package com.atck.spring.service;

import com.atck.spring.dao.UserDAO;
import com.atck.spring.dao.UserDAOImpl;

public class UserService
{


    //创建UserDAO类型属性，生成set方法
    private UserDAO userDAO;

    public void add()
    {
        System.out.println("Service Add..............");
        userDAO.update();

    }

    public void setUserDAO(UserDAO userDAO)
    {
        this.userDAO = userDAO;
    }
}

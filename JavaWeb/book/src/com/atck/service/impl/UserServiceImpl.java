package com.atck.service.impl;

import com.atck.dao.UserDAO;
import com.atck.dao.impl.UserDAOImpl;
import com.atck.pojo.User;
import com.atck.service.UserService;

public class UserServiceImpl implements UserService
{
    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public void registUser(User user)
    {

        userDAO.saveUser(user);

    }

    @Override
    public User login(User user)
    {
        return userDAO.queryUserByUsernameAndPassword(user.getPassword(),user.getUsername());
    }

    @Override
    public boolean existsUsername(String username)
    {
        if (userDAO.queryUserByUsername(username) == null)
        {
            return false;
        }

        return true;
    }
}

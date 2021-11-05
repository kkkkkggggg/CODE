package com.atck.spring.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository(value = "userDAOImpl1")
public class UserDAOImpl implements UserDAO
{
    @Override
    public void add()
    {
        System.out.println("UserDAOImpl add........");
    }
}

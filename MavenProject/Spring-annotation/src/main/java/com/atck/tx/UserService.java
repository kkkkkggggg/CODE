package com.atck.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService
{
    @Autowired
    UserDAO userDAO;



    @Transactional
    public void insertUser()
    {
        userDAO.insert();
        //otherDAO.other();xxxx
        System.out.println("插入完成");
        int i = 1 / 0;
    }
}

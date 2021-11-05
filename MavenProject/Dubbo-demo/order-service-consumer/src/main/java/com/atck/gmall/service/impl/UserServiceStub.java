package com.atck.gmall.service.impl;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.atck.gmall.bean.UserAddress;
import com.atck.gmall.service.UserService;


import java.util.List;

public class UserServiceStub implements UserService
{
    private final UserService userService;

    /**
     * 传入的是userService的远程代理对象
     * @param userService
     */
    public UserServiceStub(UserService userService)
    {
        this.userService = userService;
    }


    public List<UserAddress> getUserAddressList(String userId)
    {
        System.out.println("UserServiceStub.......");
        if (!StringUtils.isEmpty(userId))
        {
            return userService.getUserAddressList(userId);
        }
        return null;
    }
}

package com.atck.gmall.service;

import com.atck.gmall.bean.UserAddress;

import java.util.List;

public interface OrderService
{
    public List<UserAddress> initOrder(String userId);
}

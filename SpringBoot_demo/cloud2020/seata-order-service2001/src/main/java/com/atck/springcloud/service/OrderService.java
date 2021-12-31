package com.atck.springcloud.service;

import com.atck.springcloud.domain.Order;

public interface OrderService
{
    /**
     * 创建订单
     */
    void create(Order order);
}

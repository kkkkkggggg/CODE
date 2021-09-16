package com.atck.dao;

import com.atck.pojo.Order;

import java.util.List;

public interface OrderDAO
{
    /**
     * 保存订单
     * @param order
     */
    public int saveOrder(Order order);

    /**
     * 查询全部订单
     * @return
     */
    public List<Order> queryOrders();

    /**
     * 修改订单状态
     * @param orderId
     * @param status
     */
    public int changeOrderStatus(String orderId,Integer status);

    /**
     * 根据用户id查询订单信息
     * @param userId
     * @return
     */
    public List<Order> queryOrderByUserId(Integer userId);
}

package com.atck.service;

import com.atck.pojo.Cart;
import com.atck.pojo.Order;
import com.atck.pojo.OrderItem;

import java.util.List;

public interface OrderService
{
    /**
     * 创建订单
     * @param cart
     * @param userId
     * @return
     */
    public String createOrder(Cart cart, Integer userId);

    /**
     * 查询全部订单
     * @return
     */
    public List<Order> showAllOrders();

    /**
     * 发货
     * @param orderId
     * @return
     */
    public int sendOrder(String orderId);

    /**
     * 根据订单号查看订单详情
     * @param orderId
     * @return
     */
    public List<OrderItem> showOrderDetail(String orderId);

    /**
     * 根据用户id查询用户的订单
     * @param userId
     * @return
     */
    public List<Order> showMyOrders(Integer userId);

    /**
     * 签收订单
     * @param orderId
     * @return
     */
    public int receiveOrder(String orderId);
}

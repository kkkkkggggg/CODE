package com.atck.dao;

import com.atck.pojo.OrderItem;

import java.util.List;

public interface OrderItemDAO
{
    /**
     * 保存订单项
     * @param orderItem
     */
    public int saveOrderItem(OrderItem orderItem);

    /**
     * 根据订单号查询订单明细
     * @param orderId
     * @return
     */
    public List<OrderItem> queryOrderItemByOrderId(String orderId);
}

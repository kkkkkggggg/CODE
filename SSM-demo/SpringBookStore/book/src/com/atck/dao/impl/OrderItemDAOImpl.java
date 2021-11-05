package com.atck.dao.impl;

import com.atck.dao.OrderItemDAO;
import com.atck.pojo.OrderItem;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class OrderItemDAOImpl extends BaseDAO implements OrderItemDAO
{
    /**
     * 保存订单项
     * @param orderItem
     * @return
     */
    @Override
    public int saveOrderItem(OrderItem orderItem)
    {
        // System.out.println("OrderItemDAOImpl程序在["+ Thread.currentThread().getName() +"]线程中");

        String sql = "insert into t_order_item(`name`,`count`,`price`,`total_price`,`order_id`) values(?,?,?,?,?)";
        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }

    /**
     * 根据订单号查询订单明细
     * @param orderId
     * @return
     */
    @Override
    public List<OrderItem> queryOrderItemByOrderId(String orderId)
    {
        String sql = "select `id`,`name`,`count`,`price`,`total_price` totalPrice,`order_id` orderId from t_order_item where order_id = ?";
        return queryForList(OrderItem.class,sql,orderId);
    }
}

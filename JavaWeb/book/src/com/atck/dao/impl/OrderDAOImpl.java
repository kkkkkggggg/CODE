package com.atck.dao.impl;

import com.atck.dao.OrderDAO;
import com.atck.pojo.Order;

import java.util.List;

public class OrderDAOImpl extends BaseDAO implements OrderDAO
{
    /**
     * 保存订单
     * @param order
     * @return
     */
    @Override
    public int saveOrder(Order order)
    {
        // System.out.println("OrderDAOImpl程序在["+ Thread.currentThread().getName() +"]线程中");

        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";

        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }

    /**
     * 查询全部订单
     * @return
     */
    @Override
    public List<Order> queryOrders()
    {
        String sql = "select `order_id` orderId,`create_time` createTime,`price`,`status`,`user_id` userId from t_order";
        return queryForList(Order.class,sql);
    }

    /**
     * 修改订单状态
     * @param orderId
     * @param status
     * @return
     */
    @Override
    public int changeOrderStatus(String orderId, Integer status)
    {
        String sql = "update t_order set status = ? where order_id = ?";
        return update(sql,status,orderId);
    }

    /**
     * 根据用户编号查询订单信息
     * @param userId
     * @return
     */
    @Override
    public List<Order> queryOrderByUserId(Integer userId)
    {
        String sql = "select `order_id` orderId,`create_time` createTime,`price`,`status`,`user_id` userId from t_order where user_id = ?";
        return queryForList(Order.class,sql,userId);
    }


}

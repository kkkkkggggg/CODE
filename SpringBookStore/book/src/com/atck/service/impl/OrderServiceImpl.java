package com.atck.service.impl;

import com.atck.dao.BookDAO;
import com.atck.dao.OrderDAO;
import com.atck.dao.OrderItemDAO;
import com.atck.dao.impl.BookDAOImpl;
import com.atck.dao.impl.OrderDAOImpl;
import com.atck.dao.impl.OrderItemDAOImpl;
import com.atck.pojo.*;
import com.atck.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
@Service
public class OrderServiceImpl implements OrderService
{
    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private OrderItemDAO orderItemDAO;

    @Autowired
    private BookDAO bookDAO;

    /**
     * 生成订单
     * @param cart
     * @param userId
     * @return
     */
    @Override
    public String createOrder(Cart cart, Integer userId)
    {
        // System.out.println("OrderServiceImpl程序在["+ Thread.currentThread().getName() +"]线程中");

        //订单号===唯一性
        String orderId = System.currentTimeMillis() + "" + userId;
        //创建一个订单对象
        Order order = new Order(orderId,new Date(),cart.getTotalPrice(),0,userId);
        //保存订单
        orderDAO.saveOrder(order);



        //遍历购物车中每一个商品项转换为订单项保存到数据库
        for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet())
        {
            //获取每一个购物车中的商品项转化为每一个订单项
            CartItem cartItem = entry.getValue();

            OrderItem orderItem = new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(),orderId);
            //保存每一个订单项到数据库
            orderItemDAO.saveOrderItem(orderItem);

            //更新库存和销量信息
            Book book = bookDAO.queryBookById(cartItem.getId());
            book.setStock(book.getStock() - cartItem.getCount());
            // int i = 10 / 0;
            book.setSales(book.getSales() + cartItem.getCount());
            bookDAO.updateBook(book);

        }

        //清空购物车
        cart.clear();

        return orderId;
    }

    /**
     * 查询全部订单
     * @return
     */
    @Override
    public List<Order> showAllOrders()
    {
        return orderDAO.queryOrders();
    }

    /**
     * 发货
     * @param orderId
     * @return
     */
    @Override
    public int sendOrder(String orderId)
    {
        return orderDAO.changeOrderStatus(orderId,1);
    }

    /**
     * 查看订单详情
     * @param orderId
     * @return
     */
    @Override
    public List<OrderItem> showOrderDetail(String orderId)
    {
        return orderItemDAO.queryOrderItemByOrderId(orderId);
    }

    /**
     * 查看我的订单
     * @param userId
     * @return
     */
    @Override
    public List<Order> showMyOrders(Integer userId)
    {
        return orderDAO.queryOrderByUserId(userId);
    }

    /**
     * 签收订单/确认收货
     * @param orderId
     * @return
     */
    @Override
    public int receiveOrder(String orderId)
    {
        return orderDAO.changeOrderStatus(orderId,2);
    }


}

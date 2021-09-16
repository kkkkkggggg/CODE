package com.atck.test;

import com.atck.dao.OrderDAO;
import com.atck.dao.impl.OrderDAOImpl;
import com.atck.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class OrderDAOTest
{
    OrderDAO orderDAO = new OrderDAOImpl();
    @Test
    public void saveOrder()
    {

        orderDAO.saveOrder(new Order("1234567890",new Date(),new BigDecimal(100),0,1));
    }

    @Test
    public void queryOrders()
    {
        List<Order> orders = orderDAO.queryOrders();
        orders.forEach(System.out::println);

    }

    @Test
    public void changeOrderStatus()
    {
        int i = orderDAO.changeOrderStatus("16253654887701", 2);
        System.out.println(i);
    }

    @Test
    public void queryOrderByUserId()
    {
        List<Order> orders = orderDAO.queryOrderByUserId(1);
        System.out.println(orders);
    }
}
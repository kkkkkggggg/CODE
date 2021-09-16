package com.atck.test;

import com.atck.dao.OrderDAO;
import com.atck.dao.impl.OrderDAOImpl;
import com.atck.pojo.Order;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class OrderDAOTest
{
   ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
    @Test
    public void saveOrder()
    {
        OrderDAO orderDAO = context.getBean(OrderDAO.class);
        orderDAO.saveOrder(new Order("1234567890",new Date(),new BigDecimal(100),0,1));
    }

    @Test
    public void queryOrders()
    {
        OrderDAO orderDAO = context.getBean(OrderDAO.class);

        List<Order> orders = orderDAO.queryOrders();
        orders.forEach(System.out::println);

    }

    @Test
    public void changeOrderStatus()
    {
        OrderDAO orderDAO = context.getBean(OrderDAO.class);

        int i = orderDAO.changeOrderStatus("1234567890", 2);

        System.out.println(i);
    }

    @Test
    public void queryOrderByUserId()
    {
        OrderDAO orderDAO = context.getBean(OrderDAO.class);

        List<Order> orders = orderDAO.queryOrderByUserId(1);
        System.out.println(orders);
    }
}
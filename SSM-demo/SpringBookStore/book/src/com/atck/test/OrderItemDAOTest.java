package com.atck.test;

import com.atck.dao.OrderItemDAO;
import com.atck.dao.impl.OrderItemDAOImpl;
import com.atck.pojo.OrderItem;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.BitSet;
import java.util.List;

import static org.junit.Assert.*;

public class OrderItemDAOTest
{
    ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

    @Test
    public void saveOrderItem()
    {
        OrderItemDAO orderItemDAO = context.getBean(OrderItemDAO.class);
        orderItemDAO.saveOrderItem(new OrderItem(null,"java从入门到精通",1,new BigDecimal(100),new BigDecimal(100),"1234567890"));
        orderItemDAO.saveOrderItem(new OrderItem(null,"javascript从入门到精通",2,new BigDecimal(100),new BigDecimal(200),"1234567890"));
        orderItemDAO.saveOrderItem(new OrderItem(null,"Netty从入门到精通",1,new BigDecimal(100),new BigDecimal(100),"1234567890"));
    }

    @Test
    public void queryOrderItemByOrderId()
    {
        OrderItemDAO orderItemDAO = context.getBean(OrderItemDAO.class);

        List<OrderItem> orderItems = orderItemDAO.queryOrderItemByOrderId("1234567890");
        System.out.println(orderItems);
    }
}
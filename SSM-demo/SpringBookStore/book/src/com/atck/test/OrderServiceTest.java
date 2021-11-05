package com.atck.test;

import com.atck.pojo.Cart;
import com.atck.pojo.CartItem;
import com.atck.pojo.Order;
import com.atck.pojo.OrderItem;
import com.atck.service.OrderService;
import com.atck.service.impl.OrderServiceImpl;
import com.atck.utils.WebUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class OrderServiceTest
{
    ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

    @Test
    public void createOrder()
    {
        OrderService orderService = context.getBean(OrderService.class);
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"哈克司机电话",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(1,"哈克司机电话",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(2,"啊实打实的",1,new BigDecimal(90),new BigDecimal(90)));
        cart.addItem(new CartItem(2,"啊实打实的",1,new BigDecimal(90),new BigDecimal(90)));

        System.out.println("订单号是"+orderService.createOrder(cart, 1));
    }


    @Test
    public void showAllOrders()
    {
        OrderService orderService = context.getBean(OrderService.class);
        List<Order> orders = orderService.showAllOrders();
        orders.forEach(System.out::println);
    }

    @Test
    public void sendOrder()
    {
        OrderService orderService = context.getBean(OrderService.class);
        int i = orderService.sendOrder("16265746423151");
    }

    @Test
    public void showOrderDetail()
    {
        OrderService orderService = context.getBean(OrderService.class);
        List<OrderItem> orderItems = orderService.showOrderDetail("16265746423151");
        orderItems.forEach(System.out::println);
    }

    @Test
    public void showMyOrders()
    {
        OrderService orderService = context.getBean(OrderService.class);
        List<Order> orders = orderService.showMyOrders(1);
        orders.forEach(System.out::println);
    }

    @Test
    public void receiveOrder()
    {
        OrderService orderService = context.getBean(OrderService.class);
        int i = orderService.receiveOrder("16265746423151");
    }
    @Test
    public void annoTest()
    {
        OrderService orderService = WebUtils.getBean(OrderService.class);
        List<Order> orders = orderService.showMyOrders(1);
        orders.forEach(System.out::println);
    }
}
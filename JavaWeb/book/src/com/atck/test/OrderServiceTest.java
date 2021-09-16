package com.atck.test;

import com.atck.pojo.Cart;
import com.atck.pojo.CartItem;
import com.atck.service.OrderService;
import com.atck.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderServiceTest
{

    @Test
    public void createOrder()
    {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"哈克司机电话",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(1,"哈克司机电话",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(2,"啊实打实的",1,new BigDecimal(90),new BigDecimal(90)));
        cart.addItem(new CartItem(2,"啊实打实的",1,new BigDecimal(90),new BigDecimal(90)));

        OrderService orderService = new OrderServiceImpl();
        System.out.println("订单号是"+orderService.createOrder(cart, 1));
    }
}
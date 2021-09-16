package com.atck.test;

import com.atck.pojo.Cart;
import com.atck.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest
{
    Cart cart = new Cart();

    @Test
    public void addItem()
    {


        cart.addItem(new CartItem(1,"哈克司机电话",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(1,"哈克司机电话",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(2,"啊实打实的",1,new BigDecimal(90),new BigDecimal(90)));
        cart.addItem(new CartItem(2,"啊实打实的",1,new BigDecimal(90),new BigDecimal(90)));
        cart.addItem(new CartItem(3,"阿斯达四方",1,new BigDecimal(70),new BigDecimal(70)));
        cart.addItem(new CartItem(4,"v本项目吹牛逼",1,new BigDecimal(80),new BigDecimal(80)));

        System.out.println(cart.toString());
    }

    @Test
    public void deleteItem()
    {
        cart.addItem(new CartItem(1,"哈克司机电话",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(1,"哈克司机电话",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(2,"啊实打实的",1,new BigDecimal(90),new BigDecimal(90)));
        cart.addItem(new CartItem(2,"啊实打实的",1,new BigDecimal(90),new BigDecimal(90)));
        cart.addItem(new CartItem(3,"阿斯达四方",1,new BigDecimal(70),new BigDecimal(70)));
        cart.addItem(new CartItem(4,"v本项目吹牛逼",1,new BigDecimal(80),new BigDecimal(80)));

        cart.deleteItem(4);

        System.out.println(cart.toString());
    }

    @Test
    public void clear()
    {
        cart.addItem(new CartItem(1,"哈克司机电话",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(1,"哈克司机电话",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(2,"啊实打实的",1,new BigDecimal(90),new BigDecimal(90)));
        cart.addItem(new CartItem(2,"啊实打实的",1,new BigDecimal(90),new BigDecimal(90)));
        cart.addItem(new CartItem(3,"阿斯达四方",1,new BigDecimal(70),new BigDecimal(70)));
        cart.addItem(new CartItem(4,"v本项目吹牛逼",1,new BigDecimal(80),new BigDecimal(80)));

        cart.clear();

        System.out.println(cart.toString());
    }

    @Test
    public void updateCount()
    {
        cart.addItem(new CartItem(1,"哈克司机电话",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(1,"哈克司机电话",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(2,"啊实打实的",1,new BigDecimal(90),new BigDecimal(90)));
        cart.addItem(new CartItem(2,"啊实打实的",1,new BigDecimal(90),new BigDecimal(90)));
        cart.addItem(new CartItem(3,"阿斯达四方",1,new BigDecimal(70),new BigDecimal(70)));
        cart.addItem(new CartItem(4,"v本项目吹牛逼",1,new BigDecimal(80),new BigDecimal(80)));

        cart.updateCount(4,2);

        System.out.println(cart.toString());
    }
}
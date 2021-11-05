package com.atck.pojo;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车对象
 */
public class Cart
{

    /**
     * key是商品编号，value是商品信息
     */
    private Map<Integer,CartItem> items = new LinkedHashMap<Integer,CartItem>();

    public Integer getTotalCount()
    {
        Integer totalCount = 0;
        for (Map.Entry<Integer,CartItem> entry : items.entrySet())
        {
            totalCount += entry.getValue().getCount();
        }

        return totalCount;
    }



    public BigDecimal getTotalPrice()
    {
        BigDecimal totalPrice = new BigDecimal(0);

        for (Map.Entry<Integer,CartItem> entry : items.entrySet())
        {
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }



        return totalPrice;
    }



    public Map<Integer, CartItem> getItems()
    {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items)
    {
        this.items = items;
    }

    @Override
    public String toString()
    {
        return "Cart{" + "totalCount=" + getTotalCount() + ", totalPrice=" + getTotalPrice() + ", items=" + items + '}';
    }

    /**
     * 添加商品项
     * @param item
     */
    public void addItem(CartItem item)
    {
        //先查看购物车中是否已经添加过此商品，如果已添加，则数量累加，总金额更新，如果没有添加过，直接放到集合中即可
        CartItem cartItem = items.get(item.getId());

        if (cartItem == null)
        {
            //之前没有添加过此商品
            items.put(item.getId(),item);
        }else
        {
            //已经添加过的情况
            cartItem.setCount(cartItem.getCount() + 1);//数量累加
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));//更新总金额

        }
    }

    /**
     * 删除商品项
     * @param id
     */
    public void deleteItem(Integer id)
    {
        items.remove(id);
    }

    /**
     * 清空购物车
     */
    public void clear()
    {
        items.clear();
    }

    /**
     *修改商品数量
     */
    public void updateCount(Integer id,Integer count)
    {
        //先查看购物车中是否有此商品，如果有，修改商品数量，更新总金额
        CartItem cartItem = items.get(id);
        if (cartItem != null)
        {
            cartItem.setCount(count);
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(count)));
        }
    }

}

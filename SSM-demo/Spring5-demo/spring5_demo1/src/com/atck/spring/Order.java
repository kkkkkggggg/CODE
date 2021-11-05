package com.atck.spring;

public class Order
{
    private String oName;
    private String address;



    public Order(String oName, String address)
    {
        this.oName = oName;
        this.address = address;
    }

    @Override
    public String toString()
    {
        return "Order{" + "oName='" + oName + '\'' + ", address='" + address + '\'' + '}';
    }
}

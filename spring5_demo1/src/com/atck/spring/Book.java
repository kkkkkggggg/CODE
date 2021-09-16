package com.atck.spring;

public class Book
{
    private  String bName;
    private String bAuthor;
    private String address;

    public void setbAuthor(String bAuthor)
    {
        this.bAuthor = bAuthor;
    }

    public void setbName(String bName)
    {
        this.bName = bName;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    @Override
    public String toString()
    {
        return "Book{" + "bName='" + bName + '\'' + ", bAuthor='" + bAuthor + '\'' + ", address='" + address + '\'' + '}';
    }
}

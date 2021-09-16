package com.book;

public class Book
{
    private String bookName;
    private String author;
    private double price;
    private double stock;
    private double sale;
    private Address address;
    //一定要有无参构造器
    public Book()
    {
    }

    public Book(String bookName, String author, double price, double stock, double sale, Address address)
    {
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.stock = stock;
        this.sale = sale;
        this.address = address;
    }

    public String getBookName()
    {
        return bookName;
    }

    public void setBookName(String bookName)
    {
        this.bookName = bookName;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public double getStock()
    {
        return stock;
    }

    public void setStock(double stock)
    {
        this.stock = stock;
    }

    public double getSale()
    {
        return sale;
    }

    public void setSale(double sale)
    {
        this.sale = sale;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    @Override
    public String toString()
    {
        return "Book{" + "bookName='" + bookName + '\'' + ", author='" + author + '\'' + ", price=" + price + ", stock=" + stock + ", sale=" + sale + ", address=" + address + '}';
    }
}

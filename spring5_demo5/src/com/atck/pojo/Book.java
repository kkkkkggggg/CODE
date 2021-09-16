package com.atck.pojo;

public class Book
{
    private Integer userId;
    private String userName;
    private String uStatus;

    public Book()
    {
    }

    public Book(Integer userId, String userName, String uStatus)
    {
        this.userId = userId;
        this.userName = userName;
        this.uStatus = uStatus;
    }

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getuStatus()
    {
        return uStatus;
    }

    public void setuStatus(String uStatus)
    {
        this.uStatus = uStatus;
    }

    @Override
    public String toString()
    {
        return "Book{" + "userId=" + userId + ", userName='" + userName + '\'' + ", uStatus='" + uStatus + '\'' + '}';
    }
}

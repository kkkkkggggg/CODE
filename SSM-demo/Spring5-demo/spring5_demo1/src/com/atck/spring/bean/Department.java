package com.atck.spring.bean;

import java.util.List;

public class Department
{
    private String dname;

    public void setDname(String dname)
    {
        this.dname = dname;
    }

    @Override
    public String toString()
    {
        return "Department{" + "dname='" + dname + '\'' + '}';
    }
}

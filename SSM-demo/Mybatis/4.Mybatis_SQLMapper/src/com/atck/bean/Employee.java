package com.atck.bean;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.type.Alias;

@Alias("emp")
public class Employee
{
    private Integer id;
    private String empName;
    private String email;
    private Integer gender;


    private String loginAccount;

    public Employee()
    {
    }

    public Employee(Integer id, String empName, String email, Integer gender, String loginAccount)
    {
        this.id = id;
        this.empName = empName;
        this.email = email;
        this.gender = gender;
        this.loginAccount = loginAccount;
    }

    public String getLoginAccount()
    {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount)
    {
        this.loginAccount = loginAccount;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getEmpName()
    {
        return empName;
    }

    public void setEmpName(String empName)
    {
        this.empName = empName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Integer getGender()
    {
        return gender;
    }

    public void setGender(Integer gender)
    {
        this.gender = gender;
    }

    @Override
    public String toString()
    {
        return "Employee{" + "id=" + id + ", empName='" + empName + '\'' + ", email='" + email + '\'' + ", gender=" + gender + ", loginAccount='" + loginAccount + '\'' + '}';
    }
}

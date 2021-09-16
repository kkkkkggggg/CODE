package com.atck.spring.bean;

public class Employee
{
    private String ename;
    private String gender;
    //员工属于某一个部门
    private Department department;
    public void setEname(String ename)
    {
        this.ename = ename;
    }

    public void setDepartment(Department department)
    {
        this.department = department;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    @Override
    public String toString()
    {
        return "Employee{" + "ename='" + ename + '\'' + ", gender='" + gender + '\'' + ", department=" + department + '}';
    }

    //生成department的get方法

    public Department getDepartment()
    {
        return department;
    }
}

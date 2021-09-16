package com.atck.dao;

import com.atck.bean.Employee;

public interface EmployeeDAO
{
    //mybatis-3.4.1.jar
    //mysql-connector-java-5.1.37-bin.jar
    //log4j-1.2.17.jar
    //按照员工id查询员工
    public Employee getEmpById(Integer id);
}

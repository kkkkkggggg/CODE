package com.atck.dao;

import com.atck.bean.Employee;

public interface EmployeeDAO
{
    Employee getEmpById(Integer id);
    int updateEmployee(Employee employee);
    boolean deleteEmployee(Integer id);
    int insertEmployee(Employee employee);
}

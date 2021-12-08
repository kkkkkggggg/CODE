package com.atck.admin.service.impl;

import com.atck.admin.bean.Employee;
import com.atck.admin.mapper.EmployeeMapper;
import com.atck.admin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
    @Autowired
    EmployeeMapper employeeMapper;

    public Employee getEmpById(Integer id)
    {
        return employeeMapper.selectEmpById(id);
    }
}

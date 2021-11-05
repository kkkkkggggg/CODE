package com.atck.service;

import com.atck.bean.Employee;
import com.atck.bean.EmployeeExample;
import com.atck.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService
{
    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 查询所有员工
     * @return
     */
    public List<Employee> getAll()
    {

        return  employeeMapper.selectByExampleWithDept(null);
    }

    public Integer saveEmp(Employee employee)
    {
        return employeeMapper.insert(employee);
    }

    /**
     * 检查用户名是否可用
     * @param empName
     * @return true代表当前姓名可用，false 不可用
     */
    public boolean checkUserName(String empName)
    {
        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andEmpNameEqualTo(empName);
        long count = employeeMapper.countByExample(employeeExample);

        return count == 0;
    }

    public Employee getEmpById(Integer id)
    {
        return employeeMapper.selectByPrimaryKey(id);
    }

    public Integer updateEmpById(Employee employee)
    {
        return employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public Integer deleteEmpById(Integer empId)
    {
        return employeeMapper.deleteByPrimaryKey(empId);
    }


    public void deleteBatch(List<Integer> ids)
    {
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andEmpIdIn(ids);

        employeeMapper.deleteByExample(example);
    }
}

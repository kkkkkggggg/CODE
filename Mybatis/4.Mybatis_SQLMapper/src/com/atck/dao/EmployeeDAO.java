package com.atck.dao;

import com.atck.bean.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeDAO
{

    /*
    key是这条记录的主键
    value是这个主键对应的employee对象
    @MapKey("id"):把查出的id的值作为key封装对象
    * */
    @MapKey("id")
    Map<Integer,Employee> getAllEmpsReturnMap();


    /*
    id      empname     gender      email           login_account
    1       hhhhh       1           hhhhh@qq.com    12313254

    列名作为key，值作为value
     */
    Map<String,Object> getEmpByIdReturnMap(Integer id);

    List<Employee> getAllEmps();

    Employee getEmpById(Integer id);

    Employee getEmpByIdAndEmpname(@Param("id") Integer id, @Param("empname") String empname);

    int updateEmployee(Employee employee);

    boolean deleteEmployee(Integer id);

    int insertEmployee(Employee employee);

    int insertEmployee2(Employee employee);
}

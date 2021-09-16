package com.atck.dao;

import com.atck.bean.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface EmployeeDAO
{
    //使用注解，不用写EmployeeDAO接口的映射文件
    // @Select("select * from t_employee where id = #{id}")
    Employee getEmpById(Integer id);

    // @Update("update t_employee set empname = #{empName},gender = #{gender},email = #{email} where id = #{id}")
    int updateEmployee(Employee employee);

    // @Delete("delete from t_employee where id = #{id}")
    boolean deleteEmployee(Integer id);

    // @Insert("insert into t_employee(empname,gender,email) values (#{empName},#{gender},#{email})")
    int insertEmployee(Employee employee);
}

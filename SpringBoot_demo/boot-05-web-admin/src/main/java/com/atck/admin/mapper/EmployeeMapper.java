package com.atck.admin.mapper;

import com.atck.admin.bean.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper
{
    @Select("select `id`,`name`,`logic_flag` from tbl_user where `id` = #{id}")
    Employee selectEmpById(Integer id);
}

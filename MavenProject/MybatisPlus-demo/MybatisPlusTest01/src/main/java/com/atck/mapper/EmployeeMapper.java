package com.atck.mapper;

import com.atck.bean.Employee;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * Mapper接口
 *
 * 基于Mybatis：在mapper接口中编写CRUD相关的方法，提供Mapper接口对应的SQL映射文件以及方法对应的SQL语句
 *
 * 基于MP：让Mapper接口继承BaseMapper接口即可
 *          BaseMapper<T>:泛型指定的就是当前Mapper接口所操作的实体类类型
 */
public interface EmployeeMapper extends BaseMapper<Employee>
{

}

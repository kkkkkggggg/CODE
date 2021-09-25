package com.atck.mp.service.impl;

import com.atck.mp.beans.Employee;
import com.atck.mp.mapper.EmployeeMapper;
import com.atck.mp.service.EmployeeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kkkkk
 * @since 2021-09-20
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    //不用再进行mapper的注入

    /**
     * EmployeeServiceImpl继承了ServiceImpl
     * 1.在ServiceImpl中已经完成了 Mapper对象的注入，直接在EmployeeServiceImpl中进行使用
     * 2.在ServiceImpl中也帮我们提供了常用的CRUD方法，基本的一些CRUD方法在service中不需要我们自己定义
     */
}

package com.atck.test;

import com.atck.bean.Employee;
import com.atck.mapper.EmployeeMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MybatisTest02
{
    private ApplicationContext iocContext = new ClassPathXmlApplicationContext("applicationContext.xml");

    /**
     * AR 分页操作
     */
    @Test
    public void testSelectPage()
    {
        Employee employee = new Employee();

        Page<Employee> gender = employee.selectPage(new Page<>(1, 2), new EntityWrapper<Employee>().eq("gender", 0));

        List<Employee> records = gender.getRecords();

        System.out.println(records);
    }

    /**
     * AR 查询操作
     */
    @Test
    public void testSelect()
    {
        Employee employee = new Employee();


        // Employee employee1 = employee.selectById();
        // List<Employee> employees = employee.selectAll();
        //
        // // System.out.println(employee1);
        //
        // employees.forEach(System.out::println);

        int gender = employee.selectCount(new EntityWrapper<Employee>().eq("gender", 0));

        System.out.println(gender);
    }

    /**
     * AR 删除操作
     *
     * 注意：删除不存在的数据在逻辑上也是成功的
     */
    @Test
    public void testDelete()
    {
        Employee employee = new Employee();
        employee.setId(6);

        employee.deleteById();
    }

    /**
     * AR 修改操作
     */
    @Test
    public void testUpdate()
    {
        Employee employee = new Employee();
        employee.setAge(50);
        employee.setId(9);
        employee.updateById();


    }

    /**
     *
     * AR插入操作
     */
    @Test
    public void testARInsert()
    {
        Employee employee = new Employee();
        employee.setLastName("哈哈哈");
        employee.setEmail("hhh@atck.com");
        employee.setGender(1);
        employee.setAge(35);

        boolean insert = employee.insert();
        System.out.println(insert);
    }

}

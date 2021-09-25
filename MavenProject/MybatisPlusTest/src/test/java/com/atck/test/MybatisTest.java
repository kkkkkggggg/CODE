package com.atck.test;

import com.atck.bean.Employee;
import com.atck.mapper.EmployeeMapper;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest
{


    private ApplicationContext iocContext = new ClassPathXmlApplicationContext("applicationContext.xml");

    EmployeeMapper employeeMapper = iocContext.getBean("employeeMapper", EmployeeMapper.class);
    @Test
    public void testEnvironment() throws Exception
    {
        DataSource ds = iocContext.getBean("dataSource", DataSource.class);
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }

    @Test
    public void test02()
    {
        EmployeeMapper employeeMapper = iocContext.getBean("employeeMapper", EmployeeMapper.class);
        Employee employee = employeeMapper.selectById(1);
        System.out.println(employee);
    }
    /**
     * 条件构造器，删除操作
     *
     */
    @Test
    public void testEntityWrapperDelete()
    {
        employeeMapper.delete(new EntityWrapper<Employee>().eq("last_name","Tom").eq("age",22));
    }

    /**
     * 条件构造器，修改操作
     */
    @Test
    public void testEntityWrapperUpdate()
    {
        Employee employee = new Employee();
        employee.setLastName("玛丽亚老师");
        employee.setEmail("mly@atck.com");
        employee.setGender(0);
        employeeMapper.update(employee,new EntityWrapper<Employee>().eq("id",7));
    }

    /**
     * 条件构造器，查询操作
     */
    @Test
    public void testEntityWrapperSelect()
    {
        //我们需要分页查询tbl_employee表中，年龄在18-50之间，性别为男且姓名为XX的所有用户
        // List<Employee> employees = employeeMapper.selectPage(new Page<>(1, 2), new EntityWrapper<Employee>().between("age", 18, 50).eq("gender", 1).eq("last_name", "Tom"));
        //
        // System.out.println(employees);

        List list = employeeMapper.selectPage(new Page<>(1, 2), Condition.create().between("age", 18, 50).eq("gender", 0).eq("last_name", "Jerry"));
        System.out.println(list);

        //查询tbl_employee表中，性别为女且名字带有“老师”或者邮箱中带有"a"的所有用户
        // List<Employee> employees = employeeMapper.selectList( new EntityWrapper<Employee>().eq("gender", 0)
        //         .like("last_name", "老师")
        //         // .or()    SQL:SELECT id,last_name AS lastName,email,gender,age FROM tbl_employee WHERE (gender = ? AND last_name LIKE ? OR email LIKE ?)
        //         .orNew()   //SQL:SELECT id,last_name AS lastName,email,gender,age FROM tbl_employee WHERE (gender = ? AND last_name LIKE ?) OR (email LIKE ?)
        //         .like("email","a"));
        // employees.forEach(System.out::println);

        //查询性别为女的，根据age进行排序(asc/desc),简单分页
        // List<Employee> employees = employeeMapper.selectList(new EntityWrapper<Employee>().eq("gender", 0).orderBy("age", false).last("limit 2"));
        // employees.forEach(System.out::println);
    }

    /**
     * 通用删除操作
     */
    @Test
    public void testCommonDelete()
    {

        //根据id删除
        Integer integer = employeeMapper.deleteById(6);
        System.out.println(integer);

        //2.根据条件删除
        // Map<String,Object> columnMap = new HashMap<>();
        // columnMap.put("id",5);
        // Integer integer = employeeMapper.deleteByMap(columnMap);
        // System.out.println(integer);

        //3.根据id批量删除
        // Integer integer = employeeMapper.deleteBatchIds(Arrays.asList(3, 4));
        // System.out.println(integer);
    }

    /**
     * 通用的查询操作
     */
    @Test
    public void testCommonSelect()
    {
        //1.通过id查询
        //Employee employee = employeeMapper.selectById(1);

        //2.通过多个列进行查询 id + lastName
        // Employee employee = new Employee();
        // employee.setId(2);
        // employee.setLastName("Jerry");
        //
        // Employee selectOne = employeeMapper.selectOne(employee);

        //3.根据多个id查询
        // List<Employee> employees = employeeMapper.selectBatchIds(Arrays.asList(1, 2, 3, 4, 5));
        // System.out.println(employees);

        //4.通过Map封装条件查询
        // Map<String,Object> columnMap = new HashMap<String, Object>();
        // columnMap.put("last_name","Tom");
        // columnMap.put("gender",1);
        //
        // List<Employee> employees = employeeMapper.selectByMap(columnMap);
        //
        // System.out.println(employees);

        //5.分页查询
        List<Employee> employees = employeeMapper.selectPage(new Page<>(1,5), null);
        employees.forEach(System.out::println);
    }


    /**
     * 通用更新操作
     */
    @Test
    public void testCommonUpdate()
    {
        //初始化修改对象
        Employee employee = new Employee();
        employee.setId(6);
        employee.setLastName("小泽老师");
        employee.setEmail("xiaoze@attck.com");
        employee.setGender(0);
//        employee.setAge(33);

//        Integer result = employeeMapper.updateById(employee);
        Integer result = employeeMapper.updateAllColumnById(employee);
        System.out.println("result:" + result);
    }


    /**
     * 通用插入操作
     */
    @Test
    public void testCommonInsert()
    {
        //初始化Employee对象
        Employee employee = new Employee();
        employee.setLastName("MP");
        employee.setEmail("mp@atck.com");
//        employee.setGender(1);
//        employee.setAge(22);
        employee.setSalary(new BigDecimal(20000.0));

        //插入到数据库
        //insert方法在插入时，会根据实体类的每个属性进行非空判断，只有非空的属性对应的字段才会出现到sql语句中
//        Integer result = employeeMapper.insert(employee);

        //insertAllColumn方法在插入时，不管属性是否非空，都会出现在SQL语句中
        Integer result = employeeMapper.insertAllColumn(employee);


        System.out.println("result:" + result);

        //获取当前数据在数据库中的主键值
        Integer key = employee.getId();
        System.out.println("key:" + key);
    }

    @Test
    public void test03()
    {
        String[] beanDefinitionNames = iocContext.getBeanDefinitionNames();

        for (String s : beanDefinitionNames)
        {
            System.out.println(s);
        }
    }
}

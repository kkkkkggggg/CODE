package com.atck.test;

import com.atck.mp.beans.Employee;
import com.atck.mp.mapper.EmployeeMapper;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.binding.MapperProxy;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Locale;

public class MybatisTest02
{


    @Test
    public void testGenerator()
    {
        //全局配置
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(true) //是否支持AR模式
                .setAuthor("kkkkk") //作者
                .setOutputDir("D:\\DevelopmentDocument\\MavenProject\\MybatisPlusTest02\\src\\main\\java")
                //生成路径
                .setFileOverride(true)//文件覆盖
                .setServiceName("%sService") //设置生成的service接口名首字母是否为I
                .setIdType(IdType.AUTO)//主键策略
                .setBaseResultMap(true)//通用查询映射结果
                .setBaseColumnList(true);//通用查询结果列

        //数据源配置
        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL)
                .setUrl("jdbc:mysql://localhost:3306/mp")
                .setDriverName("com.mysql.jdbc.Driver")
                .setUsername("root")
                .setPassword("12138970");
        //策略配置
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setCapitalMode(true) // 全局大写命名
                .setDbColumnUnderline(true) //表名 字段名 是否使用下滑线命名
                .setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
                .setInclude("tbl_employee") //生成的表
                .setTablePrefix("tbl_"); // 表前缀
        //包名策略
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.atck.mp")
                .setController("controller")
                .setEntity("beans")
                .setService("service");
        AutoGenerator ag = new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dsConfig)
                .setStrategy(stConfig)
                .setPackageInfo(pkConfig);
        ag.execute();
    }

    @Test
    public void test()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        EmployeeMapper employeeMapper = context.getBean("employeeMapper", EmployeeMapper.class);

        Employee employee = employeeMapper.selectById(2);

        System.out.println(employee);

        System.out.println(employeeMapper);

    }

    @Test
    public void test01()
    {
        // Employee employee = new Employee();
        //
        // employee.setId(2);
        //
        // Employee employee1 = employee.selectById();
        //
        // System.out.println(employee1);

    }
}

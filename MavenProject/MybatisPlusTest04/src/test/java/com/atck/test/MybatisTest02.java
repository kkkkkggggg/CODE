package com.atck.test;

import com.atck.mp.beans.Employee;
import com.atck.mp.beans.User;
import com.atck.mp.mapper.EmployeeMapper;
import com.atck.mp.mapper.UserMapper;
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
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MybatisTest02
{
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    EmployeeMapper employeeMapper = context.getBean("employeeMapper",EmployeeMapper.class);
    UserMapper userMapper = context.getBean("userMapper",UserMapper.class);
    /**
     * 测试自定义全局操作
     */
    @Test
    public void testMysqlInjector()
    {
        Integer result = employeeMapper.deleteAll();
        System.out.println(result);

    }

    @Test
    public void testGenerator()
    {
        //全局配置
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(true) //是否支持AR模式
                .setAuthor("kkkkk") //作者
                .setOutputDir("D:\\DevelopmentDocument\\MavenProject\\MybatisPlusTest04\\src\\main\\java")
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
                .setInclude("tbl_user") //生成的表
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

    /**
     * 测试逻辑删除
     */

    @Test
    public void testLogicDelete()
    {
        // userMapper.deleteById(1);

        User user = userMapper.selectById(1);
        System.out.println(user);
    }

    /**
     * 测试公共字段填充
     */
    @Test
    public void testMetaObjectHandler()
    {
        User user = new User();

        user.setLogicFlag(1);

        userMapper.insert(user);


    }

    /**
     * 测试公共字段填充
     */
    @Test
    public void testMetaObjectHandler01()
    {
        User user = new User();

        user.setLogicFlag(1);
        user.setName("tom");
        userMapper.insert(user);

    }

    /**
     * 测试公共字段填充
     */
    @Test
    public void testMetaObjectHandler02()
    {
        User user = new User();

        user.setId(2);

        Integer update = userMapper.updateById(user);

        System.out.println(update);

    }
}

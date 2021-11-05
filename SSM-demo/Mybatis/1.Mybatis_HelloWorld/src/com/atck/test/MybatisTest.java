package com.atck.test;

import com.atck.bean.Employee;
import com.atck.dao.EmployeeDAO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest
{
    @Test
    public void test() throws IOException
    {
        //1.根据全局文件创建出一个SqlSessionFactory
        //SqlSessionFactory：是SqlSession工厂，负责创建SqlSession对象
        //SqlSession:sql会话（代表和数据库的一次会话）
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        Employee emp = null;
        SqlSession session = sqlSessionFactory.openSession();;
        try
        {
            //2.获取和数据库的一次会话

            //3.使用SqlSession操作数据库,获取到DAO接口的实现
            EmployeeDAO employeeDAO = session.getMapper(EmployeeDAO.class);

            emp = employeeDAO.getEmpById(1);
        }finally
        {
            session.close();
        }

        System.out.println(emp);
    }
}

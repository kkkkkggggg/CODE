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

public class EmployeeTest
{
    public SqlSessionFactory getSqlSessionFactory()
    {
        //1.根据全局文件创建出一个SqlSessionFactory
        //SqlSessionFactory：是SqlSession工厂，负责创建SqlSession对象
        //SqlSession:sql会话（代表和数据库的一次会话）
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try
        {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

    @Test
    public void testQuery() throws IOException
    {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        //2.获取和数据库的一次会话,传入true表示自动提交，不传入表示手动提交增删改操作
        SqlSession session = sqlSessionFactory.openSession(true);
        Employee emp = null;
        try
        {

            //3.使用SqlSession操作数据库,获取到DAO接口的实现
            EmployeeDAO employeeDAO = session.getMapper(EmployeeDAO.class);

            //4.调用dao中的方法
            emp = employeeDAO.getEmpById(1);
        }finally
        {
            session.close();
        }

        System.out.println(emp);
    }

    @Test
    public void testUpdate()
    {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        int i;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try
        {
            EmployeeDAO employeeDAO = sqlSession.getMapper(EmployeeDAO.class);

            i = employeeDAO.updateEmployee(new Employee(1, "kkkkk", "kkkkk@qq.com", 1,"135465"));
            sqlSession.commit();

        } finally
        {
            sqlSession.close();
        }
        System.out.println(i);
    }

    @Test
    public void testDelete()
    {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        boolean i;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try
        {
            EmployeeDAO employeeDAO = sqlSession.getMapper(EmployeeDAO.class);

            i = employeeDAO.deleteEmployee(1);
            sqlSession.commit();

        } finally
        {

            sqlSession.close();
        }
        System.out.println(i);
    }

    @Test
    public void testInsert()
    {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        int i;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try
        {
            EmployeeDAO employeeDAO = sqlSession.getMapper(EmployeeDAO.class);

            i = employeeDAO.insertEmployee(new Employee(null,"hhhhh","hhhhh@qq.com",1,"2132145"));
            sqlSession.commit();
        } finally
        {
            sqlSession.close();
        }
        System.out.println(i);
    }
}

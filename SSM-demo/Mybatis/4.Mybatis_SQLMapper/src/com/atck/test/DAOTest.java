package com.atck.test;

import com.atck.bean.Cat;
import com.atck.bean.Employee;
import com.atck.bean.Key;
import com.atck.bean.Lock;
import com.atck.dao.CatDAO;
import com.atck.dao.EmployeeDAO;
import com.atck.dao.KeyDAO;
import com.atck.dao.LockDAO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class DAOTest
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
    public void testQuery2() throws IOException
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
            emp = employeeDAO.getEmpByIdAndEmpname(5,"hhhhh");
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
            Employee hhhhh = new Employee(null, "hhhhh", "hhhhh@qq.com", 1, "2132145");
            i = employeeDAO.insertEmployee(hhhhh);
            System.out.println("刚才插入的id:" + hhhhh.getId());
            sqlSession.commit();
        } finally
        {
            sqlSession.close();
        }
        System.out.println(i);
    }

    @Test
    public void testInsert2()
    {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        int i;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try
        {
            EmployeeDAO employeeDAO = sqlSession.getMapper(EmployeeDAO.class);
            Employee hhhhh = new Employee(null, "hhhhh", "hhhhh@qq.com", 1, "2132145");
            employeeDAO.insertEmployee2(hhhhh);
            sqlSession.commit();

        } finally
        {
            sqlSession.close();
        }

    }

    @Test
    public void testQueryAll()
    {
        SqlSessionFactory sessionFactory = getSqlSessionFactory();
        SqlSession session = sessionFactory.openSession();
        EmployeeDAO mapper = session.getMapper(EmployeeDAO.class);

        List<Employee> allEmps = mapper.getAllEmps();

        allEmps.forEach(System.out::println);
        session.close();
    }


    //查询单条记录封装map
    @Test
    public void testQueryReturnMap()
    {
        SqlSessionFactory sessionFactory = getSqlSessionFactory();
        SqlSession session = sessionFactory.openSession();
        EmployeeDAO mapper = session.getMapper(EmployeeDAO.class);
        Map<String, Object> map = mapper.getEmpByIdReturnMap(1);
        System.out.println(map);
        session.close();
    }

    //查询多条记录封装map
    @Test
    public void testGetAllEmpsReturnMap()
    {
        SqlSessionFactory sessionFactory = getSqlSessionFactory();
        SqlSession session = sessionFactory.openSession();
        EmployeeDAO mapper = session.getMapper(EmployeeDAO.class);
        Map<Integer, Employee> map = mapper.getAllEmpsReturnMap();
        System.out.println(map);
        session.close();
    }

    @Test
    public void testCatDAO()
    {
        /**
         * 默认MyBatis自动封装结果集
         * 1）、按照列名和属性名一一对应的规则，不区分大小写
         * 2）、如果不一一对应
         *      1）、开启驼峰命名法（满足驼峰命名规则aaa_bbb  aaaBbb）
         *      2)、
         */
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        SqlSession session = sqlSessionFactory.openSession();

        CatDAO catDAO = session.getMapper(CatDAO.class);

        Cat cat = catDAO.getCatById(1);

        System.out.println(cat);

        session.close();

    }


    /**
     * 联合查询情况下
     * 1、使用级联属性封装联合查询后的所有结果
     */
    @Test
    public void testKeyDAO()
    {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        SqlSession session = sqlSessionFactory.openSession();

        KeyDAO keyDAO = session.getMapper(KeyDAO.class);

        Key key = keyDAO.getKeyById(1);

        System.out.println(key);

        session.close();
    }

    /**
     *
     */
    @Test
    public void testLockDAO()
    {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        SqlSession session = sqlSessionFactory.openSession();

        LockDAO lockDAO = session.getMapper(LockDAO.class);

        Lock lock = lockDAO.getLockById(3);

        System.out.println(lock);

        session.close();
    }


    /**
     * 分步查询
     * 0)、查询钥匙的时候顺便查出锁
     * 1）、keyDAO.getKeyById(1);
     * 2）、lockDAO。getLockById(1);
     */
    @Test
    public void testQueryBySteps() throws InterruptedException
    {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        SqlSession session = sqlSessionFactory.openSession();

        KeyDAO keyDAO = session.getMapper(KeyDAO.class);

        //性能浪费
        Key key = keyDAO.getKeyByIdSimple(1);

        //按需加载，需要的时候加载，不需要的时候不加载，全局开启按需加载策略
        System.out.println(key.getKeyName());

        Thread.sleep(3000);

        System.out.println(key.getLock().getLockName());
        session.close();
    }
}

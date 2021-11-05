package com.atck.test;

import com.atck.bean.Teacher;
import com.atck.dao.TeacherDAO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class DAOTest
{
    SqlSessionFactory sqlSessionFactory;

    @Before
    public void initSqlSessionFactory() throws IOException
    {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    //体会Mybatis一级缓存
    @Test
    public void test()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try
        {
            long l = System.currentTimeMillis();
            TeacherDAO teacherDAO = sqlSession.getMapper(TeacherDAO.class);
            Teacher teacher = teacherDAO.getTeacherById(1);
            System.out.println(teacher);
            long l2 = System.currentTimeMillis();
            Teacher teacher1 = teacherDAO.getTeacherById(1);
            System.out.println(teacher1);
            long l3 = System.currentTimeMillis();
            System.out.println("第一次执行的时间：" + (l2 - l));
            System.out.println("第二次执行的时间：" + (l3 - l2));
            // 第一次执行的时间：266
            // 第二次执行的时间：0
            //true
            System.out.println(teacher == teacher1);
        } finally
        {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    /**
     *
     一级缓存失效的几种情况
     一级缓存是sqlSession级别的缓存
     1、不同的sqlSession，使用不同的一级缓存；只有在当前同一个sqlSession期间查询到的数据
     会保存在这个sqlSession中，下次使用这个sqlSession查询会从缓存中拿
     2、同一个方法，不同的参数，由于之前可能没查过，还会发新的sql
     3、在这个sqlSession期间执行任何一次增删改操作，增删改操作会把一级缓存清空
     4、可以手动清空缓存        sqlSession.clearCache();
     5、二级缓存和一级缓存中不会存在有同一个数据
            二级缓存中，一级缓存关闭了就有了
            一级缓存中，二级缓存中没有这个数据就会看一级缓存，一级缓存中没有就会去查数据库，
            并将查询之后的结果放到一级缓存中，sqlSession关闭后，如果使用了二级缓存，会将一级缓存中的数据保存到二级缓存中
     6、任何时候都是先看二级缓存，再看一级缓存，如果大家都没有就去查询数据库
     每次查询，先看一级缓存中有没有，如果没有就去发送新的sql，每个sqlSession有自己的一级缓存
     */

    @Test
    public void test1()
    {
        //第一个会话

        SqlSession sqlSession = sqlSessionFactory.openSession();
        TeacherDAO teacherDAO = sqlSession.getMapper(TeacherDAO.class);
        Teacher teacher = teacherDAO.getTeacherById(1);
        System.out.println(teacher);
        sqlSession.close();


        //第二个会话
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        TeacherDAO teacherDAO2 = sqlSession2.getMapper(TeacherDAO.class);
        Teacher teacher2 = teacherDAO2.getTeacherById(1);
        System.out.println(teacher2);
        sqlSession2.close();

    }

    @Test
    public void test2()
    {
        //第一个会话

        SqlSession sqlSession = sqlSessionFactory.openSession();
        TeacherDAO teacherDAO = sqlSession.getMapper(TeacherDAO.class);


        Teacher teacher = teacherDAO.getTeacherById(1);
        System.out.println(teacher);

        Teacher teacher1 = teacherDAO.getTeacherById(2);
        System.out.println(teacher1);


        sqlSession.close();

    }

    @Test
    public void test3()
    {
        //第一个会话

        SqlSession sqlSession = sqlSessionFactory.openSession();
        TeacherDAO teacherDAO = sqlSession.getMapper(TeacherDAO.class);


        Teacher teacher = teacherDAO.getTeacherById(1);
        System.out.println(teacher);
        System.out.println("========================================");

        //执行任何一个增删改操作
        Teacher teacher2 = new Teacher();
        teacher2.setId(3);
        teacher2.setName("33333");
        teacherDAO.updateTeacher(teacher2);

        System.out.println("========================================");
        Teacher teacher1 = teacherDAO.getTeacherById(2);
        System.out.println(teacher1);

        sqlSession.commit();
        sqlSession.close();

    }

}

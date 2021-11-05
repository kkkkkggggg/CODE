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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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

    @Test
    public void test()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try
        {
            TeacherDAO teacherDAO = sqlSession.getMapper(TeacherDAO.class);
            Teacher teacher = new Teacher();
            teacher.setId(2);
            teacher.setName("kkkkk");
            // teacher.setAddress("kkkkk");
            // // teacher.setBirth(new Date());
            // List<Teacher> teachers = teacherDAO.getTeacherByCondition(teacher);
            //
            //

            // List<Teacher> teachers = teacherDAO.getTeacherByIdIn(Arrays.asList(1,2,3,4));
            // System.out.println(teachers);

            // List<Teacher> teachers = teacherDAO.getTeacherByConditionChoose(teacher);
            // System.out.println(teachers);
            int i = teacherDAO.updateTeacher(teacher);
            System.out.println(i);
        } finally
        {
            sqlSession.commit();
            sqlSession.close();

        }


    }
}

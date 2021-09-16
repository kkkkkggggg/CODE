package com.atck.test;

import com.atck.bean.Teacher;
import com.atck.service.TeacherService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DAOTest
{
    @Test
    public void test()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        Object sqlSessionFactoryBean = context.getBean("sqlSessionFactoryBean");
        System.out.println(sqlSessionFactoryBean);

    }

    @Test
    public void test2()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        TeacherService teacherService = context.getBean("teacherService", TeacherService.class);
        Teacher teacher = teacherService.getTeacherById(1);
        System.out.println(teacher);
    }


}

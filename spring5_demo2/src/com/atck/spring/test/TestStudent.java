package com.atck.spring.test;

import com.atck.spring.collectiontype.Book;
import com.atck.spring.collectiontype.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStudent
{
    @Test
    public void test()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        Student student = context.getBean("student", Student.class);

        System.out.println(student);
    }

    @Test
    public void test1()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");

        Book book = context.getBean("book", Book.class);

        System.out.println(book);
    }
}

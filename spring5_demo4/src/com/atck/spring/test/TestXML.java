package com.atck.spring.test;

import com.atck.spring.aopxml.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestXML
{
    @Test
    public void testXML()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");

        Book book = context.getBean("book", Book.class);

        book.buy();
    }
}

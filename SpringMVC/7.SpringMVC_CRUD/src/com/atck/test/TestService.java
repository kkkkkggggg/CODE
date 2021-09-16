package com.atck.test;

import com.atck.pojo.Book;
import com.atck.service.CRUDService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.List;

public class TestService
{
    ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

    @Test
    public void test01()
    {


        CRUDService bean = context.getBean(CRUDService.class);


        // Book book = bean.queryBookById(1);
        // System.out.println(book);

        // bean.deleteBook(25);

        // bean.addBook(new Book(null,"sdais","asldkj",new BigDecimal(78),456,798,null));

        // List<Book> books = bean.queryBooks();
        // System.out.println(books);

        Book book = bean.queryBookById(26);
        book.setStock(0);
        bean.updateBook(book);


    }
}

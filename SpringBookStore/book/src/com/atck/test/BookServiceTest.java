package com.atck.test;

import com.atck.pojo.Book;
import com.atck.pojo.Page;
import com.atck.service.BookService;
import com.atck.service.impl.BookServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookServiceTest
{
    ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
    @Test
    public void addBook()
    {
        BookService bookService = context.getBean(BookService.class);
        bookService.addBook(new Book(null,"国哥在手，天下我有","1125",new BigDecimal(10000000),1000000,0,null));
    }

    @Test
    public void deleteBookById()
    {
        BookService bookService = context.getBean(BookService.class);

        bookService.deleteBookById(22);
    }

    @Test
    public void updateBook()
    {
        BookService bookService = context.getBean(BookService.class);

        Book book = bookService.queryBookById(23);
        book.setPrice(new BigDecimal(20));

        bookService.updateBook(book);
    }

    @Test
    public void queryBookById()
    {
        BookService bookService = context.getBean(BookService.class);

        System.out.println(bookService.queryBookById(23));
    }

    @Test
    public void queryBooks()
    {
        BookService bookService = context.getBean(BookService.class);

        List<Book> books = bookService.queryBooks();
        for (Book book : books)
        {
            System.out.println(book);
        }
    }

    @Test
    public void page()
    {
        BookService bookService = context.getBean(BookService.class);

        Page<Book> page = bookService.page(1, 4);

        System.out.println(page);

        page.getItems().forEach(System.out::println);
    }

    @Test
    public void filterPage()
    {
        BookService bookService = context.getBean(BookService.class);

        Page<Book> page = bookService.filterPage(0, 100, 1, 4);

        page.getItems().forEach(System.out::println);
    }
}
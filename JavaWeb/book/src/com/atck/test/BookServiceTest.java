package com.atck.test;

import com.atck.pojo.Book;
import com.atck.pojo.Page;
import com.atck.service.BookService;
import com.atck.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookServiceTest
{
    BookService bookService = new BookServiceImpl();
    @Test
    public void addBook()
    {
        bookService.addBook(new Book(null,"国哥在手，天下我有","1125",new BigDecimal(10000000),1000000,0,null));
    }

    @Test
    public void deleteBookById()
    {
        bookService.deleteBookById(22);
    }

    @Test
    public void updateBook()
    {
        Book book = bookService.queryBookById(22);
        book.setPrice(new BigDecimal(20));

        bookService.updateBook(book);
    }

    @Test
    public void queryBookById()
    {
        System.out.println(bookService.queryBookById(22));
    }

    @Test
    public void queryBooks()
    {
        List<Book> books = bookService.queryBooks();
        for (Book book : books)
        {
            System.out.println(book);
        }
    }

    @Test
    public void page()
    {
        Page<Book> page = bookService.page(1, 4);

        System.out.println(page);

        page.getItems().forEach(System.out::println);
    }

    @Test
    public void filterPage()
    {
        Page<Book> page = bookService.filterPage(0, 100, 1, 4);

        page.getItems().forEach(System.out::println);
    }
}
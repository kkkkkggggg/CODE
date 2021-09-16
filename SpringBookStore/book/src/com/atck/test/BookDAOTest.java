package com.atck.test;

import com.atck.dao.BookDAO;
import com.atck.dao.impl.BaseDAO;
import com.atck.dao.impl.BookDAOImpl;
import com.atck.pojo.Book;
import com.atck.utils.JDBCUtils;
import com.atck.utils.WebUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;

import static org.junit.Assert.*;

public class BookDAOTest
{
    ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

    @Test
    public void addBook()
    {
        BookDAO bookDAO = context.getBean(BookDAO.class);
        int i = bookDAO.addBook(new Book(null, "大家来上课", "dhaksjd", new BigDecimal(9999), 11000000, 0, null));
        System.out.println(i);
    }

    @Test
    public void deleteBookById()
    {
        BookDAO bookDAO = context.getBean(BookDAO.class);

        int i = bookDAO.deleteBookById(21);
        System.out.println(i);
    }

    @Test
    public void updateBook()
    {
        BookDAO bookDAO = context.getBean(BookDAO.class);

        Book book = bookDAO.queryBookById(3);
        book.setName("母猪的产后护理");
        int i = bookDAO.updateBook(book);
        System.out.println(i);
    }

    @Test
    public void queryBookById()
    {
        BookDAO bookDAO = context.getBean(BookDAO.class);

        Book book = bookDAO.queryBookById(3);
        System.out.println(book);
    }

    @Test
    public void queryBooks()
    {
        BookDAO bookDAO = context.getBean(BookDAO.class);

        List<Book> books = bookDAO.queryBooks();
        for (Book book : books)
        {
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCount()
    {
        BookDAO bookDAO = context.getBean(BookDAO.class);

        System.out.println(bookDAO.queryForPageTotalCount());
    }

    @Test
    public void queryForItems()
    {
        BookDAO bookDAO = context.getBean(BookDAO.class);

        bookDAO.queryForItems(0,4).forEach(System.out::println);
        int i = WebUtils.parseInt(null, 1);
        System.out.println(i);
    }

    @Test
    public void queryForFilterPriceCount()
    {
        BookDAO bookDAO = context.getBean(BookDAO.class);

        System.out.println(bookDAO.queryForFilterPriceCount(0, 100));
    }

    @Test
    public void queryForFilterItems()
    {
        BookDAO bookDAO = context.getBean(BookDAO.class);

        bookDAO.queryForFilterItems(13,4,0,100).forEach(System.out::println);
    }

    // @Test
    // public void test()
    // {
    //     // Connection connection = JDBCUtils.getConnection();
    //     // System.out.println(connection);
    //     // System.out.println(JDBCUtils.threadLocal.get());
    // }
}
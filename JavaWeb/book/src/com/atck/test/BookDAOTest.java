package com.atck.test;

import com.atck.dao.BookDAO;
import com.atck.dao.impl.BaseDAO;
import com.atck.dao.impl.BookDAOImpl;
import com.atck.pojo.Book;
import com.atck.utils.JDBCUtils;
import com.atck.utils.WebUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;

import static org.junit.Assert.*;

public class BookDAOTest
{
    BookDAO bookDAO = new BookDAOImpl();
    @Test
    public void addBook()
    {
        int i = bookDAO.addBook(new Book(null, "大家来上课", "dhaksjd", new BigDecimal(9999), 11000000, 0, null));
        System.out.println(i);
    }

    @Test
    public void deleteBookById()
    {
        int i = bookDAO.deleteBookById(21);
        System.out.println(i);
    }

    @Test
    public void updateBook()
    {
        Book book = bookDAO.queryBookById(3);
        book.setName("母猪的产后护理");
        int i = bookDAO.updateBook(book);
        System.out.println(i);
    }

    @Test
    public void queryBookById()
    {
        Book book = bookDAO.queryBookById(3);
        System.out.println(book);
    }

    @Test
    public void queryBooks()
    {
        List<Book> books = bookDAO.queryBooks();
        for (Book book : books)
        {
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCount()
    {
        System.out.println(bookDAO.queryForPageTotalCount());
    }

    @Test
    public void queryForItems()
    {
        // bookDAO.queryForItems(0,4).forEach(System.out::println);
        int i = WebUtils.parseInt(null, 1);
        System.out.println(i);
    }

    @Test
    public void queryForFilterPriceCount()
    {
        System.out.println(bookDAO.queryForFilterPriceCount(0, 100));
    }

    @Test
    public void queryForFilterItems()
    {
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
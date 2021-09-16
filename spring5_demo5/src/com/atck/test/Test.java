package com.atck.test;

import com.atck.dao.BookDaoImpl;
import com.atck.pojo.Book;
import com.atck.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.RowMapper;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class Test
{
    @org.junit.Test
    public void test() throws NoSuchFieldException
    {

        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        BookService bookService = context.getBean("bookService", BookService.class);

        Book book = new Book(6,"kkkkk","s");
        bookService.addBook(book);


        // bookService.updateBook(new Book(1,"kkkkksdk","b"));

        // bookService.deleteBook(1);
        // System.out.println(bookService.selectCount());

        // Book one = bookService.findOne(1);
        // System.out.println(one);

        // List<Book> bookList = bookService.findBookList();
        // System.out.println(bookList);

        // Object[] o1 = {3,"java","a"};
        // Object[] o2 = {4,"c++","b"};
        // Object[] o3 = {5,"mysql","c"};
        // List<Object[]> batchArgs = new ArrayList<>();
        // batchArgs.add(o1);
        // batchArgs.add(o2);
        // batchArgs.add(o3);
        //
        // bookService.batchAdd(batchArgs);

        // Object[] o1 = {"php","h",1};
        // Object[] o2 = {"php","h",2};
        // Object[] o3 = {"php","h",3};
        // List<Object[]> batchArgs = new ArrayList<>();
        // batchArgs.add(o1);
        // batchArgs.add(o2);
        // batchArgs.add(o3);
        // bookService.batchUpdate(batchArgs);

        // Object[] o1 = {1};
        // Object[] o2 = {2};
        // Object[] o3 = {3};
        // List<Object[]> batchArgs = new ArrayList<>();
        // batchArgs.add(o1);
        // batchArgs.add(o2);
        // batchArgs.add(o3);
        // bookService.batchDelete(batchArgs);
    }
}

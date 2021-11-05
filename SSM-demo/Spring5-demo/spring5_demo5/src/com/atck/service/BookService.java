package com.atck.service;

import com.atck.dao.BookDao;
import com.atck.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService
{
    //注入dao
    @Autowired
    private BookDao bookDao;

    public void addBook(Book book)
    {
        bookDao.add(book);
    }

    public void updateBook(Book book)
    {
        bookDao.update(book);
    }

    public void deleteBook(Integer id)
    {
        bookDao.delete(id);
    }

    public Integer selectCount()
    {
        return bookDao.selectCount();
    }

    public Book findOne(Integer id)
    {
        return bookDao.findBookInfo(id);
    }

    public List<Book> findBookList()
    {
        return bookDao.queryBookList();
    }

    public void batchAdd(List<Object[]> batchArgs)
    {


        bookDao.batchAddBook(batchArgs);
    }

    public void batchUpdate(List<Object[]> batchArgs)
    {
        bookDao.batchUpdate(batchArgs);
    }

    public void batchDelete(List<Object[]> batchArgs)
    {
        bookDao.batchDelete(batchArgs);
    }
}

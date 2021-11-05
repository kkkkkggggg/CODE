package com.atck.dao;

import com.atck.pojo.Book;

import java.util.List;

public interface BookDao
{
    void add(Book book);

    void update(Book book);

    void delete(Integer id);

    Integer selectCount();

    Book findBookInfo(Integer id);

    List<Book> queryBookList();

    void batchAddBook(List<Object[]> batchArgs);

    void batchUpdate(List<Object[]> batchArgs);

    void batchDelete(List<Object[]> batchargs);
}

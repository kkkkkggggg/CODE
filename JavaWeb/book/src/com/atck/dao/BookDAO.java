package com.atck.dao;

import com.atck.pojo.Book;

import java.util.List;

public interface BookDAO
{

    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    public int queryForPageTotalCount();

    public List<Book> queryForItems(Integer begin,Integer pageSize);

    public int queryForFilterPriceCount(Integer min,Integer max);

    public List<Book> queryForFilterItems(Integer begin,Integer pageSize,Integer min,Integer max);
}

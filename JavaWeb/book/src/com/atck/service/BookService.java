package com.atck.service;

import com.atck.pojo.Book;
import com.atck.pojo.Page;

import java.util.List;

public interface BookService
{
    public void addBook(Book book);

    public void deleteBookById(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    public Page<Book> page(Integer pageNo,Integer pageSize);

    public Page<Book> filterPage(Integer min,Integer max,Integer pageNo,Integer pageSize);


}

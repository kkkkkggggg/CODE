package com.atck.service;

import com.atck.dao.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;

@Service
public class BookService
{
    // @Qualifier("bookDAO")
    @Autowired(required = false)
    // @Resource(name = "bookDAO2")
    // @Inject
    private BookDAO bookDAO;

    public void print()
    {
        System.out.println(bookDAO);
    }

    @Override
    public String toString()
    {
        return "BookService{" + "bookDAO=" + bookDAO + '}';
    }
}

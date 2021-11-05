package com.atck.service.impl;

import com.atck.dao.BookDAO;
import com.atck.dao.impl.BookDAOImpl;
import com.atck.pojo.Book;
import com.atck.pojo.Page;
import com.atck.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService
{
    @Autowired
    private BookDAO bookDAO;

    @Override
    public void addBook(Book book)
    {
        bookDAO.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id)
    {
        bookDAO.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book)
    {
        bookDAO.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id)
    {
        return bookDAO.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks()
    {
        return bookDAO.queryBooks();
    }

    @Override
    public Page<Book> page(Integer pageNo, Integer pageSize)
    {
        Page<Book> page = new Page<>();





        //设置每页显示的数量
        page.setPageSize(pageSize);
        //设置总记录数
        Integer pageTotalCount = bookDAO.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);
        //设置总页码
        int pageTotal = pageTotalCount % pageSize > 0 ? pageTotalCount / pageSize + 1 : pageTotalCount / pageSize ;
        page.setPageTotal(pageTotal);


        //设置当前页码
        page.setPageNo(pageNo);

        //设置当前页数据
        int begin = (pageNo - 1) * pageSize;
        List<Book> books = bookDAO.queryForItems(begin,pageSize);
        page.setItems(books);
        return page;
    }

    @Override
    public Page<Book> filterPage(Integer min, Integer max, Integer pageNo, Integer pageSize)
    {
        Page<Book> page = new Page<>();



        //设置每页显示的数量
        page.setPageSize(pageSize);
        //设置总记录数
        Integer pageTotalCount = bookDAO.queryForFilterPriceCount(min,max);
        page.setPageTotalCount(pageTotalCount);
        //设置总页码
        int pageTotal = pageTotalCount % pageSize > 0 ? pageTotalCount / pageSize + 1 : pageTotalCount / pageSize ;
        page.setPageTotal(pageTotal);


        //设置当前页码
        page.setPageNo(pageNo);

        //设置当前页数据
        int begin = (pageNo - 1) * pageSize;
        List<Book> books = bookDAO.queryForFilterItems(begin,pageSize,min,max);
        page.setItems(books);
        return page;
    }
}

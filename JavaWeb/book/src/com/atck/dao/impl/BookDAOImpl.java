package com.atck.dao.impl;

import com.atck.dao.BookDAO;
import com.atck.pojo.Book;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

public class BookDAOImpl extends BaseDAO implements BookDAO
{

    @Override
    public int addBook(Book book)
    {
        String sql = "insert into t_book(`name`,`author`,`price`,`sales`,`stock`,`img_path`) values(?,?,?,?,?,?)";

        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath());

    }

    @Override
    public int deleteBookById(Integer id)
    {
        String sql = "delete from t_book where id = ?";
        return update(sql,id);
    }

    @Override
    public int updateBook(Book book)
    {
        String sql = "update t_book set `name` = ?,`author` = ?,`price` = ?,`sales` = ?,`stock` = ?,`img_path` =? where `id` = ?";

        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath(),book.getId());
    }

    @Override
    public Book queryBookById(Integer id)
    {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath from t_book where `id` = ?";

        return queryForOne(Book.class,sql,id);
    }

    @Override
    public List<Book> queryBooks()
    {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath from t_book";
        return queryForList(Book.class,sql);
    }

    @Override
    public int queryForPageTotalCount()
    {
        String sql = "select count(*) from t_book";
        Number number = (Number) queryForSingleValue(sql);
        return number.intValue();
    }

    @Override
    public List<Book> queryForItems(Integer begin,Integer pageSize)
    {
        String sql = "select `id`,`name`,`price`,`author`,`sales`,`stock`,`img_path` imgPath from t_book limit ?,?";
        return queryForList(Book.class,sql,begin,pageSize);
    }

    @Override
    public int queryForFilterPriceCount(Integer min, Integer max)
    {
        String sql = "select count(*) from t_book where price between ? and ?";
        Number number = (Number) queryForSingleValue(sql, min, max);
        return number.intValue();
    }

    @Override
    public List<Book> queryForFilterItems(Integer begin, Integer pageSize, Integer min, Integer max)
    {
        String sql = "select `id`,`name`,`price`,`author`,`sales`,`stock`,`img_path` imgPath from t_book where `price` between ? and ? order by price limit ?,?";

        return queryForList(Book.class,sql,min,max,begin,pageSize);
    }
}

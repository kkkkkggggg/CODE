package com.atck.dao;

import com.atck.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.swing.tree.RowMapper;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao
{
    //注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void add(Book book)
    {
        String sql = "insert into t_book values(?,?,?)";
        jdbcTemplate.update(sql,book.getUserId(),book.getUserName(),book.getuStatus());
    }

    @Override
    public void update(Book book)
    {
        String sql = "update t_book set username = ?,ustatus = ? where user_id = ?";
        jdbcTemplate.update(sql,book.getUserName(),book.getuStatus(),book.getUserId());
    }

    @Override
    public void delete(Integer id)
    {
        String sql = "delete from t_book where user_id = ?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public Integer selectCount()
    {
        String sql = "select count(*) from t_book";

        return jdbcTemplate.queryForObject(sql,Integer.class);
    }

    @Override
    public Book findBookInfo(Integer id)
    {
        String sql = "select user_id userId,username userName,ustatus uStatus from t_book where user_id = ?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Book>(Book.class),id);
    }

    @Override
    public List<Book> queryBookList()
    {
        String sql = "select user_id userId from t_book";

        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Book>(Book.class));
    }

    @Override
    public void batchAddBook(List<Object[]> batchArgs)
    {
        String sql = "insert into t_book values(?,?,?)";
        jdbcTemplate.batchUpdate(sql,batchArgs);
    }

    @Override
    public void batchUpdate(List<Object[]> batchArgs)
    {
        String sql = "update t_book set username = ?,ustatus = ? where user_id = ?";

        jdbcTemplate.batchUpdate(sql,batchArgs);
    }

    @Override
    public void batchDelete(List<Object[]> batchargs)
    {
        String sql = "delete from t_book where user_id = ?";
        jdbcTemplate.batchUpdate(sql,batchargs);
    }


}

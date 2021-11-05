package com.atck.service;

import com.atck.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CRUDService
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int updateBook(Book book)
    {
        String sql = "update t_book set name=?,price=?,author=?,sales=?,stock=? where id =?";
        return jdbcTemplate.update(sql,book.getName(),book.getPrice(),book.getAuthor(),book.getSales(),book.getStock(),book.getId());
    }

    public int deleteBook(Integer id)
    {
        String sql = "delete from t_book where id = ?";
        return jdbcTemplate.update(sql,id);
    }

    public int  addBook(Book book)
    {
        String sql = "insert into t_book(name,price,author,sales,stock,img_path) values(?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,book.getName(),book.getPrice(),book.getAuthor(),book.getSales(),book.getStock(),book.getImgPath());
    }

    public Book queryBookById(Integer id)
    {
        String sql = "select id,name,price,author,sales,stock,img_path imgPath from t_book where id = ?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Book>(Book.class),id);
    }

    public List<Book> queryBooks()
    {
        String sql = "select id,name,price,author,sales,stock,img_path imgPath from t_book";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Book>(Book.class));
    }


}

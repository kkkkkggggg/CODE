package com.atck.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.atck.dao.impl.BaseDAO;
import com.atck.pojo.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

public class BaseDAOTest
{
    ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

    BaseDAO baseDao = context.getBean("baseDAO", BaseDAO.class);

    @Test
    public void test()
    {

        String sql = "select count(*) from t_book";
        Object o = baseDao.queryForSingleValue(sql);
        System.out.println(o);
    }

    @Test
    public void test1() throws SQLException
    {

        String sql = "select id,name,price,author,sales,stock from t_book where id = ?";
        Book book = baseDao.queryForOne(Book.class, sql, 1);
        System.out.println(book);


    }

    @Test
    public void test2() throws SQLException
    {
        String sql = "update t_book set price = ? where id = ?";
        baseDao.update(sql,85,1);

    }

    @Test
    public void test3() throws SQLException
    {
        String sql = "select id,name,price,author,sales,stock,img_path imgPath from t_book";
        List<Book> books = baseDao.queryForList(Book.class,sql);
        System.out.println(books);
    }


}

package com.atck.dao.impl;

import com.atck.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public abstract class BaseDAO
{
    //使用DbUtils操作数据库
    // private QueryRunner qr = new QueryRunner();

    //使用jdbcTemplate操作数据库
    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
     * update() 方法用来执行：insert、update、delete语句
     * @return 如果返回-1说明执行失败，执行成功则返回该sql语句影响的行数
     */
    public int update(String sql,Object ... args)
    {
        return jdbcTemplate.update(sql,args);
    }

    /**
     * 查询返回一个javabean的sql语句
     * @param type 返回的对象类型
     * @param sql 执行的sql语句
     * @param args sql对应的参数值
     * @param <T> 返回的类型的泛型
     * @return 返回null代表执行失败
     */
    public <T> T queryForOne(Class<T> type,String sql,Object ... args)
    {
        T object = null;
        try
        {
            object = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<T>(type),args);
        } catch (DataAccessException e)
        {

        }
        return object;
    }

    /**
     查询返回多个javabean的sql语句
     * @param type 返回的对象类型
     * @param sql 执行的sql语句
     * @param args sql对应的参数值
     * @param <T> 返回的类型的泛型
     * @return 返回null代表执行失败
     */
    public <T> List<T> queryForList(Class<T> type,String sql,Object ... args)
    {
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(type),args);
    }

    /**
     * 查询返回返回一行一列的sql语句
     * @param sql 执行的sql语句
     * @param args sql对应的参数值
     * @return
     */
    public Object queryForSingleValue(String sql,Object ... args)
    {
        return jdbcTemplate.queryForObject(sql,Object.class,args);
    }
}

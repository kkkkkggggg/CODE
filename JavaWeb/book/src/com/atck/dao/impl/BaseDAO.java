package com.atck.dao.impl;

import com.atck.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDAO
{
    //使用DbUtils操作数据库
    private QueryRunner qr = new QueryRunner();

    /**
     * update() 方法用来执行：insert、update、delete语句
     * @return 如果返回-1说明执行失败，执行成功则返回该sql语句影响的行数
     */
    public int update(String sql,Object ... args)
    {


        Connection conn = JDBCUtils.getConnection();


        try
        {
            return qr.update(conn,sql,args);
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }/*finally
        {
            JDBCUtils.closeResource(conn);
        }*/

        // return -1;
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
        Connection conn = JDBCUtils.getConnection();


        try
        {
            return qr.query(conn,sql,new BeanHandler<T>(type),args);
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }/*finally
        {
            JDBCUtils.closeResource(conn);
        }*/

        // return null;
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
        Connection conn = JDBCUtils.getConnection();



        try
        {
            return qr.query(conn,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }/*finally
        {
            JDBCUtils.closeResource(conn);
        }*/

        // return null;
    }

    /**
     * 查询返回返回一行一列的sql语句
     * @param sql 执行的sql语句
     * @param args sql对应的参数值
     * @return
     */
    public Object queryForSingleValue(String sql,Object ... args)
    {
        Connection conn = JDBCUtils.getConnection();

        try
        {
            return qr.query(conn,sql,new ScalarHandler<>(),args);
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }/*finally
        {
            JDBCUtils.closeResource(conn);
        }*/

        // return null;
    }
}

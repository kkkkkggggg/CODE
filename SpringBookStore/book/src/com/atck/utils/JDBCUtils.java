package com.atck.utils;

import com.alibaba.druid.pool.*;
import org.apache.commons.dbutils.DbUtils;


import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

@Deprecated
public class JDBCUtils
{
    /**
     * 获取mysql数据库连接
     * @return
     * @throws Exception
     */
//    public static Connection getConnection() throws Exception
//    {
//        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
//
//        Properties pro = new Properties();
//
//        pro.load(is);
//
//        String user = pro.getProperty("user");
//        String password = pro.getProperty("password");
//        String url = pro.getProperty("url");
//        String driverClass = pro.getProperty("driverClass");
//        System.out.println(user);
//
//        Connection conn = DriverManager.getConnection(url, user, password);
//
//        return conn;
//    }

    /**
     * 在静态代码块中获取durid.properties中的配置文件，存储到source中
     */
    private static DruidDataSource source;
    private static ThreadLocal<Connection> conns = new ThreadLocal<>();
    static
    {
        try
        {
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("durid.properties");

            Properties pros = new Properties();

            pros.load(is);

            source = (DruidDataSource) DruidDataSourceFactory.createDataSource(pros);

        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }



/**
 * 使用Durid数据库连接池获取数据库连接
 * @return 如果返回null，说明获取连接失败
 */
    public static Connection getConnection()
    {
        Connection conn = conns.get();
        if (conn == null)
        {
            try
            {
                conn = source.getConnection();//从数据库连接池中获取连接
                conns.set(conn);//保存到ThreadLocal对象中，供后面的JDBCUtils使用
                conn.setAutoCommit(false);//设置手动管理事务

            } catch (SQLException e)
            {

                e.printStackTrace();
            }
        }

        return conn;

    }

    /**
     * 提交事务，并关闭释放连接
     */
    public static void commitAndClose()
    {
        Connection conn = conns.get();
        if (conn != null)//如果不等于null，说明之前使用过连接，操作过数据库
        {
            try
            {
                conn.commit();//提交事务
            } catch (SQLException e)
            {
                e.printStackTrace();
            }finally
            {
                try
                {
                    conn.close();//关闭连接，释放资源
                } catch (SQLException e)
                {
                    e.printStackTrace();
                }

            }
        }
        //一定要执行remove操作，否则一定会操作（因为tomcat服务器底层使用了线程池技术）
        conns.remove();
    }

    /**
     * 回滚事务，并关闭释放连接
     */
    public static void rollbackAndClose()
    {
        Connection conn = conns.get();
        if (conn != null)//如果不等于null，说明之前使用过连接，操作过数据库
        {
            try
            {
                conn.rollback();//回滚事务
            } catch (SQLException e)
            {
                e.printStackTrace();
            }finally
            {
                try
                {
                    conn.close();//关闭连接，释放资源
                } catch (SQLException e)
                {
                    e.printStackTrace();
                }

            }
        }
        //一定要执行remove操作，否则一定会操作（因为tomcat服务器底层使用了线程池技术）
        conns.remove();
    }

    // /**
    //  * 放回数据库连接池
    //  */
    // public void putback(Connection conn)
    // {
    //
    // }


    // /**
    //  * 关闭连接和Statement
    //  * @param conn
    //  *
    //  */
    // public static void closeResource(Connection conn)
    // {
    //
    //     try
    //     {
    //         if(conn != null)
    //             conn.close();
    //     } catch (SQLException e)
    //     {
    //         // TODO Auto-generated catch block
    //         e.printStackTrace();
    //     }
    //
    //
    // }


}

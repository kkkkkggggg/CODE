package com.ck4.jdbc.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.Statement;

public class JDBCUtils
{
	private static ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");
	/**
	 * ʹ��C3P0�����ݿ����ӳؼ���
	 * @return
	 */
	public static Connection getConnection()
	{
		try
		{
			Connection conn = cpds.getConnection();
			return conn;
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	/**
	 * ʹ��DBCP���ݿ����ӳؼ�����ȡ���ݿ�����
	 * @return
	 * @throws Exception
	 */
	private static DataSource dataSource;
	static
	{
		try
		{
			FileInputStream is = new FileInputStream(new File("src/dbcp.properties"));
			
			Properties pros = new Properties();
			pros.load(is);
			
			dataSource = BasicDataSourceFactory.createDataSource(pros);
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	
	public static Connection getConnection1() throws Exception
	{
		
		
		
		Connection conn = dataSource.getConnection();
		return conn;
		
	}
	
	
	private static DataSource source;
	static
	{
		try
		{
			InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("durid.properties");
			
			Properties pros = new Properties();
			
			pros.load(is);
			
			source = DruidDataSourceFactory.createDataSource(pros);
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
	 * ʹ��Durid���ݿ����ӳؼ�����ȡ���ݿ�
	 * @return
	 */
	public static Connection getConnection2()
	{
		
		
		Connection conn = null;
		try
		{
			conn = source.getConnection();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	/**
	 * ʹ��dbutils.jar���ṩ��Dbutils�����࣬ʵ����Դ�Ĺر�
	 * 
	 * 
	 */
	
	public static void closeResource(Connection conn,Statement ps,ResultSet rs)
	{
//		try
//		{
//			DbUtils.close(conn);
//		} catch (SQLException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try
//		{
//			DbUtils.close(rs);
//		} catch (SQLException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try
//		{
//			DbUtils.close(ps);
//		} catch (SQLException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		DbUtils.closeQuietly(conn);
		DbUtils.closeQuietly(ps);
		DbUtils.closeQuietly(rs);
		
		
		
		
	}
}

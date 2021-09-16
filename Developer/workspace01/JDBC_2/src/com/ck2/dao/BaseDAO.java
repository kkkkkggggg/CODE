package com.ck2.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ck0.jdbc.utils.JDBCUtils;

/*
 * DAO:data(base) access object
 * 封装了针对于数据表的通用的操作
 */
public abstract class BaseDAO
{
	//通用的增删改操作---version 2.0(考虑数据库事务)
	public int update(Connection conn,String sql,Object ... obj)
	{
		
		//1.获取PreparedStatement的实例
		java.sql.PreparedStatement ps = null;
		try {
			
			ps = conn.prepareStatement(sql);
			
			
			if(obj.length == 0)
			{
				//如果没有占位符则直接执行操作
				//3.执行操作
				return ps.executeUpdate();
			}else
			{
				//如果有占位符，则填充占位符
				//2.填充占位符
				for(int i = 0;i < obj.length;i++)
				{
					ps.setObject(i+1, obj[i]);
				}
				
				return ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			//4.关闭资源
			JDBCUtils.closeResource(null, ps);
		}
		
		return 0;
	}
	
	
	/**
	 * 针对于不同的表的通用的查询操作，返回表中的一条记录 version 2.0 考虑了事务
	 * @param clazz
	 * @param sql
	 * @param args
	 * @return
	 */
	public  <T> T getInstance(Connection conn,Class<T> clazz,String sql,Object ...args)
	{
		
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			//获取prepareStatement实例
			ps = conn.prepareStatement(sql);
			
			//填充占位符
			for(int i = 0;i < args.length;i++)
			{
				ps.setObject(i + 1, args[i]);
			}
			//执行sql语句
			resultSet = ps.executeQuery();
			
			if(resultSet.next())
			{
				
				//获取resultSet元数据，再通过元数据获取查询的字段名和字段个数
				ResultSetMetaData rsmd = ps.getMetaData();
				int columnCount = rsmd.getColumnCount();
				
				
				T t = clazz.newInstance();
				
				for (int i = 1; i <= columnCount; i++)
				{
					//获取对应索引位置的字段值
					Object columnValue = resultSet.getObject(i);
					
					//获取列的列名getColumnName,不推荐使用
//					String columnName = rsmd.getColumnName(i);
					
					//获取列的别名getColumnLabel
					String columnLabel = rsmd.getColumnLabel(i);
					
					//通过反射方式获取与字段名对应的Order类的属性名
					
					
					Field field = clazz.getDeclaredField(columnLabel);
					field.setAccessible(true);
					
					
					
					//通过反射为order的属性赋值
					field.set(t, columnValue);
					
				}
				
				return t;
				
			}
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtils.closeResource(null, ps, resultSet);
		}
		
		
		return null;
	}
	
	/**
	 * 针对于不同的表的通用的查询操作，返回表中的多条记录
	 * @param clazz
	 * @param sql
	 * @param args
	 * @return
	 */
	public <T> List<T>  getMutilyInstance(Connection conn,Class<T> clazz,String sql,Object ...args)
	{
		
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			//创建list存储多条记录
			List<T> list = new ArrayList();
			//获取连接
			
			
			
			//获取prepareStatement实例
			ps = conn.prepareStatement(sql);
			
			//填充占位符
			for(int i = 0;i < args.length;i++)
			{
				ps.setObject(i + 1, args[i]);
			}
			//执行sql语句
			resultSet = ps.executeQuery();
			
			//获取resultSet元数据，再通过元数据获取查询的字段名和字段个数
			ResultSetMetaData rsmd = ps.getMetaData();
			int columnCount = rsmd.getColumnCount();
			
			while(resultSet.next())
			{
				T t = clazz.newInstance();
				
				for (int i = 1; i <= columnCount; i++)
				{
					//获取对应索引位置的字段值
					Object columnValue = resultSet.getObject(i);
					
					//获取列的列名getColumnName,不推荐使用
//					String columnName = rsmd.getColumnName(i);
					
					//获取列的别名getColumnLabel
					String columnLabel = rsmd.getColumnLabel(i);
					
					//通过反射方式获取与字段名对应的Order类的属性名
					
					
					Field field = clazz.getDeclaredField(columnLabel);
					field.setAccessible(true);
					
					
					
					//通过反射为order的属性赋值
					field.set(t, columnValue);
					
				}
				
				list.add(t);
			}
			
			
			return list;			
			
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtils.closeResource(null, ps, resultSet);
		}
		
		
		return null;
	}
	
	
	
	public <T> T  getValue(Connection conn,String sql,Object ... args)
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		try
		{
			ps = conn.prepareStatement(sql);
			
			
			for(int i = 0;i < args.length;i++)
			{
				ps.setObject(i + 1, args[i]);
			}
			
			rs = ps.executeQuery();
			
			if(rs.next())
			{
				return (T) rs.getObject(1);
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtils.closeResource(null, ps, rs);
		}
		
		return null; 
		
	}
	
	
}

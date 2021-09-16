package com.ck1.transaction;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ck0.jdbc.utils.Customer;
import com.ck0.jdbc.utils.JDBCUtils;
import com.ck0.jdbc.utils.User;
/*
 * 1.什么叫数据库事务
 * 事务：一组洛基操作单元，使数据从一种状态变换到另一种状态
 * 		>一组逻辑操作单元，一个或多个DML操作
 * 
 * 2.事务处理的原则：保证所有事务都作为一个工作单元来执行，即使出
 * 现了故障，都不能改变这种执行方式。当在一个事务中执行多个操作时，
 * 要么所有的事务都被提交(commit)，那么这些修改就永久地保存下
 * 来；要么数据库管理系统将放弃所作的所有修改，整个事务回滚(rollback)到最初状态。
 * 
 * 3.数据一旦提交，就不可回滚
 * 
 * 4.哪些操作会导致数据的自动提交
 * 		>DDL操作一旦执行，都会自动提交
 * 			>set autocommit = 0;对DDL操作失效
 * 		>DML操作默认情况下，一旦执行会自动提交
 * 			>我们可以通过set autocommit = 0;的方式取消DML的自动提交
 * 		>在关闭连接时，会将没有提交的数据进行自动提交
 */
public class TransactionTest
{
	
	
	//*********************************未考虑数据库事物的转账操作*****************************************
	/*
	 * 针对于数据表User_table来说
	 * AA用户给BB用户转账100
	 * 
	 * AA用户的余额减100 update user_table set balance = balance - 100 where user = 'AA'
	 * BB用户的余额加100 update user_table set balance = balance + 100 where user = 'BB'
	 */
	@Test
	public void test() throws Exception
	{
		String sql = "update user_table set balance = balance - 100 where user = ?";
		CUD(sql,"AA");
		
		//模拟网络异常
		System.out.println(10 / 0);
		
		String sql1 = "update user_table set balance = balance + 100 where user = ?";
		CUD(sql1,"BB");
		
		System.out.println("转账成功");
	}
	
	
	
	//通用的增删改操作---version 1.0
		public int CUD(String sql,Object ... obj)
		{
			//1.获取连接
			Connection conn = null;
			//2.获取PreparedStatement的实例
			java.sql.PreparedStatement ps = null;
			try {
				conn = JDBCUtils.getConnection();
				ps = conn.prepareStatement(sql);
				
				
				if(obj.length == 0)
				{
					//如果没有占位符则直接执行操作
					//4.执行操作
					return ps.executeUpdate();
				}else
				{
					//如果有占位符，则填充占位符
					//3.填充占位符
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
				//5.关闭资源
				JDBCUtils.closeResource(conn, ps);
			}
			
			return 0;
		}
		
		//*************************************考虑数据库事务的转账操作***************************************************
		@Test
		public void test1()
		{
			Connection conn = null;
			try
			{
				conn = JDBCUtils.getConnection();
				
				//取消数据的自动 提交功能
				conn.setAutoCommit(false);
				
				
				String sql = "update user_table set balance = balance - 100 where user = ?";
				CUD(conn,sql,"AA");
				
				//模拟网络异常
				System.out.println(10 / 0);
				
				String sql1 = "update user_table set balance = balance + 100 where user = ?";
				CUD(conn,sql1,"BB");
				
			
				
				System.out.println("转账成功");
				
				//提交数据
				conn.commit();
			} catch (Exception e)
			{
				
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				//回滚数据
				try
				{
					conn.rollback();
				} catch (SQLException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}finally
			{
				
				//修改其为自动提交数据
				//主要针对数据库连接池的使用
				
				try
				{
					conn.setAutoCommit(true);
				} catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//资源关闭
				JDBCUtils.closeResource(conn, null);
			}
			
			
			
		}
		
		
		//通用的增删改操作---version 2.0(考虑数据库事务)
			public int CUD(Connection conn,String sql,Object ... obj)
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
			
			@Test
			public void testTransactionUpdate() throws Exception
			{
				Connection conn = JDBCUtils.getConnection();
				
				
				
				//取消自动提交数据
				conn.setAutoCommit(false);
				
				String sql = "update user_table set balance = 800 where user = ?";
				
				CUD(conn,sql,"AA");
				
				Thread.sleep(15000);
				
				System.out.println("修改结束");
				
			}
			
			
			@Test
			public void testTransactionSelect() throws Exception
			{
				Connection conn = JDBCUtils.getConnection();
				
				//设置数据库的事务隔离级别
				conn.setTransactionIsolation(conn.TRANSACTION_READ_UNCOMMITTED);      
				
				//获取当前连接的隔离级别
				System.out.println(conn.getTransactionIsolation());
				
				//取消自动提交数据
				conn.setAutoCommit(false);
				
				
				String sql = "select user,password,balance from user_table where user = ?";
				User instance = getInstance(conn,User.class,sql,"AA");
				
				System.out.println(instance);
				
				
				
					
			}
			
			//***********************************************************************
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
//							String columnName = rsmd.getColumnName(i);
							
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
		
}

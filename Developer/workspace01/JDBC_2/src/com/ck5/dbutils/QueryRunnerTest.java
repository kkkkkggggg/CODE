package com.ck5.dbutils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.ck0.jdbc.utils.Customer;
import com.ck4.jdbc.utils.JDBCUtils;

/*
 * commons_dbutils是Apache组织提供的一个开源的JDBC工具类库，封装了针对于数据库的增删改查操作
 * 
 */
public class QueryRunnerTest
{
	@Test
	public void test() throws Exception
	{
		QueryRunner runner = new QueryRunner();
		Connection conn = JDBCUtils.getConnection2();
		String sql = "delete from customers where id = ?";
		runner.update(conn, sql,24);
	}
	
	
	//测试查询
	/*
	 * BeanHandler是ResultSetHandler的实现类，用于封装表中的一条记录
	 */
	@Test
	public void test1()
	{
		Customer query = null;
		Connection conn = null;
		try
		{
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getConnection2();
			
			String sql = "select id,name,email,birth from customers where id = ?";
			
			BeanHandler<Customer> handler = new BeanHandler<Customer>(Customer.class);
			
			query = runner.query(conn, sql, handler,25);
			System.out.println(query);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			com.ck0.jdbc.utils.JDBCUtils.closeResource(conn, null);
		}
		
		
	}
	
	/*
	 * BeanListHandler,用于封装表中的多条记录构成的集合
	 */
	@Test
	public void test2()
	{
		List<Customer> list = null;
		Connection conn = null;
		try
		{
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getConnection2();
			
			String sql = "select id,name,email,birth from customers where id < ?";
			
			BeanListHandler<Customer> handler = new BeanListHandler<Customer>(Customer.class);
			
			list = runner.query(conn, sql, handler,15);
			list.forEach(System.out::println);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			com.ck0.jdbc.utils.JDBCUtils.closeResource(conn, null);
		}
		
	}
	
	//MapHandler:是ResultSetHandler接口的实现类，对应表中的一条记录，将字段及字段的值作为map中的key和value
	@Test
	public void test3()
	{
		
		Connection conn = null;
		try
		{
			QueryRunner runner = new QueryRunner();
			conn = JDBCUtils.getConnection2();
			
			String sql = "select id,name,email,birth from customers where id = ?";
			
			MapHandler handler = new MapHandler();
			
			Map<String, Object> query = runner.query(conn, sql, handler,16);
//			Set<Entry<String,Object>> set = query.entrySet();
//			
//			
//			set.forEach(System.out::println);'
			
			System.out.println(query);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			com.ck0.jdbc.utils.JDBCUtils.closeResource(conn, null);
		}
		
	}
	
	
	//MapListHandler:是ResultSetHandler接口的实现类,对应表中的多条记录，将字段及字段的值作为map中的key和value，将这些map添加到list中
		@Test
		public void test4()
		{
			
			Connection conn = null;
			try
			{
				QueryRunner runner = new QueryRunner();
				conn = JDBCUtils.getConnection2();
				
				String sql = "select id,name,email,birth from customers where id < ?";
				
				MapListHandler handler = new MapListHandler();
				
				List<Map<String,Object>> list = runner.query(conn, sql, handler,16);
				
				list.forEach(System.out::println);
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
			{
				com.ck0.jdbc.utils.JDBCUtils.closeResource(conn, null);
			}
			
		}
		
		@Test
		public void test5()
		{
			
			Connection conn = null;
			try
			{
				QueryRunner runner = new QueryRunner();
				conn = JDBCUtils.getConnection2();
				
				String sql = "select count(*) from customers";
				
				ScalarHandler handler = new ScalarHandler();
				
				Object object = runner.query(conn, sql, handler);
				
				System.out.println(object);
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
			{
				com.ck0.jdbc.utils.JDBCUtils.closeResource(conn, null);
			}
			
		}
		
		@Test
		public void test6()
		{
			
			Connection conn = null;
			try
			{
				QueryRunner runner = new QueryRunner();
				conn = JDBCUtils.getConnection2();
				
				String sql = "select max(birth) from customers";
				
				ScalarHandler handler = new ScalarHandler();
				
				Object object = runner.query(conn, sql, handler);
				
				System.out.println(object);
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
			{
				com.ck0.jdbc.utils.JDBCUtils.closeResource(conn, null);
			}
			
		}
		
		/*
		 * 自定义ResultSetHandler的实现类
		 */
		@Test
		public void test7()
		{
			
			Connection conn = null;
			try
			{
				QueryRunner runner = new QueryRunner();
				
				conn = JDBCUtils.getConnection2();
				String sql = "select id,name,email,birth from customers where id = ?";
				ResultSetHandler<Customer> handler = new ResultSetHandler<Customer>(){

					@Override
					public Customer handle(ResultSet rs) throws SQLException
					{
						if(rs.next())
						{
							int id = rs.getInt("id");
							String name = rs.getString("name");
							String email = rs.getString("email");
							Date birth = rs.getDate("birth");
							Customer cust = new Customer(id,name,email,birth);
							return cust;
						}
						
						return null;
						
						
						
					}};
				Customer customer = runner.query(conn, sql,handler,25);
				
				System.out.println(customer);
				
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
			{
				com.ck0.jdbc.utils.JDBCUtils.closeResource(conn, null);
			}
			
		}
		
}

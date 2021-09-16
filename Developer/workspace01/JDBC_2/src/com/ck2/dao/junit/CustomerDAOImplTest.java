package com.ck2.dao.junit;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import org.junit.Test;

import com.ck0.jdbc.utils.Customer;
import com.ck0.jdbc.utils.JDBCUtils;
import com.ck2.dao.CustomerDAOImpl;

public class CustomerDAOImplTest
{
	CustomerDAOImpl dao = new CustomerDAOImpl();

	@Test
	public void testInsert()
	{
		Connection conn = null;
		try
		{
			conn = JDBCUtils.getConnection();
			
			Customer cust = new Customer(1,"大海","dahai@qq.com",new java.sql.Date(321359685L));
			
			dao.insert(conn, cust);
			
			System.out.println("添加成功");
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtils.closeResource(conn, null);
		}
		
		
		
		
	}

	@Test
	public void testDeleteById()
	{
		Connection conn = null;
		try
		{
			conn = JDBCUtils.getConnection();
			
			dao.deleteById(conn, 23);
			
			System.out.println("删除成功");
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtils.closeResource(conn, null);
		}
	}

	@Test
	public void testUpdateById()
	{
		Connection conn = null;
		try
		{
			conn = JDBCUtils.getConnection();
			
			Customer cust = new Customer(18,"贝多芬","beiduofen@qq.com",new Date(546513265L));
			
			dao.updateById(conn, cust);
			
			System.out.println("修改成功");
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtils.closeResource(conn, null);
		}
	}

	@Test
	public void testGetCustomerById()
	{
		Connection conn = null;
		try
		{
			conn = JDBCUtils.getConnection();
			Customer customer = dao.getCustomerById(conn, 18);
			
			System.out.println("获取成功");
			System.out.println(customer);
			
			
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtils.closeResource(conn, null);
		}
	}

	@Test
	public void testGetAll()
	{
		Connection conn = null;
		try
		{
			conn = JDBCUtils.getConnection();
			
			List<Customer> list = dao.getAll(conn);
			
			System.out.println("获取成功");
			
			list.forEach(System.out::println);
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtils.closeResource(conn, null);
		}
	}

	@Test
	public void testGetMaxBirth()
	{
		Connection conn = null;
		try
		{
			conn = JDBCUtils.getConnection();
			
			Date date = dao.getMaxBirth(conn);
			
			
			System.out.println(date);
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtils.closeResource(conn, null);
		}
	}

	@Test
	public void testGetCount()
	{
		Connection conn = null;
		try
		{
			conn = JDBCUtils.getConnection();
			long count = dao.getCount(conn);
			
			
			System.out.println(count);
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtils.closeResource(conn, null);
		}
	}

}

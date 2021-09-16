package preparedstatement.crud_03;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import bean.Customer;
import jdbc.util.JDBCUtils;

/**
 * 使用PreparedStatement实现针对于不同表的通用查询操作,返回表中的一条记录
 * @author kkkkk
 *
 */
public class PreparedStatementQueryTest
{
	
	@Test
	public void test()
	{
		String sql = "select id,name,email from customers where id = ?";
		Customer instance = getInstance(Customer.class,sql,1);
		
		System.out.println(instance);
		
		String sql1 = "select order_id orderId,order_name orderName from `order` where order_id = ?";
		Order instance2 = getInstance(Order.class,sql1,1);
		
		System.out.println(instance2);
	}
	
	
	@Test
	public void test1()
	{
		String sql = "select id,name,email from customers where id > ?";
		List<Customer> list = getMutilyInstance(Customer.class,sql,1);
		
//		Iterator<Customer> iterator = list.iterator();
//		
//		while(iterator.hasNext())
//		{
//			System.out.println(iterator.next());
//		}
		
		list.forEach(System.out::println);
	}
	
	/**
	 * 针对于不同的表的通用的查询操作，返回表中的多条记录
	 * @param clazz
	 * @param sql
	 * @param args
	 * @return
	 */
	public <T> List<T>  getMutilyInstance(Class<T> clazz,String sql,Object ...args)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			//创建list存储多条记录
			List<T> list = new ArrayList();
			//获取连接
			conn = JDBCUtils.getConnection();
			
			
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
			JDBCUtils.closeResource(conn, ps, resultSet);
		}
		
		
		return null;
	}
	
	
	/**
	 * 针对于不同的表的通用的查询操作，返回表中的一条记录
	 * @param clazz
	 * @param sql
	 * @param args
	 * @return
	 */
	public  <T> T getInstance(Class<T> clazz,String sql,Object ...args)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			
			//获取连接
			conn = JDBCUtils.getConnection();
			
			
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
			JDBCUtils.closeResource(conn, ps, resultSet);
		}
		
		
		return null;
	}
}

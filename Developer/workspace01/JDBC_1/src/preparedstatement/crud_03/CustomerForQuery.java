package preparedstatement.crud_03;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.junit.Test;

import bean.Customer;
import jdbc.util.JDBCUtils;
import java.lang.*;
/**
 * 针对于Customers表的查询操作
 * @author kkkkk
 *
 */

public class CustomerForQuery 
{
	/**
	 * 针对customers表的通用查询操作
	 * @throws Exception 
	 */
	//我写的版本
	public void queryForCustomer(String sql,int columnCount,Object ... args) throws Exception
	{
		Connection conn = JDBCUtils.getConnection();
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		
		if(args.length != 0)
		{
			for(int i = 0;i < args.length;i++)
			{
				ps.setObject(i + 1,args[i]);
			}
		}
		
		ResultSet resultSet = ps.executeQuery(sql);
		
		if(columnCount < 1)
		{
			System.out.println("请输入正确的查询字段数");
		}else
		{
			
			while(resultSet.next())
			{
				for(int x = 1;x <= columnCount;x++)
				{
					System.out.print(resultSet.getObject(x) + "\t\t");
				}
				System.out.println();
				
			}	
		}	
	}
	
	public Customer queryForCustomers(String sql,Object ... args)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			
			ps = conn.prepareStatement(sql);
			
			for(int i = 0;i < args.length;i++)
			{
				ps.setObject(i + 1, args[i]);
			}
			
			rs = ps.executeQuery();
			
			//获取结果集的元数据:ResultSetMetaData
			ResultSetMetaData rsmd = rs.getMetaData();
			
			//通过ResultSetMetaData获取结果集的列数
			int columnCount = rsmd.getColumnCount();
			
			if(rs.next())
			{
				Customer cust = new Customer();
				
				//处理一行数据中的每一个列
				for(int i = 0;i < columnCount;i++)
				{
					Object columnValue = rs.getObject(i + 1);
					
					//获取每个列的列名
					String columnName = rsmd.getColumnName(i + 1);
					
					//给cust对象指定的columnName属性赋值为columnValue,通过反射
					
					
					Field field = Customer.class.getDeclaredField(columnName);
					
					field.setAccessible(true);
					
					field.set(cust, columnValue);
					
				}
				
				return cust;
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
			JDBCUtils.closeResource(conn, ps, rs);
		}
		
		
		
		
		
		return null;
		
	}
	@Test
	public void test() throws Exception
	{
		String sql = "SELECT id,name,birth,email FROM customers WHERE id = ?";
		
		
		Customer customer = queryForCustomers(sql,13);
		
		System.out.println(customer);
		
		
		String sql1 = "SELECT name,email FROM customers WHERE name = ?";
		Customer customer1 = queryForCustomers(sql1,"周杰伦");
		System.out.println(customer1);
	}
	
	
	
	
	
	@Test
	public void testQuery1()
	{
		Connection conn = null;
		PreparedStatement ps = null;
		
		ResultSet resultSet = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "SELECT id,name,email,birth FROM customers WHERE id = ?";
			ps = conn.prepareStatement(sql);
			
			//填充占位符
			ps.setObject(1, 1);
			
			//执行操作,并返回结果集
			resultSet = ps.executeQuery();
			
			//处理结果集
			if(resultSet.next())//判断结果集的下一条是否有数据，如果有数据返回true，并将指针下移，如果没有数据，返回false，指针不下移
			{
				//获取当前这条数据的各个字段值
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String email = resultSet.getString(3);
				Date birth = resultSet.getDate(4);
				
				//方式一：
//			System.out.println("id = " + id + ", name = " + name + ", email = " + email + ", birth = " + birth);
				
				//方式二：
//			Object[] data = new Object[]{id,name,email,birth};
				
				//方式三：将数据封装为一个对象（推荐）
				Customer customer = new Customer(id,name,email,birth);
				System.out.println(customer);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			//关闭资源
			
			JDBCUtils.closeResource(conn, ps, resultSet);
		}
		
		
	}
	
	
	@Test
	public void test1() throws Exception
	{
		//从配置文件中读取四个基本信息
		InputStream is = Class.class.getClassLoader().getSystemResourceAsStream("jdbc.properties");
		
		Properties ps = new Properties();
		
		ps.load(is);
		
		String user = ps.getProperty("user", "root");
		String password = ps.getProperty("password", "12138970");
		String url = ps.getProperty("url", "jdbc:mysql://localhost:3306/test1");
		String driverClass = ps.getProperty("driverClass", "com.mysql.jdbc.Driver");
		
		//注册驱动
		Class.forName(driverClass);
		
		//获取连接
		Connection conn = DriverManager.getConnection(url, user, password);
		
		//获取PreparedStatement实例
		String sql = "INSERT INTO customers(name,email,birth) VALUES(?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = sdf.parse("1998-02-17");
		Date date2 = new java.sql.Date(date.getTime());
		
		//填充占位符
		pst.setObject(1, "ssh");
		pst.setObject(2, "gmail.com");
		pst.setObject(3, date);
		
		//执行操作
		pst.execute();
		
	}
	
	@Test
	public void test2()
	{
		System.out.println(Class.class.getClassLoader());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

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
 * �����Customers��Ĳ�ѯ����
 * @author kkkkk
 *
 */

public class CustomerForQuery 
{
	/**
	 * ���customers���ͨ�ò�ѯ����
	 * @throws Exception 
	 */
	//��д�İ汾
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
			System.out.println("��������ȷ�Ĳ�ѯ�ֶ���");
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
			
			//��ȡ�������Ԫ����:ResultSetMetaData
			ResultSetMetaData rsmd = rs.getMetaData();
			
			//ͨ��ResultSetMetaData��ȡ�����������
			int columnCount = rsmd.getColumnCount();
			
			if(rs.next())
			{
				Customer cust = new Customer();
				
				//����һ�������е�ÿһ����
				for(int i = 0;i < columnCount;i++)
				{
					Object columnValue = rs.getObject(i + 1);
					
					//��ȡÿ���е�����
					String columnName = rsmd.getColumnName(i + 1);
					
					//��cust����ָ����columnName���Ը�ֵΪcolumnValue,ͨ������
					
					
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
		Customer customer1 = queryForCustomers(sql1,"�ܽ���");
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
			
			//���ռλ��
			ps.setObject(1, 1);
			
			//ִ�в���,�����ؽ����
			resultSet = ps.executeQuery();
			
			//��������
			if(resultSet.next())//�жϽ��������һ���Ƿ������ݣ���������ݷ���true������ָ�����ƣ����û�����ݣ�����false��ָ�벻����
			{
				//��ȡ��ǰ�������ݵĸ����ֶ�ֵ
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String email = resultSet.getString(3);
				Date birth = resultSet.getDate(4);
				
				//��ʽһ��
//			System.out.println("id = " + id + ", name = " + name + ", email = " + email + ", birth = " + birth);
				
				//��ʽ����
//			Object[] data = new Object[]{id,name,email,birth};
				
				//��ʽ���������ݷ�װΪһ�������Ƽ���
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
			//�ر���Դ
			
			JDBCUtils.closeResource(conn, ps, resultSet);
		}
		
		
	}
	
	
	@Test
	public void test1() throws Exception
	{
		//�������ļ��ж�ȡ�ĸ�������Ϣ
		InputStream is = Class.class.getClassLoader().getSystemResourceAsStream("jdbc.properties");
		
		Properties ps = new Properties();
		
		ps.load(is);
		
		String user = ps.getProperty("user", "root");
		String password = ps.getProperty("password", "12138970");
		String url = ps.getProperty("url", "jdbc:mysql://localhost:3306/test1");
		String driverClass = ps.getProperty("driverClass", "com.mysql.jdbc.Driver");
		
		//ע������
		Class.forName(driverClass);
		
		//��ȡ����
		Connection conn = DriverManager.getConnection(url, user, password);
		
		//��ȡPreparedStatementʵ��
		String sql = "INSERT INTO customers(name,email,birth) VALUES(?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = sdf.parse("1998-02-17");
		Date date2 = new java.sql.Date(date.getTime());
		
		//���ռλ��
		pst.setObject(1, "ssh");
		pst.setObject(2, "gmail.com");
		pst.setObject(3, date);
		
		//ִ�в���
		pst.execute();
		
	}
	
	@Test
	public void test2()
	{
		System.out.println(Class.class.getClassLoader());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

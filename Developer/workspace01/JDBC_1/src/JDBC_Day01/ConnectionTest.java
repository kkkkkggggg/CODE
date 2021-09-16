package JDBC_Day01;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

public class ConnectionTest 
{
	//��ʽһ��
	@Test
	public void testConnection1() throws SQLException
	{
		//��ȡdriver��ʵ�������
		Driver driver = new com.mysql.jdbc.Driver();
		//jdbc:mysql:Э��
		//localhost:ip��ַ
		//3306:Ĭ��mysql�Ķ˿�
		//test1:test1���ݿ�
		String url = "jdbc:mysql://localhost:3306/test1";
		
		//���û����������װ��properties��
		Properties info = new Properties();
		info.setProperty("user", "root");
		info.setProperty("password", "12138970");
		
		Connection conn = driver.connect(url, info);
		
		System.out.println(conn);
	}
	
	//��ʽ�����Է�ʽһ�ĵ����������µĳ����в����ֵ�������api���ǵĳ�����и��õĿ���ֲ��
	
	@Test
	public void testConnection2() throws Exception
	{
		//1����ȡDriverʵ����Ķ���ʹ�÷���
		Class clazz = Class.forName("com.mysql.jdbc.Driver");
		Driver driver = (Driver) clazz.newInstance();
		
		//2���ṩҪ���ӵ����ݿ�
		String url = "jdbc:mysql://localhost:3306/test1";
		
		//3���ṩ��������Ҫ���û���������
		Properties info = new Properties();
		info.setProperty("user", "root");
		info.setProperty("password", "12138970");
		
		//4����ȡ����
		Connection conn = driver.connect(url, info);
		
		System.out.println(conn);
	}
	
	//��ʽ����ʹ��DriverManager�滻Driver
	@Test
	public void testConnection3() throws Exception
	{
		//1����ȡDriver��ʵ�������
		Class clazz = Class.forName("com.mysql.jdbc.Driver");
		Driver driver = (Driver) clazz.newInstance();
		
		//2���ṩ�����������ӵĻ�����Ϣ
		String url = "jdbc:mysql://localhost:3306/test1";
		String user = "root";
		String password = "12138970";
		
		//ע������
		DriverManager.registerDriver(driver);
		
		//��ȡ����
		Connection conn = DriverManager.getConnection(url, user, password);
		
		System.out.println(conn);
	}
	
	//��ʽ�ģ�����ֻ�Ǽ���������������ʽ��ע������
	@Test
	public void testConnection4() throws Exception
	{
		
		
		//1���ṩ�����������ӵĻ�����Ϣ
		String url = "jdbc:mysql://localhost:3306/test1";
		String user = "root";
		String password = "12138970";
		
		//2������Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//����ڷ�ʽ������ʡ�����µĲ�����
//		Driver driver = (Driver) clazz.newInstance();
//		
//		//ע������
//		DriverManager.registerDriver(driver);
		//Ϊʲô����ʡ������������
		/*
		 *��MySQL��Driverʵ�����У����������²���
		 * 	static 
		 * {
				try {
				java.sql.DriverManager.registerDriver(new Driver());
				} catch (SQLException E) {
				throw new RuntimeException("Can't register driver!");
			}
		 */
		
		//3����ȡ����
		Connection conn = DriverManager.getConnection(url, user, password);
		
		System.out.println(conn);
	}
	
	//��ʽ�壨final�棩:�����ݿ�������Ҫ���ĸ�������Ϣ�����������ļ��У�ͨ����ȡ�����ļ��ķ�ʽ����ȡ����
	/*
	 * �˷����ĺô�
	 * 1.ʵ�������������ķ��룬ʵ���˽���
	 * 2.����޸������ļ���Ϣ�����Ա���������´��
	 */
	@Test
	public void testConnection5() throws IOException, Exception
	{
		//1.��ȡ�����ļ����ĸ�������Ϣ
		InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.proprities");
		Properties pros = new Properties();
		pros.load(is);
		
		String user = pros.getProperty("user");
		String password = pros.getProperty("password");
		String url = pros.getProperty("url");
		String driverClass = pros.getProperty("driverClass");
		
		
		//2.��������
		Class.forName(driverClass);
		
		//3.��ȡ����
		Connection conn = DriverManager.getConnection(url,user,password);
		System.out.println(conn);
		
		
		
	}
	
}

package jdbc.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import java.sql.Statement;
import java.sql.PreparedStatement;

import preparedstatement.crud_03.PreparedStatementUpdateTest;

/**
 * @Description �������ݿ�Ĺ�����
 * @author kkkkk
 * @version
 * @date 9:10:02
 * 
 */
public class JDBCUtils 
{
	public static Connection getConnection() throws Exception
	{
		InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
		
		Properties pro = new Properties();
		pro.load(is);
		
		String url = pro.getProperty("url");
		String user = pro.getProperty("user");
		String driverClass = pro.getProperty("driverClass");
		String password = pro.getProperty("password");
		
		//2.��������
		Class.forName(driverClass);
		
		//3.��ȡ����
		Connection conn = DriverManager.getConnection(url, user, password);
		
		return conn;
		
	
	}
	
	/**
	 * @Description �ر����Ӻ�Statement�Ĳ���
	 * @author kkkkk
	 * @date 9:12:40
	 * @param conn
	 * @param ps
	 */
	public static void closeResource(Connection conn,Statement ps)
	{
		try 
		{
			if(ps != null)
			ps.close();
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try 
		{
			if(conn != null)
			conn.close();
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	
	public static void closeResource(Connection conn,Statement ps,ResultSet rs)
	{
		try 
		{
			if(ps != null)
			ps.close();
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try 
		{
			if(conn != null)
			conn.close();
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try 
		{
			if(rs != null)
			rs.close();
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
}

package preparedstatement.crud_03;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.junit.Test;

import com.mysql.jdbc.ConnectionImpl;
import com.mysql.jdbc.PreparedStatement;

import jdbc.util.JDBCUtils;

/*
 * ʹ��PreparedStatement���滻Statement��ʵ�ֶ����ݿ������ݱ����ɾ�Ĳ����
 * 
 * ��ɾ�ģ���
 * 
 * 
 */
public class PreparedStatementUpdateTest 
{
	//ͨ�õ���ɾ�Ĳ���
	public void CUD(String sql,Object ... obj)
	{
		//1.��ȡ����
		Connection conn = null;
		//2.��ȡPreparedStatement��ʵ��
		java.sql.PreparedStatement ps = null;
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			
			
			if(obj.length == 0)
			{
				//���û��ռλ����ֱ��ִ�в���
				//4.ִ�в���
				ps.execute();
			}else
			{
				//�����ռλ���������ռλ��
				//3.���ռλ��
				for(int i = 0;i < obj.length;i++)
				{
					ps.setObject(i+1, obj[i]);
				}
				
				ps.execute();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			//5.�ر���Դ
			JDBCUtils.closeResource(conn, ps);
		}
		
	}
	
	//����ͨ����ɾ�Ĳ���
	@Test
	public void testCUD() throws ParseException
	{
//		//��
//		String sql = "INSERT INTO customers(id,name,email,birth) values(?,?,?,?)";
//		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		
//		java.util.Date date = sdf.parse("1998-02-17");
//		
//		java.sql.Date date1 = new java.sql.Date(date.getTime());
//		
//		
//		CUD(sql,20,"ck","@qq.com",date1);
		
		//ɾ
//		String sql = "DELETE FROM customers WHERE ID = ?";
//		CUD(sql,22);
		
		//��
		String sql = "UPDATE customers SET name = ? WHERE id = ?";
		CUD(sql,"kkkkk",20);
	}
	
	
	//�޸�customers���һ����¼
	@Test
	public void testUpdate()
	{
		//1.��ȡ���ݿ�����
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		try {
			conn = JDBCUtils.getConnection();
			
			//2.Ԥ����sql��䣬����prepareStatement��ʵ��
			String sql = "UPDATE customers SET name = ? WHERE id = ?";
			ps = conn.prepareStatement(sql);
			
			
			//3.���ռλ��
			ps.setObject(1, "Ī����");
			ps.setObject(2, 18);
			//4.ִ�в���
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			//5.��Դ�Ĺر�
			JDBCUtils.closeResource(conn, ps);
		}
		
	}
	
	
	
	//��customer�������һ����¼
	@Test
	public void testInsert()
	{
		
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		try {
			//1.��ȡ�����ļ��е��ĸ�������Ϣ
			InputStream is = PreparedStatementUpdateTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
			
			Properties pro = new Properties();
			pro.load(is);
			
			String url = pro.getProperty("url");
			String user = pro.getProperty("user");
			String driverClass = pro.getProperty("driverClass");
			String password = pro.getProperty("password");
			
			//2.��������
			Class.forName(driverClass);
			
			//3.��ȡ����
			conn = DriverManager.getConnection(url, user, password);
			
			
			//4.Ԥ����sql��䣬����PreparedStatement��ʵ��
			String sql = "INSERT INTO customers(name,email,birth) VALUES(?,?,?)";//?:ռλ��
			ps = conn.prepareStatement(sql);
			
			//5.���ռλ��
			ps.setString(1, "��߸");
			ps.setString(2, "nezha@gmail.com");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
			java.util.Date date = sdf.parse("1000-01-01");
			
			ps.setDate(3, new java.sql.Date(date.getTime()));
			
			//6.ִ�в���
			boolean execute = ps.execute();
		} catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
				//7.��Դ�Ĺر�
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
	}
	
	
	
}

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
 * 使用PreparedStatement来替换Statement，实现对数据库中数据表的增删改查操作
 * 
 * 增删改：查
 * 
 * 
 */
public class PreparedStatementUpdateTest 
{
	//通用的增删改操作
	public void CUD(String sql,Object ... obj)
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
				ps.execute();
			}else
			{
				//如果有占位符，则填充占位符
				//3.填充占位符
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
			//5.关闭资源
			JDBCUtils.closeResource(conn, ps);
		}
		
	}
	
	//测试通用增删改操作
	@Test
	public void testCUD() throws ParseException
	{
//		//增
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
		
		//删
//		String sql = "DELETE FROM customers WHERE ID = ?";
//		CUD(sql,22);
		
		//改
		String sql = "UPDATE customers SET name = ? WHERE id = ?";
		CUD(sql,"kkkkk",20);
	}
	
	
	//修改customers表的一条记录
	@Test
	public void testUpdate()
	{
		//1.获取数据库连接
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		try {
			conn = JDBCUtils.getConnection();
			
			//2.预编译sql语句，返回prepareStatement的实例
			String sql = "UPDATE customers SET name = ? WHERE id = ?";
			ps = conn.prepareStatement(sql);
			
			
			//3.填充占位符
			ps.setObject(1, "莫扎特");
			ps.setObject(2, 18);
			//4.执行操作
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			//5.资源的关闭
			JDBCUtils.closeResource(conn, ps);
		}
		
	}
	
	
	
	//向customer表中添加一条记录
	@Test
	public void testInsert()
	{
		
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		try {
			//1.读取配置文件中的四个基本信息
			InputStream is = PreparedStatementUpdateTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
			
			Properties pro = new Properties();
			pro.load(is);
			
			String url = pro.getProperty("url");
			String user = pro.getProperty("user");
			String driverClass = pro.getProperty("driverClass");
			String password = pro.getProperty("password");
			
			//2.加载驱动
			Class.forName(driverClass);
			
			//3.获取连接
			conn = DriverManager.getConnection(url, user, password);
			
			
			//4.预编译sql语句，返回PreparedStatement的实例
			String sql = "INSERT INTO customers(name,email,birth) VALUES(?,?,?)";//?:占位符
			ps = conn.prepareStatement(sql);
			
			//5.填充占位符
			ps.setString(1, "哪吒");
			ps.setString(2, "nezha@gmail.com");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
			java.util.Date date = sdf.parse("1000-01-01");
			
			ps.setDate(3, new java.sql.Date(date.getTime()));
			
			//6.执行操作
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
				//7.资源的关闭
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

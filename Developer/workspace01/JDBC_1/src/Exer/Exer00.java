package Exer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.junit.Test;

import jdbc.util.JDBCUtils;

public class Exer00 
{
	//从控制台向数据库的表customers中插入一条数据
	@Test
	public void exer00() throws Exception
	{
		Connection conn = JDBCUtils.getConnection();
		
		String sql = "insert into customers(name,email,birth) values(?,?,?)";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = sdf.parse("1998-05-05");
		
		java.sql.Date date2 = new java.sql.Date(date.getTime());
		
		ps.setObject(1, "exer");
		ps.setObject(2, "exer@qqq.com");
		ps.setObject(3, date2);
		
		ps.execute();
		
		JDBCUtils.closeResource(conn, ps);
	}
	
	@Test
	public void tsetCUD()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入用户名");
		String name = scan.next();
		
		System.out.println("请输入邮箱");
		String email = scan.next();
		
		System.out.println("请输入生日");
		String birth = scan.next();
		
		String sql = "insert into customers(name,email,birth) values(?,?,?)";
		
		int insertCount = CUD(sql,name,email,birth);
		if(insertCount > 0)
		{
			System.out.println("添加成功");
		}else
		{
			System.out.println("添加失败");
		}
	}
	
	//通用的增删改操作
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
					ps.execute();
				}else
				{
					//如果有占位符，则填充占位符
					//3.填充占位符
					for(int i = 0;i < obj.length;i++)
					{
						ps.setObject(i+1, obj[i]);
					}
					/*
					 * ps.execute();
					 * 如果执行的是查询操作，有返回结果，则此方法返回true
					 * 如果执行的是增删改操作，没有返回值，则此方法返回false
					 */
					
					
//					ps.execute();
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
		
}

package blob;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import jdbc.util.JDBCUtils;

/*
 * 使用PreparedStatement实现数据的批量操作
 * 
 * update delete本身就具有批量操作的效果
 * 此时的批量操作主要指的是批量插入，使用PreparedStatement如何实现更高效的插入？
 * 
 * 
 * 题目：向goods表中插入20000条数据
 * 批量插入的方式一：使用Statement
 * Connection conn = JDBCUtils。getConnection();
 * 
 * Statement st = conn.createStatement();
 * 
 * for(int 1 = 1;i <= 20000;i++)
 * {
 * 		String sql = "insert into goods(name) values('name_" + i + "')";
 * 		st.excute;
 * }
 */
public class InsertTest 
{
	//批量插入的方式二
	@Test
	public void test()
	{
		Connection conn = null;
		PreparedStatement ps = null;
		try
		{
			long start = System.currentTimeMillis();
			conn = JDBCUtils.getConnection();
			
			String sql = "insert into goods(name) values(?)";
			ps = conn.prepareStatement(sql);
			
			for(int i = 1;i <= 20000;i++)
			{
				ps.setObject(1, "name_" + i);
				ps.execute();
			}
			
			long end = System.currentTimeMillis();
			
			System.out.println(end - start);//30897
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtils.closeResource(conn, ps);
		}
	}
	
	//批量插入的方式三
	/*
	 * 1.addBatch()、executeBatch()、clearBatch()
	 * 2.mysql服务器默认是关闭批处理的，我们需要通过一个参数，让mysql开启对批处理的支持
	 *  ?rewriteBatchedStatements=true 写在配置文件的url后面
	 *  3.使用更新的mysql驱动：mysql-connector-java-5.1.37-bin.jar
	 */
	
	@Test
	public void test1()
	{
		Connection conn = null;
		PreparedStatement ps = null;
		try
		{
			long start = System.currentTimeMillis();
			conn = JDBCUtils.getConnection();
			
			String sql = "insert into goods(name) values(?)";
			ps = conn.prepareStatement(sql);
			
			for(int i = 1;i <= 20000;i++)
			{
				ps.setObject(1, "name_" + i);
				
				//1.“攒”sql
				
				ps.addBatch();
				
				if(i % 500 == 0)
				{
					//2.执行batch
					ps.executeBatch();
					
					//3.清空batch
					ps.clearBatch();
				}
			
				
			}
			
			long end = System.currentTimeMillis();
			
			System.out.println(end - start);//30897--474
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtils.closeResource(conn, ps);
		}
	}
	
	//批量插入的方式四,设置连接不允许自动提交数据
	@Test
	public void test2()
	{
		Connection conn = null;
		PreparedStatement ps = null;
		try
		{
			long start = System.currentTimeMillis();
			conn = JDBCUtils.getConnection();
			
			//设置不允许自动提交
			conn.setAutoCommit(false);
			
			String sql = "insert into goods(name) values(?)";
			ps = conn.prepareStatement(sql);
			
			for(int i = 1;i <= 20000;i++)
			{
				ps.setObject(1, "name_" + i);
				
				//1.“攒”sql
				
				ps.addBatch();
				
				if(i % 500 == 0)
				{
					//2.执行batch
					ps.executeBatch();
					
					//3.清空batch
					ps.clearBatch();
				}
			
				
			}
			
			//提交数据
			conn.commit();
			
			long end = System.currentTimeMillis();
			
			System.out.println(end - start);//30897--474
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtils.closeResource(conn, ps);
		}
	}
	
}

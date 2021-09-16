package blob;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import jdbc.util.JDBCUtils;

/*
 * ʹ��PreparedStatementʵ�����ݵ���������
 * 
 * update delete����;�������������Ч��
 * ��ʱ������������Ҫָ�����������룬ʹ��PreparedStatement���ʵ�ָ���Ч�Ĳ��룿
 * 
 * 
 * ��Ŀ����goods���в���20000������
 * ��������ķ�ʽһ��ʹ��Statement
 * Connection conn = JDBCUtils��getConnection();
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
	//��������ķ�ʽ��
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
	
	//��������ķ�ʽ��
	/*
	 * 1.addBatch()��executeBatch()��clearBatch()
	 * 2.mysql������Ĭ���ǹر�������ģ�������Ҫͨ��һ����������mysql�������������֧��
	 *  ?rewriteBatchedStatements=true д�������ļ���url����
	 *  3.ʹ�ø��µ�mysql������mysql-connector-java-5.1.37-bin.jar
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
				
				//1.���ܡ�sql
				
				ps.addBatch();
				
				if(i % 500 == 0)
				{
					//2.ִ��batch
					ps.executeBatch();
					
					//3.���batch
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
	
	//��������ķ�ʽ��,�������Ӳ������Զ��ύ����
	@Test
	public void test2()
	{
		Connection conn = null;
		PreparedStatement ps = null;
		try
		{
			long start = System.currentTimeMillis();
			conn = JDBCUtils.getConnection();
			
			//���ò������Զ��ύ
			conn.setAutoCommit(false);
			
			String sql = "insert into goods(name) values(?)";
			ps = conn.prepareStatement(sql);
			
			for(int i = 1;i <= 20000;i++)
			{
				ps.setObject(1, "name_" + i);
				
				//1.���ܡ�sql
				
				ps.addBatch();
				
				if(i % 500 == 0)
				{
					//2.ִ��batch
					ps.executeBatch();
					
					//3.���batch
					ps.clearBatch();
				}
			
				
			}
			
			//�ύ����
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

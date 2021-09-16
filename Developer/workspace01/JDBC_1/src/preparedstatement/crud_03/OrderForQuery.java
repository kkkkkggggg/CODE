package preparedstatement.crud_03;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.junit.Test;

import jdbc.util.JDBCUtils;

public class OrderForQuery 

{
	
	@Test
	public void test()
	{
		String sql = "select order_id orderId,order_name orderName,order_date orderDate from `order` where order_id = ?";
		
		OrderQuery(sql,1);
	}
	
	
	
	
	/**
	 * �����order���ͨ�ò�ѯ����
	 * @param sql
	 */
	
	public void OrderQuery(String sql,Object ... args)
	{
		/*
		 * ����ڱ���ֶ������������������ͬ�����
		 * 1.����������sql���ʱ��ʹ������������������ֶεı���
		 * 2.ʹ��ResultSetMetaDataʱ����Ҫʹ��getColumnLabel()���滻getColumnName(),��ȡ�еı���
		 * 
		 * ˵�������sql��û�и��ֶ������getColumnLabel��ȡ�ľ�������
		 */
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			//��ȡ����
			conn = JDBCUtils.getConnection();
			
			
			//��ȡprepareStatementʵ��
			ps = conn.prepareStatement(sql);
			
			//���ռλ��
			for(int i = 0;i < args.length;i++)
			{
				ps.setObject(i + 1, args[i]);
			}
			//ִ��sql���
			resultSet = ps.executeQuery();
			
			
			
			
			
			if(resultSet.next())
			{
				
				//��ȡresultSetԪ���ݣ���ͨ��Ԫ���ݻ�ȡ��ѯ���ֶ������ֶθ���
				ResultSetMetaData rsmd = ps.getMetaData();
				int columnCount = rsmd.getColumnCount();
				
				
				Order order = new Order();
				
				for (int i = 1; i <= columnCount; i++)
				{
					//��ȡ��Ӧ����λ�õ��ֶ�ֵ
					Object columnValue = resultSet.getObject(i);
					
					//��ȡ�е�����getColumnName,���Ƽ�ʹ��
//					String columnName = rsmd.getColumnName(i);
					
					//��ȡ�еı���getColumnLabel
					String columnLabel = rsmd.getColumnLabel(i);
					
					//ͨ�����䷽ʽ��ȡ���ֶ�����Ӧ��Order���������
					Class<? extends Order> clazz = order.getClass();
					
					Field field = clazz.getDeclaredField(columnLabel);
					field.setAccessible(true);
					
					
					
					//ͨ������Ϊorder�����Ը�ֵ
					field.set(order, columnValue);
					
				}
				
				System.out.println(order);
				
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
		
		
		
		
		
	}
}


package preparedstatement.crud_03;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import bean.Customer;
import jdbc.util.JDBCUtils;

/**
 * ʹ��PreparedStatementʵ������ڲ�ͬ���ͨ�ò�ѯ����,���ر��е�һ����¼
 * @author kkkkk
 *
 */
public class PreparedStatementQueryTest
{
	
	@Test
	public void test()
	{
		String sql = "select id,name,email from customers where id = ?";
		Customer instance = getInstance(Customer.class,sql,1);
		
		System.out.println(instance);
		
		String sql1 = "select order_id orderId,order_name orderName from `order` where order_id = ?";
		Order instance2 = getInstance(Order.class,sql1,1);
		
		System.out.println(instance2);
	}
	
	
	@Test
	public void test1()
	{
		String sql = "select id,name,email from customers where id > ?";
		List<Customer> list = getMutilyInstance(Customer.class,sql,1);
		
//		Iterator<Customer> iterator = list.iterator();
//		
//		while(iterator.hasNext())
//		{
//			System.out.println(iterator.next());
//		}
		
		list.forEach(System.out::println);
	}
	
	/**
	 * ����ڲ�ͬ�ı��ͨ�õĲ�ѯ���������ر��еĶ�����¼
	 * @param clazz
	 * @param sql
	 * @param args
	 * @return
	 */
	public <T> List<T>  getMutilyInstance(Class<T> clazz,String sql,Object ...args)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			//����list�洢������¼
			List<T> list = new ArrayList();
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
			
			//��ȡresultSetԪ���ݣ���ͨ��Ԫ���ݻ�ȡ��ѯ���ֶ������ֶθ���
			ResultSetMetaData rsmd = ps.getMetaData();
			int columnCount = rsmd.getColumnCount();
			
			while(resultSet.next())
			{
				T t = clazz.newInstance();
				
				for (int i = 1; i <= columnCount; i++)
				{
					//��ȡ��Ӧ����λ�õ��ֶ�ֵ
					Object columnValue = resultSet.getObject(i);
					
					//��ȡ�е�����getColumnName,���Ƽ�ʹ��
//					String columnName = rsmd.getColumnName(i);
					
					//��ȡ�еı���getColumnLabel
					String columnLabel = rsmd.getColumnLabel(i);
					
					//ͨ�����䷽ʽ��ȡ���ֶ�����Ӧ��Order���������
					
					
					Field field = clazz.getDeclaredField(columnLabel);
					field.setAccessible(true);
					
					
					
					//ͨ������Ϊorder�����Ը�ֵ
					field.set(t, columnValue);
					
				}
				
				list.add(t);
			}
			
			
			return list;			
			
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
		
		
		return null;
	}
	
	
	/**
	 * ����ڲ�ͬ�ı��ͨ�õĲ�ѯ���������ر��е�һ����¼
	 * @param clazz
	 * @param sql
	 * @param args
	 * @return
	 */
	public  <T> T getInstance(Class<T> clazz,String sql,Object ...args)
	{
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
				
				
				T t = clazz.newInstance();
				
				for (int i = 1; i <= columnCount; i++)
				{
					//��ȡ��Ӧ����λ�õ��ֶ�ֵ
					Object columnValue = resultSet.getObject(i);
					
					//��ȡ�е�����getColumnName,���Ƽ�ʹ��
//					String columnName = rsmd.getColumnName(i);
					
					//��ȡ�еı���getColumnLabel
					String columnLabel = rsmd.getColumnLabel(i);
					
					//ͨ�����䷽ʽ��ȡ���ֶ�����Ӧ��Order���������
					
					
					Field field = clazz.getDeclaredField(columnLabel);
					field.setAccessible(true);
					
					
					
					//ͨ������Ϊorder�����Ը�ֵ
					field.set(t, columnValue);
					
				}
				
				return t;
				
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
		
		
		return null;
	}
}

package com.ck1.transaction;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ck0.jdbc.utils.Customer;
import com.ck0.jdbc.utils.JDBCUtils;
import com.ck0.jdbc.utils.User;
/*
 * 1.ʲô�����ݿ�����
 * ����һ�����������Ԫ��ʹ���ݴ�һ��״̬�任����һ��״̬
 * 		>һ���߼�������Ԫ��һ������DML����
 * 
 * 2.�������ԭ�򣺱�֤����������Ϊһ��������Ԫ��ִ�У���ʹ��
 * ���˹��ϣ������ܸı�����ִ�з�ʽ������һ��������ִ�ж������ʱ��
 * Ҫô���е����񶼱��ύ(commit)����ô��Щ�޸ľ����õر�����
 * ����Ҫô���ݿ����ϵͳ�����������������޸ģ���������ع�(rollback)�����״̬��
 * 
 * 3.����һ���ύ���Ͳ��ɻع�
 * 
 * 4.��Щ�����ᵼ�����ݵ��Զ��ύ
 * 		>DDL����һ��ִ�У������Զ��ύ
 * 			>set autocommit = 0;��DDL����ʧЧ
 * 		>DML����Ĭ������£�һ��ִ�л��Զ��ύ
 * 			>���ǿ���ͨ��set autocommit = 0;�ķ�ʽȡ��DML���Զ��ύ
 * 		>�ڹر�����ʱ���Ὣû���ύ�����ݽ����Զ��ύ
 */
public class TransactionTest
{
	
	
	//*********************************δ�������ݿ������ת�˲���*****************************************
	/*
	 * ��������ݱ�User_table��˵
	 * AA�û���BB�û�ת��100
	 * 
	 * AA�û�������100 update user_table set balance = balance - 100 where user = 'AA'
	 * BB�û�������100 update user_table set balance = balance + 100 where user = 'BB'
	 */
	@Test
	public void test() throws Exception
	{
		String sql = "update user_table set balance = balance - 100 where user = ?";
		CUD(sql,"AA");
		
		//ģ�������쳣
		System.out.println(10 / 0);
		
		String sql1 = "update user_table set balance = balance + 100 where user = ?";
		CUD(sql1,"BB");
		
		System.out.println("ת�˳ɹ�");
	}
	
	
	
	//ͨ�õ���ɾ�Ĳ���---version 1.0
		public int CUD(String sql,Object ... obj)
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
					return ps.executeUpdate();
				}else
				{
					//�����ռλ���������ռλ��
					//3.���ռλ��
					for(int i = 0;i < obj.length;i++)
					{
						ps.setObject(i+1, obj[i]);
					}
					
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
				//5.�ر���Դ
				JDBCUtils.closeResource(conn, ps);
			}
			
			return 0;
		}
		
		//*************************************�������ݿ������ת�˲���***************************************************
		@Test
		public void test1()
		{
			Connection conn = null;
			try
			{
				conn = JDBCUtils.getConnection();
				
				//ȡ�����ݵ��Զ� �ύ����
				conn.setAutoCommit(false);
				
				
				String sql = "update user_table set balance = balance - 100 where user = ?";
				CUD(conn,sql,"AA");
				
				//ģ�������쳣
				System.out.println(10 / 0);
				
				String sql1 = "update user_table set balance = balance + 100 where user = ?";
				CUD(conn,sql1,"BB");
				
			
				
				System.out.println("ת�˳ɹ�");
				
				//�ύ����
				conn.commit();
			} catch (Exception e)
			{
				
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				//�ع�����
				try
				{
					conn.rollback();
				} catch (SQLException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}finally
			{
				
				//�޸���Ϊ�Զ��ύ����
				//��Ҫ������ݿ����ӳص�ʹ��
				
				try
				{
					conn.setAutoCommit(true);
				} catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//��Դ�ر�
				JDBCUtils.closeResource(conn, null);
			}
			
			
			
		}
		
		
		//ͨ�õ���ɾ�Ĳ���---version 2.0(�������ݿ�����)
			public int CUD(Connection conn,String sql,Object ... obj)
			{
				
				//1.��ȡPreparedStatement��ʵ��
				java.sql.PreparedStatement ps = null;
				try {
					
					ps = conn.prepareStatement(sql);
					
					
					if(obj.length == 0)
					{
						//���û��ռλ����ֱ��ִ�в���
						//3.ִ�в���
						return ps.executeUpdate();
					}else
					{
						//�����ռλ���������ռλ��
						//2.���ռλ��
						for(int i = 0;i < obj.length;i++)
						{
							ps.setObject(i+1, obj[i]);
						}
						
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
					//4.�ر���Դ
					JDBCUtils.closeResource(null, ps);
				}
				
				return 0;
			}
			
			@Test
			public void testTransactionUpdate() throws Exception
			{
				Connection conn = JDBCUtils.getConnection();
				
				
				
				//ȡ���Զ��ύ����
				conn.setAutoCommit(false);
				
				String sql = "update user_table set balance = 800 where user = ?";
				
				CUD(conn,sql,"AA");
				
				Thread.sleep(15000);
				
				System.out.println("�޸Ľ���");
				
			}
			
			
			@Test
			public void testTransactionSelect() throws Exception
			{
				Connection conn = JDBCUtils.getConnection();
				
				//�������ݿ��������뼶��
				conn.setTransactionIsolation(conn.TRANSACTION_READ_UNCOMMITTED);      
				
				//��ȡ��ǰ���ӵĸ��뼶��
				System.out.println(conn.getTransactionIsolation());
				
				//ȡ���Զ��ύ����
				conn.setAutoCommit(false);
				
				
				String sql = "select user,password,balance from user_table where user = ?";
				User instance = getInstance(conn,User.class,sql,"AA");
				
				System.out.println(instance);
				
				
				
					
			}
			
			//***********************************************************************
			/**
			 * ����ڲ�ͬ�ı��ͨ�õĲ�ѯ���������ر��е�һ����¼ version 2.0 ����������
			 * @param clazz
			 * @param sql
			 * @param args
			 * @return
			 */
			public  <T> T getInstance(Connection conn,Class<T> clazz,String sql,Object ...args)
			{
				
				PreparedStatement ps = null;
				ResultSet resultSet = null;
				try {
					
					
					
					
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
//							String columnName = rsmd.getColumnName(i);
							
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
					JDBCUtils.closeResource(null, ps, resultSet);
				}
				
				
				return null;
			}
		
}

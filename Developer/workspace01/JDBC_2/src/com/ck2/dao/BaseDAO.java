package com.ck2.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ck0.jdbc.utils.JDBCUtils;

/*
 * DAO:data(base) access object
 * ��װ����������ݱ��ͨ�õĲ���
 */
public abstract class BaseDAO
{
	//ͨ�õ���ɾ�Ĳ���---version 2.0(�������ݿ�����)
	public int update(Connection conn,String sql,Object ... obj)
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
			JDBCUtils.closeResource(null, ps, resultSet);
		}
		
		
		return null;
	}
	
	/**
	 * ����ڲ�ͬ�ı��ͨ�õĲ�ѯ���������ر��еĶ�����¼
	 * @param clazz
	 * @param sql
	 * @param args
	 * @return
	 */
	public <T> List<T>  getMutilyInstance(Connection conn,Class<T> clazz,String sql,Object ...args)
	{
		
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			//����list�洢������¼
			List<T> list = new ArrayList();
			//��ȡ����
			
			
			
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
			JDBCUtils.closeResource(null, ps, resultSet);
		}
		
		
		return null;
	}
	
	
	
	public <T> T  getValue(Connection conn,String sql,Object ... args)
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		try
		{
			ps = conn.prepareStatement(sql);
			
			
			for(int i = 0;i < args.length;i++)
			{
				ps.setObject(i + 1, args[i]);
			}
			
			rs = ps.executeQuery();
			
			if(rs.next())
			{
				return (T) rs.getObject(1);
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			JDBCUtils.closeResource(null, ps, rs);
		}
		
		return null; 
		
	}
	
	
}

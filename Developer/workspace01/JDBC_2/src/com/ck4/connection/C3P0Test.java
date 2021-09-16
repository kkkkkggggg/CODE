package com.ck4.connection;

import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;
import com.mchange.v2.c3p0.*;
public class C3P0Test
{
	
	//��ʽһ
	@Test
	public void testC3P0() throws Exception
	{
			
		
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass( "com.mysql.jdbc.Driver" ); //loads the jdbc driver            
		cpds.setJdbcUrl( "jdbc:mysql://localhost:3306/test1?rewriteBatchedStatements=true" );
		cpds.setUser("root");                                  
		cpds.setPassword("12138970"); 
		
		//ͨ��������صĲ����������ݿ����ӳؽ��й���
		//���ó�ʼʱ���ݿ����ӳ��е�������
		cpds.setInitialPoolSize(10);
		Connection conn = cpds.getConnection();
		
		//����c3p0���ݿ����ӳ�
//		DataSources.destroy(cpds);
		
		System.out.println(conn);
	}
	
	//��ʽ����ʹ�������ļ�
	@Test
	public void testC3P02() throws Exception
	{
		ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");
		
		Connection conn = cpds.getConnection();
		
		System.out.println(conn);
		
	}
}

package com.ck4.connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

//����DBCP�����ݿ����ӳ�
public class DBCPTest
{
	
	//��ʽһ�����Ƽ�
	@Test
	public void testDBCP() throws SQLException
	{
		//������DBCP�����ݿ����ӳ�
		BasicDataSource ds = new BasicDataSource();
		
		//���û�����Ϣ
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql:///test1");
		ds.setUsername("root");
		ds.setPassword("12138970");
		
		//���������������漰���ݿ����ӳع�����������
		ds.setInitialSize(10);
		ds.setMaxActive(10);
		
		Connection conn = ds.getConnection();
		
		System.out.println(conn);
	}
	
	//��ʽ����ʹ�������ļ�
	@Test
	public void test1() throws Exception
	{
		//��ʽһ
//		InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
		
		//��ʽ��
		FileInputStream is = new FileInputStream(new File("src/dbcp.properties"));
		
		Properties pros = new Properties();
		pros.load(is);
		
		DataSource dataSource = BasicDataSourceFactory.createDataSource(pros);
		
		Connection conn = dataSource.getConnection();
		
		System.out.println(conn);
		
	}
}

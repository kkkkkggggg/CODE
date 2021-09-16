package com.ck4.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.junit.Test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

public class DruidTest
{
	@Test
	public void testDruid() throws Exception
	{
		DruidDataSource dds = new DruidDataSource();
		
		dds.setDriverClassName("com.mysql.jdbc.Driver");
		dds.setUrl("jdbc:mysql:///test1");
		dds.setUsername("root");
		dds.setPassword("12138970");
		
		
		
		DruidPooledConnection conn = dds.getConnection();
		
		Connection connection = conn.getConnection();
		
		System.out.println(connection);
		
	}
	
	@Test
	public void testDurid1() throws Exception
	{
		
		
		InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("durid.properties");
		
		Properties pros = new Properties();
		
		pros.load(is);
		
		DataSource dataSource = DruidDataSourceFactory.createDataSource(pros);
		
		Connection conn = dataSource.getConnection();
		
		System.out.println(conn);
//		
		
	}
}

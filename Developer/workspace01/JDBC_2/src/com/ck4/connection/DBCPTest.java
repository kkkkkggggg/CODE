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

//测试DBCP的数据库连接池
public class DBCPTest
{
	
	//方式一：不推荐
	@Test
	public void testDBCP() throws SQLException
	{
		//创建了DBCP的数据库连接池
		BasicDataSource ds = new BasicDataSource();
		
		//设置基本信息
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql:///test1");
		ds.setUsername("root");
		ds.setPassword("12138970");
		
		//还可以设置其他涉及数据库连接池管理的相关属性
		ds.setInitialSize(10);
		ds.setMaxActive(10);
		
		Connection conn = ds.getConnection();
		
		System.out.println(conn);
	}
	
	//方式二：使用配置文件
	@Test
	public void test1() throws Exception
	{
		//方式一
//		InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
		
		//方式二
		FileInputStream is = new FileInputStream(new File("src/dbcp.properties"));
		
		Properties pros = new Properties();
		pros.load(is);
		
		DataSource dataSource = BasicDataSourceFactory.createDataSource(pros);
		
		Connection conn = dataSource.getConnection();
		
		System.out.println(conn);
		
	}
}

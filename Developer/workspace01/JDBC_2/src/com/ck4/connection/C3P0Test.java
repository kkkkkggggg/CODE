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
	
	//方式一
	@Test
	public void testC3P0() throws Exception
	{
			
		
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass( "com.mysql.jdbc.Driver" ); //loads the jdbc driver            
		cpds.setJdbcUrl( "jdbc:mysql://localhost:3306/test1?rewriteBatchedStatements=true" );
		cpds.setUser("root");                                  
		cpds.setPassword("12138970"); 
		
		//通过设置相关的参数，对数据库连接池进行管理
		//设置初始时数据库连接池中的连接数
		cpds.setInitialPoolSize(10);
		Connection conn = cpds.getConnection();
		
		//销毁c3p0数据库连接池
//		DataSources.destroy(cpds);
		
		System.out.println(conn);
	}
	
	//方式二：使用配置文件
	@Test
	public void testC3P02() throws Exception
	{
		ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");
		
		Connection conn = cpds.getConnection();
		
		System.out.println(conn);
		
	}
}

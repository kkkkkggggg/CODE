package com.ck1.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import com.ck0.jdbc.utils.JDBCUtils;

public class ConnectionTest
{
	@Test
	public void test() throws Exception
	{
		Connection conn = JDBCUtils.getConnection();
		
		String sql = "delete from customers where id = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setObject(1, 25);
		
		ps.execute();
		
		JDBCUtils.closeResource(conn, ps);
		
	}
}

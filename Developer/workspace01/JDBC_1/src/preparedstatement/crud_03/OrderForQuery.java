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
	 * 针对于order表的通用查询操作
	 * @param sql
	 */
	
	public void OrderQuery(String sql,Object ... args)
	{
		/*
		 * 针对于表的字段名与类的属性名不相同的情况
		 * 1.必须在声明sql语句时，使用类的属性名来命名字段的别名
		 * 2.使用ResultSetMetaData时，需要使用getColumnLabel()来替换getColumnName(),获取列的别名
		 * 
		 * 说明：如果sql中没有给字段起别名getColumnLabel获取的就是列名
		 */
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			//获取连接
			conn = JDBCUtils.getConnection();
			
			
			//获取prepareStatement实例
			ps = conn.prepareStatement(sql);
			
			//填充占位符
			for(int i = 0;i < args.length;i++)
			{
				ps.setObject(i + 1, args[i]);
			}
			//执行sql语句
			resultSet = ps.executeQuery();
			
			
			
			
			
			if(resultSet.next())
			{
				
				//获取resultSet元数据，再通过元数据获取查询的字段名和字段个数
				ResultSetMetaData rsmd = ps.getMetaData();
				int columnCount = rsmd.getColumnCount();
				
				
				Order order = new Order();
				
				for (int i = 1; i <= columnCount; i++)
				{
					//获取对应索引位置的字段值
					Object columnValue = resultSet.getObject(i);
					
					//获取列的列名getColumnName,不推荐使用
//					String columnName = rsmd.getColumnName(i);
					
					//获取列的别名getColumnLabel
					String columnLabel = rsmd.getColumnLabel(i);
					
					//通过反射方式获取与字段名对应的Order类的属性名
					Class<? extends Order> clazz = order.getClass();
					
					Field field = clazz.getDeclaredField(columnLabel);
					field.setAccessible(true);
					
					
					
					//通过反射为order的属性赋值
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


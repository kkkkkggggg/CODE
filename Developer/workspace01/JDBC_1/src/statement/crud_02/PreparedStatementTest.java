package statement.crud_02;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import org.junit.Test;

/**
 * 演示使用PreparedStatement替换Statement解决sql注入问题
 * 
 * @author kkkkk
 *
 */
public class PreparedStatementTest 
{
	// 使用Statement的弊端：需要拼写sql语句，并且存在SQL注入的问题
		//如何避免sql注入：只要用PreoaredStatement(从Statement扩展而来)取代statement
		/*
		 * 除了解决Statement的拼串、sql注入问题之外，PreparedStatement还有哪些好处？
		 * 1.PreparedStatement可以操作Blob的数据，而Statement不可以
		 * 2.PreparedStatement可以实现更高效的批量操作
		 */
		@Test
		public void testLogin() {
			Scanner scan = new Scanner(System.in);

			System.out.print("用户名：");
			String userName = scan.nextLine();
			System.out.print("密   码：");
			String password = scan.nextLine();

			// SELECT user,password FROM user_table WHERE USER = '1' or ' AND PASSWORD = '='1' or '1' = '1';
			
			String sql = "SELECT user,password FROM user_table WHERE USER = '" + userName + "' AND PASSWORD = '" + password + "'";
			User user = get(sql, User.class);
			if (user != null) 
			{
				System.out.println("登陆成功!");
			} else {
				System.out.println("用户名或密码错误！");
			}
		}
		
		@Test
		public void test()
		{
			
			System.out.println("SELECT user,password FROM user_table WHERE USER = '" + "1' or " + "'AND PASSWORD = '" +  " = '1' or '1' = '1"+ "'");
			
			//select user,password from user_table where user = '1' or 'and password' = '1' or '1' = '1'
		}

		/**
		 * 针对于不同表的通用查询操作，返回表中的一条记录
		 * @param sql
		 * @param clazz
		 * @return
		 */
		// 使用Statement实现对数据表的查询操作
		public <T> T get(String sql, Class<T> clazz) {
			T t = null;

			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				// 1.加载配置文件
				InputStream is = StatementTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
				Properties pros = new Properties();
				pros.load(is);

				// 2.读取配置信息
				String user = pros.getProperty("user");
				String password = pros.getProperty("password");
				String url = pros.getProperty("url");
				String driverClass = pros.getProperty("driverClass");

				// 3.加载驱动
				Class.forName(driverClass);

				// 4.获取连接
				conn = DriverManager.getConnection(url, user, password);

				ps = conn.prepareStatement(sql);
				

				rs = ps.executeQuery(sql);

				// 获取结果集的元数据
				ResultSetMetaData rsmd = rs.getMetaData();

				// 获取结果集的列数
				int columnCount = rsmd.getColumnCount();

				if (rs.next()) {

					t = clazz.newInstance();

					for (int i = 0; i < columnCount; i++) {
						// //1. 获取列的名称
						// String columnName = rsmd.getColumnName(i+1);

						// 1. 获取列的别名
						String columnName = rsmd.getColumnLabel(i + 1);

						// 2. 根据列名获取对应数据表中的数据
						Object columnVal = rs.getObject(columnName);

						// 3. 将数据表中得到的数据，封装进对象
						Field field = clazz.getDeclaredField(columnName);
						field.setAccessible(true);
						field.set(t, columnVal);
					}
					return t;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// 关闭资源
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

			return null;
		}

}

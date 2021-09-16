package statement.crud_02;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import org.junit.Test;

public class StatementTest {

	// ʹ��Statement�ı׶ˣ���Ҫƴдsql��䣬���Ҵ���SQLע�������
	//��α���sqlע�룺ֻҪ��PreoaredStatement(��Statement��չ����)ȡ��statement
	/*
	 * ���˽��Statement��ƴ����sqlע������֮�⣬PreparedStatement������Щ�ô���
	 * 1.
	 */
	@Test
	public void testLogin() {
		Scanner scan = new Scanner(System.in);

		System.out.print("�û�����");
		String userName = scan.nextLine();
		System.out.print("��   �룺");
		String password = scan.nextLine();

		// SELECT user,password FROM user_table WHERE USER = '1' or ' AND PASSWORD = '='1' or '1' = '1';
		
		String sql = "SELECT user,password FROM user_table WHERE USER = '" + userName + "' AND PASSWORD = '" + password + "'";
		User user = get(sql, User.class);
		if (user != null) 
		{
			System.out.println("��½�ɹ�!");
		} else {
			System.out.println("�û������������");
		}
	}
	
	@Test
	public void test()
	{
		
		System.out.println("SELECT user,password FROM user_table WHERE USER = '" + "1' or " + "'AND PASSWORD = '" +  " = '1' or '1' = '1"+ "'");
		
		//select user,password from user_table where user = '1' or 'and password' = '1' or '1' = '1'
	}

	/**
	 * ����ڲ�ͬ���ͨ�ò�ѯ���������ر��е�һ����¼
	 * @param sql
	 * @param clazz
	 * @return
	 */
	// ʹ��Statementʵ�ֶ����ݱ�Ĳ�ѯ����
	public <T> T get(String sql, Class<T> clazz) {
		T t = null;

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			// 1.���������ļ�
			InputStream is = StatementTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
			Properties pros = new Properties();
			pros.load(is);

			// 2.��ȡ������Ϣ
			String user = pros.getProperty("user");
			String password = pros.getProperty("password");
			String url = pros.getProperty("url");
			String driverClass = pros.getProperty("driverClass");

			// 3.��������
			Class.forName(driverClass);

			// 4.��ȡ����
			conn = DriverManager.getConnection(url, user, password);

			st = conn.createStatement();

			rs = st.executeQuery(sql);

			// ��ȡ�������Ԫ����
			ResultSetMetaData rsmd = rs.getMetaData();

			// ��ȡ�����������
			int columnCount = rsmd.getColumnCount();

			if (rs.next()) {

				t = clazz.newInstance();

				for (int i = 0; i < columnCount; i++) {
					// //1. ��ȡ�е�����
					// String columnName = rsmd.getColumnName(i+1);

					// 1. ��ȡ�еı���
					String columnName = rsmd.getColumnLabel(i + 1);

					// 2. ����������ȡ��Ӧ���ݱ��е�����
					Object columnVal = rs.getObject(columnName);

					// 3. �����ݱ��еõ������ݣ���װ������
					Field field = clazz.getDeclaredField(columnName);
					field.setAccessible(true);
					field.set(t, columnVal);
				}
				return t;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ر���Դ
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
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


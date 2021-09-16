package blob;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.junit.Test;

import bean.Customer;
import jdbc.util.JDBCUtils;

/**
 * 测试使用Preparedstatement操作Blob类型的数据
 * @author kkkkk
 *
 */
public class BlobTest 
{
	//向customers表中插入Blob类型的数据
	@Test
	public void test() throws Exception
	{
		Connection conn = JDBCUtils.getConnection();
		
		String sql = "insert into customers(name,email,birth,photo) values(?,?,?,?)";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setObject(1, "abc");
		ps.setObject(2, "abc.@qq.com");
		ps.setObject(3, "1988-05-30");
		
		FileInputStream is = new FileInputStream(new File("59801687_p0.png"));
		ps.setBlob(4, is);
		
		ps.execute();
		
		JDBCUtils.closeResource(conn, ps);
		
	}
	
	//查询数据表中的Blob字段
	@Test
	public void test1()
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		InputStream is = null;
		FileOutputStream fos = null;
		try {
			conn = JDBCUtils.getConnection();
			
			String sql = "select id,name,email,birth,photo from customers where id = ?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setObject(1, 25);
			
			rs = ps.executeQuery();
			
			
			
			if(rs.next())
			{
				
				//方式一
//			int id = rs.getInt(1);
//			String name = rs.getString(2);
//			String email = rs.getString(3);
//			Date birth = rs.getDate(4);
				
				//方式二
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date birth = rs.getDate("birth");
					
				Customer cust = new Customer(id,name,email,birth);
				
				
				
				//将Blob类型的字段下载下来，以文件的方式保存在本地
				Blob blob = rs.getBlob("photo");
				is = blob.getBinaryStream();
				
				fos = new FileOutputStream(new File("image.png"));
				
				byte[] buff = new byte[1024];
				int len;
				while((len = is.read(buff)) != -1)
				{
					fos.write(buff,0,len);
				}
				
				System.out.println(cust);
				
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			
			try 
			{
				if(is != null)
				is.close();
			} catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try 
			{
				if(is != null)
				fos.close();
			} catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			JDBCUtils.closeResource(conn, ps, rs);
		}
	}
	
	
}

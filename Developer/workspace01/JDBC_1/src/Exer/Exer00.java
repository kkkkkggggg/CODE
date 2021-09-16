package Exer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.junit.Test;

import jdbc.util.JDBCUtils;

public class Exer00 
{
	//�ӿ���̨�����ݿ�ı�customers�в���һ������
	@Test
	public void exer00() throws Exception
	{
		Connection conn = JDBCUtils.getConnection();
		
		String sql = "insert into customers(name,email,birth) values(?,?,?)";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = sdf.parse("1998-05-05");
		
		java.sql.Date date2 = new java.sql.Date(date.getTime());
		
		ps.setObject(1, "exer");
		ps.setObject(2, "exer@qqq.com");
		ps.setObject(3, date2);
		
		ps.execute();
		
		JDBCUtils.closeResource(conn, ps);
	}
	
	@Test
	public void tsetCUD()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("�������û���");
		String name = scan.next();
		
		System.out.println("����������");
		String email = scan.next();
		
		System.out.println("����������");
		String birth = scan.next();
		
		String sql = "insert into customers(name,email,birth) values(?,?,?)";
		
		int insertCount = CUD(sql,name,email,birth);
		if(insertCount > 0)
		{
			System.out.println("��ӳɹ�");
		}else
		{
			System.out.println("���ʧ��");
		}
	}
	
	//ͨ�õ���ɾ�Ĳ���
		public int CUD(String sql,Object ... obj)
		{
			//1.��ȡ����
			Connection conn = null;
			//2.��ȡPreparedStatement��ʵ��
			java.sql.PreparedStatement ps = null;
			try {
				conn = JDBCUtils.getConnection();
				ps = conn.prepareStatement(sql);
				
				
				if(obj.length == 0)
				{
					//���û��ռλ����ֱ��ִ�в���
					//4.ִ�в���
					ps.execute();
				}else
				{
					//�����ռλ���������ռλ��
					//3.���ռλ��
					for(int i = 0;i < obj.length;i++)
					{
						ps.setObject(i+1, obj[i]);
					}
					/*
					 * ps.execute();
					 * ���ִ�е��ǲ�ѯ�������з��ؽ������˷�������true
					 * ���ִ�е�����ɾ�Ĳ�����û�з���ֵ����˷�������false
					 */
					
					
//					ps.execute();
					return ps.executeUpdate();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
			{
				//5.�ر���Դ
				JDBCUtils.closeResource(conn, ps);
			}
			
			return 0;
		}
		
}

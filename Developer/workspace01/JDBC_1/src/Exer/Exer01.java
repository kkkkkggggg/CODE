package Exer;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import jdbc.util.JDBCUtils;

//��ϰ��
public class Exer01 
{
	//����һ����examstudent�������һ����¼
	@Test
	public void test()
	{
		String sql = "insert into examstudent(Type,IDCard,ExamCard,StudentName,Location,Grade) values(?,?,?,?,?,?)";
		
		Scanner scan = new Scanner(System.in);
		System.out.println("�����뿼������");//4
		int type = scan.nextInt();
		
		System.out.println("������ID��");//220123548975213658
		String idCard = scan.next();
		

		System.out.println("������׼��֤��");//200523164754006
		String examCard = scan.next();
		
		System.out.println("������ѧ����");//shit
		String studentName = scan.next();
		
		System.out.println("�������ַ");//nowhere
		String location = scan.next();
		
		System.out.println("������ɼ�");//90
		int grade = scan.nextInt();
		
		int cud = CUD(sql,type,idCard,examCard,studentName,location,grade);
		
		if(cud > 0)
		{
			System.out.println("��ӳɹ�");
		}else
		{
			System.out.println("���ʧ��");
		}
	}
	
	//��������������֤�Ż���׼��֤�Ų�ѯѧ���ĳɼ���Ϣ
	@Test
	public void test1()
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("������ѧ����׼��֤�Ż������֤��");
		String cardNum = scan.next();
		
		String sql = "select grade  from examstudent where idcard = ? or examcard = ?";
		
		List<Student> list = getMutilyInstance(Student.class,sql,cardNum,cardNum);
		
		if(list.size() == 0)
		{
			System.out.println("��������ȷ�����֤�Ż�׼��֤��");
			
		}else
		{
			list.forEach(System.out::println);
		}
	}
	
	//���������������֤��ɾ��ѧ����Ϣ
	@Test
	public void test2()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("������Ҫɾ����ѧ�������֤��");
		
		String IDCard = scan.next();
		
		String sql = "delete from examstudent where IDCard = ?";
		int cud = CUD(sql,IDCard);
		
		if(cud == 0)
		{
			System.out.println("���޴��ˣ�����������");
		}else
		{
			System.out.println("ɾ���ɹ�");
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
						
						
//						ps.execute();
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
			
			/**
			 * ����ڲ�ͬ�ı��ͨ�õĲ�ѯ���������ر��еĶ�����¼
			 * @param clazz
			 * @param sql
			 * @param args
			 * @return
			 */
			public <T> List<T>  getMutilyInstance(Class<T> clazz,String sql,Object ...args)
			{
				Connection conn = null;
				PreparedStatement ps = null;
				ResultSet resultSet = null;
				try {
					//����list�洢������¼
					List<T> list = new ArrayList();
					//��ȡ����
					conn = JDBCUtils.getConnection();
					
					
					//��ȡprepareStatementʵ��
					ps = conn.prepareStatement(sql);
					
					//���ռλ��
					for(int i = 0;i < args.length;i++)
					{
						ps.setObject(i + 1, args[i]);
					}
					//ִ��sql���
					resultSet = ps.executeQuery();
					
					//��ȡresultSetԪ���ݣ���ͨ��Ԫ���ݻ�ȡ��ѯ���ֶ������ֶθ���
					ResultSetMetaData rsmd = ps.getMetaData();
					int columnCount = rsmd.getColumnCount();
					
					while(resultSet.next())
					{
						T t = clazz.newInstance();
						
						for (int i = 1; i <= columnCount; i++)
						{
							//��ȡ��Ӧ����λ�õ��ֶ�ֵ
							Object columnValue = resultSet.getObject(i);
							
							//��ȡ�е�����getColumnName,���Ƽ�ʹ��
//							String columnName = rsmd.getColumnName(i);
							
							//��ȡ�еı���getColumnLabel
							String columnLabel = rsmd.getColumnLabel(i);
							
							//ͨ�����䷽ʽ��ȡ���ֶ�����Ӧ��Order���������
							
							
							Field field = clazz.getDeclaredField(columnLabel);
							field.setAccessible(true);
							
							
							
							//ͨ������Ϊorder�����Ը�ֵ
							field.set(t, columnValue);
							
						}
						
						list.add(t);
					}
					
					
					return list;			
					
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
				
				
				return null;
			}
			
}

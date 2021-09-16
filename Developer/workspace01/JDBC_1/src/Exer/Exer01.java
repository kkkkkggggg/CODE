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

//练习二
public class Exer01 
{
	//问题一：向examstudent表中添加一条记录
	@Test
	public void test()
	{
		String sql = "insert into examstudent(Type,IDCard,ExamCard,StudentName,Location,Grade) values(?,?,?,?,?,?)";
		
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入考试类型");//4
		int type = scan.nextInt();
		
		System.out.println("请输入ID号");//220123548975213658
		String idCard = scan.next();
		

		System.out.println("请输入准考证号");//200523164754006
		String examCard = scan.next();
		
		System.out.println("请输入学生名");//shit
		String studentName = scan.next();
		
		System.out.println("请输入地址");//nowhere
		String location = scan.next();
		
		System.out.println("请输入成绩");//90
		int grade = scan.nextInt();
		
		int cud = CUD(sql,type,idCard,examCard,studentName,location,grade);
		
		if(cud > 0)
		{
			System.out.println("添加成功");
		}else
		{
			System.out.println("添加失败");
		}
	}
	
	//问题二：根据身份证号或者准考证号查询学生的成绩信息
	@Test
	public void test1()
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("请输入学生的准考证号或者身份证号");
		String cardNum = scan.next();
		
		String sql = "select grade  from examstudent where idcard = ? or examcard = ?";
		
		List<Student> list = getMutilyInstance(Student.class,sql,cardNum,cardNum);
		
		if(list.size() == 0)
		{
			System.out.println("请输入正确的身份证号或准考证号");
			
		}else
		{
			list.forEach(System.out::println);
		}
	}
	
	//问题三：根据身份证号删除学生信息
	@Test
	public void test2()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入要删除的学生的身份证号");
		
		String IDCard = scan.next();
		
		String sql = "delete from examstudent where IDCard = ?";
		int cud = CUD(sql,IDCard);
		
		if(cud == 0)
		{
			System.out.println("查无此人，请重新输入");
		}else
		{
			System.out.println("删除成功");
		}
	}
	
	
	//通用的增删改操作
			public int CUD(String sql,Object ... obj)
			{
				//1.获取连接
				Connection conn = null;
				//2.获取PreparedStatement的实例
				java.sql.PreparedStatement ps = null;
				try {
					conn = JDBCUtils.getConnection();
					ps = conn.prepareStatement(sql);
					
					
					if(obj.length == 0)
					{
						//如果没有占位符则直接执行操作
						//4.执行操作
						ps.execute();
					}else
					{
						//如果有占位符，则填充占位符
						//3.填充占位符
						for(int i = 0;i < obj.length;i++)
						{
							ps.setObject(i+1, obj[i]);
						}
						/*
						 * ps.execute();
						 * 如果执行的是查询操作，有返回结果，则此方法返回true
						 * 如果执行的是增删改操作，没有返回值，则此方法返回false
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
					//5.关闭资源
					JDBCUtils.closeResource(conn, ps);
				}
				
				return 0;
			}
			
			/**
			 * 针对于不同的表的通用的查询操作，返回表中的多条记录
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
					//创建list存储多条记录
					List<T> list = new ArrayList();
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
					
					//获取resultSet元数据，再通过元数据获取查询的字段名和字段个数
					ResultSetMetaData rsmd = ps.getMetaData();
					int columnCount = rsmd.getColumnCount();
					
					while(resultSet.next())
					{
						T t = clazz.newInstance();
						
						for (int i = 1; i <= columnCount; i++)
						{
							//获取对应索引位置的字段值
							Object columnValue = resultSet.getObject(i);
							
							//获取列的列名getColumnName,不推荐使用
//							String columnName = rsmd.getColumnName(i);
							
							//获取列的别名getColumnLabel
							String columnLabel = rsmd.getColumnLabel(i);
							
							//通过反射方式获取与字段名对应的Order类的属性名
							
							
							Field field = clazz.getDeclaredField(columnLabel);
							field.setAccessible(true);
							
							
							
							//通过反射为order的属性赋值
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

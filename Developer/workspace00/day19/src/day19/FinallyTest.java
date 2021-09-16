package day19;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

/*
 * try-catch-finally中finally的使用
 * 
 * 1.finally是可选的
 * 2.finally中声明的是一定会被执行的代码，即使catch中又出现了异常
 * try中有return;	等情况时，仍然会被执行
 * 
 * 3.像数据库连接、输入、输出流、网络编程Socket等资源,JVM是不能自动
 * 回收的，我们需要自己手动的进行资源的释放，此时资源的释放，就要声明
 * 在finall里
 */
public class FinallyTest
{
	
	@Test
	public void test2()
	{
		FileInputStream fis = null;
		try
		{
			File file = new File("hello.txt");
			fis = new FileInputStream(file);
			
			int data = fis.read();
//			System.out.println(data);
			while(data != -1)
			{
				System.out.print((char)data);
				data = fis.read();
			}
			
			
		}catch(FileNotFoundException e)
		{
			e.getMessage();
		}catch(IOException e)
		{
			e.getMessage();
		}finally
		{
			try
			{
				if(fis != null)
				fis.close();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	@Test
	public void testMethod()
	{
		int num = method();
		System.out.println(num);
	}
	
	
	public int method()
	{	
		try
		{
			int[] arr = new int[10];
			System.out.println(arr[10]);
			return 1;
		}catch(ArrayIndexOutOfBoundsException e)
		{
			e.printStackTrace();
			return 2;
		}finally
		{
			System.out.println("我一定会被执行");
		}
	}
	
	
	@Test
	public void test1()
	{
		try
		{
			int a = 10;
			 int b = 0;
			 System.out.println(a / b);
		}catch(ArithmeticException e)
		{
//			e.printStackTrace();
			int[] arr = new int[10];
			System.out.println(arr[10]);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
//		System.out.println("xxxxxxxxx");
		
		finally
		{
			System.out.println("xxxxxxxxxx");
		}
		 
	}
}

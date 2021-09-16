package day19;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Scanner;

import org.junit.Test;

/*
 * 一、异常的体系结构
 * 
 * java.lang.Throwable
 * 		----java.lang.Error:一般不编写针对性的代码进行处理
 * 		----java.lang.Exception：可以进行异常处理
 * 			---编译时异常(checked)
 * 				---IOException
 * 					---FileNotFoundException
 * 				---ClassNotFoundException
 * 			---运行时异常(unchecked,RunTimeException)
 * 				---NullPointerException
 * 				---ArrayIndexOutOfBoundsException
 * 				---ClassCastException
 * 				---NumberFormatException
 * 				---InputMismatchException
 * 				---ArithmeticException
 */
public class ExceptionTest
{
	//*****************************以下是编译时异常************************
	@Test
	public void test7()
	{
//		File file = new File("hello.txt");
//		FileInputStream fis = new FileInputStream(file);
//		
//		int data = fis.read();
//		while(data != -1)
//		{
//			System.out.println((char)data);
//			data = fis.read();
//		}
//		
//		fis.close();
	}
	
	
	
	
	//*****************************以下是运行时异常************************
	//NullPointerException
	@Test
	public void test1()
	{
		String arr = "abc";
		arr = null;
		arr.charAt(0);
		
	}
	
	//ArrayIndexOutOfBoundsException
	@Test
	public void test2()
	{
//		int[] arr = new int[5];
//		System.out.println(arr[5]);
		
		//StringIndexOutOfBoundsException
		String s = "abc";
		System.out.println(s.charAt(4));
	}
	
	
	//ClassCastException
	@Test
	public void test3()
	{
		Object obj = new Date();
		String str = (String)obj;
	}
	
	//NumberFormatException
	@Test
	public void test4()
	{
		String str = "123";
		int num = Integer.parseInt(str);
		String s = "abc";
		int num1 = Integer.parseInt(s);//NumberFormatException
		
	}
	
	
	//InputMismatchException
	@Test
	public void test5()
	{
		Scanner scan = new Scanner(System.in);
		
		int score = scan.nextInt();
	}
	
	//ArithmeticException
	@Test
	public void test6()
	{
		int a = 1;
		int b = 0;
		System.out.println(a / b);
	}
	
}

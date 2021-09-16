package day19;
/*
 * 异常处理的方式二：throws + 异常类型
 * 
 * 1."throws + 异常类型"写在方法的声明处，指明此方法执行时可能会出现的异常类型
 * 	一旦方法体执行时，出现异常，仍会在异常代码处生成一个异常对象，此对象满足throws
 * 后异常类型时，就会被抛出
 * 
 * 2.体会：try-catch-finally：真正的将异常给处理掉了
 * 			throws的方式只是把异常抛给了方法的调用者，并没有真正的处理掉异常
 * 
 *  3.开发中如何选择try-catch-finally 还是使用finally
 *  	3.1 如果父类中被重写的方法没有throws方式处理异常，则子类重写的方法也不能使用
 *  	throws，意味着如果子类方法中有异常，必须使用try-catch-finally方式来处理
 *  
 *  	3.2	执行的方法中，先后又调用了另外的几个方法，这几个方法是递进关系执行的
 *  	我们建议这几个方法使用throws的方式进行处理，而执行的方法a可以考虑使用
 *  	try-catch-finally方式进行处理```
 * 
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class ExceptionTest2
{
	public static void main(String[] args)
	{
		try
		{
			method2();
		}
		 catch (IOException e)    
		{
			
			e.printStackTrace();
		}
		
		//method3();
		
	}
	
	
	public static void method3()
	{
		try
		{
			method2();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void method2() throws IOException
	{
		method1();
	}
	
	@Test
	public static void method1() throws FileNotFoundException,IOException
	{
		File file = new File("hello1.txt");
		FileInputStream fis = new FileInputStream(file);
		
		int data = fis.read();
		while(data != -1)
		{
			System.out.println((char)data);
			data = fis.read();
		}
		
		fis.close();
		
		System.out.println("hahahah");
	}
}

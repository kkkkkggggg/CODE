package day19;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

/*
 * 一、异常的处理：抓抛模型
 * 
 * 过程一：“抛”：程序在正常执行的过程中，一旦出现异常，就会在异常代
 * 码处生成一个对应异常类的对象
 * 
 * 
 * 		关于异常对象的产生：①系统自动生成的异常对象
 * 							②手动的生成一个异常对象并抛出(throw)
 * 
 * 过程二：“抓”：可以理解为异常的处理方式：①try-catch-finally 
 * ②throws
 * 
 * 二、try-catch-finally的使用
 * 
 * try
 * {
 * 		//可能出现异常的代码
 * }catch(异常类型1 变量名1)
 * {
 * 		//处理异常的方式一
 * }catch(异常类型2 变量名2)
 * {
 * 		//处理异常的方式二
 * }catch(异常类型3 变量名3)
 * {
 * 		//处理异常的方式三
 * }
 * ....
 * finally
 * {
 * 		//一定会执行的代码
 * }
 * 
 * 说明
 * 1.finally是可选的
 * 2.使用try将可能出现异常的代码包装起来，在执行过程中，就会生成一个
 * 对应异常类的对象，根据此对象的类型，去catch中进行匹配
 * 3.一旦try中的异常匹配到某个catch时，就进入catch中进行异常的处理
 * 一旦完成处理就跳出当前的try-catch结构(在没有写finally的情况下)
 * 继续执行其后的代码
 * 4.catch中的异常类型如果没有子父类关系，谁声明在上谁声明在下
 * 没有关系
 * catch中的异常类型如果满足子父类关系，则子类异常类型必须声明在
 * 父类异常的上面，否则报错
 * 
 * 5.常用的异常处理方式：①String getMassage(); ②printStackTrace
 * 
 * 6.在try结构中定义的变量，出了try结构以后，就不可以再调用
 * 可以在try-catch结构外声明，在try-catch结构内使用，但是此时
 * 一定要在声明时进行赋值，因为出现异常后可能导致变量没有赋值
 * 
 * 7.try-catch-finally结构可以相互嵌套
 * 
 * 体会1：使用try-catch-finally处理编译时异常，使得程序在编译时不再
 * 报错，但是运行时仍可能报错，相当于我们使用try-catch-finally
 * 将一个编译时可能出现的异常，延迟到运行时出现
 * 
 * 体会2. 开发中，由于运行时异常比较常见，所以我们通常不针对try-catch-finally了，
 * 针对编译时异常，我们一定要考虑异常的处理
 */
public class ExceptionTest1
{
	
	@Test
	public void test2()
	{
		try
		{
			File file = new File("hello.txt");
			FileInputStream fis = new FileInputStream(file);
			
			int data = fis.read();
			while(data != -1)
			{
				System.out.println((char)data);
				data = fis.read();
			}
			
			fis.close();
		}catch(FileNotFoundException e)
		{
			e.getMessage();
		}catch(IOException e)
		{
			e.getMessage();
		}
		
	}
	
	
	
	
	
	
	
	//NumberFormatException
		@Test
		public void test4()
		{
			
			String s = "abc";
			int num = 0;
			try
			{
				num = Integer.parseInt(s);
				System.out.println("hello-----1");
			}catch(NullPointerException e)
			{
				System.out.println("出现空指针异常了");
			}catch(NumberFormatException e)
			{
				//处理方式一
				//System.out.println("出现数值转换异常了");
				
				//处理方式二
				//System.out.println(e.getMessage());
				
				//处理方式三
				e.printStackTrace();
			}catch(Exception e)
			{
				System.out.println("出现异常了");
			}
			
			System.out.println(num);
			
			System.out.println("hello-----2");
		}
}

package day19exer;

import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * 方法重写的规则之一：
 * 子类重写的方法抛出的异常类型不大于父类被重写的方法抛出的异常类型
 * 父类没有抛异常，子类也不能抛出异常
 * 
 */
public class OverrideTest
{
	public void display(SuperClass s)
	{
		try
		{
			s.method();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}

class SuperClass
{
	public void method() throws IOException
	{
		
	}
	
}

class SubClass
{
	public void method() throws FileNotFoundException
	{
		
	}
}
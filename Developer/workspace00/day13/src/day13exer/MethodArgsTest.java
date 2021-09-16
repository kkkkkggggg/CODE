package day13exer;
/*
可变形参个数的方法
1.jdk 5.0 新增的内容
2.具体使用
	2.1 可变个数形参的格式:数据类型 ... 变量名
	2.2当调用可变个数形参的方法时，传入参数的个数可以是0、1、2.....
	2.3可变个数形参的方法与本类中方法名相同，形参不同的方法之间构成重载
	2.4可变个数形参的方法与本类中变量类型相同的数组不能共存，因为可变
	个数形参可以看成是一个数组
	2.5可变个数形参在一个方法的多个形参中必须声明在末尾
	2.6可变个数形参的方法中最多只能有一个可变个数形参







*/
public class MethodArgsTest
{
	public static void main(String args[])
	{
		MethodArgsTest test = new MethodArgsTest();
		test.show(5);
		test.show("hello");
		test.show("hello" + "world");
		
		test.show(new String[]{"aa","bb","cc"});
	}
	public void show(int i)
	{
		
	}
	
//	public void show(String s)
//	{
//		System.out.println("show(String)");
//	}
	
	public void show(String ... strs)
	//在调用时不论输入几个参数都可以识别并调用
	{
		System.out.println("show(String ... strs )");
		for(int i = 0;i < strs.length;i++)
		{
			System.out.println(strs[i]);
//			(String ... strs)可以看成与(String[] strs)相等
		}
	}
//	(String ... strs)与(String[] strs)不共存
//	public void show(String[] strs)
//	{
//		
//	}

}

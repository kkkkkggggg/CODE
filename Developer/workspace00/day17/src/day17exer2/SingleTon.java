package day17exer2;
/*
 * 单例设计模式
 * 1.所谓类的单例设计模式，就是采取一定的方法保证在整个的软件系统中，对某
 * 个类只能存在一个对象实例，并且该类只提供一个取得其对象实例的方法。
 * 
 * 2.如何实现
 * 饿汉式 VS 懒汉式
 * 
 * 3.区分饿汉式和懒汉式
 * 		饿汉式：
 * 			坏处：对象加载时间过长
 * 			好处：饿汉式是线程安全的
 * 		懒汉式：
 * 			好处：延迟对象的创建
 * 			坏处：目前的写法是线程不安全的。--->到多线程内容时再修改 
 * 

*/
public class SingleTon
{
	public static void main(String args[])
	{
		Bank bank1 = Bank.getInstance();
		Bank bank2 = Bank.getInstance();
		System.out.println(bank1 == bank2);//true,是同一个对象，地址值相同
		
	}
}


//饿汉式
class Bank
{
	//1.私有化类的构造器
	private Bank()
	{
		
	}
	
	//2.内部创建类的对象
	//4.要求此对象也必须声明为静态的
	private static Bank instance = new Bank();
	
	//3.提供公共的静态的方法，返回类的对象
	public static Bank getInstance()
	{
		return instance;
	}
}

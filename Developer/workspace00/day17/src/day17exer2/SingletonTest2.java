package day17exer2;

public class SingletonTest2
{
	public static void main(String args[])
	{
		Order order1 = Order.getInstance();
		Order order2 = Order.getInstance();
		System.out.println(order1 == order2);
	}
	
	
}

//懒汉式
class Order
{
	
	//1.私有化类的构造器
	private Order()
	{
		
	}
	
	//2.声明当前类对象，没有初始化
	private static Order instance = null;
	
	
	//3.声明public static 的返回当前类对象的方法
	public static Order getInstance()
	{
		if(instance == null)
		{
			instance = new Order();
		}
			return instance;
	}
	
}




























//饿汉式
class Test
{
	private Test()//私有化类的构造器
	{
		
	}
	//创建的类的对象和get对象的方法必须是static的
	private static Test instance = new Test();//在类的内部创建对象
	
	public static Test getInstance()//提供对象的get方法
	{
		return instance;
	}
	
	
}

//懒汉式
class Test1
{
	private Test1()//私有化类的构造器
	{
		
	}
	
	private static Test1 instance = null;//声明类的实例，但是不赋值
	
	public static Test1 getInstance()//提供类的对象的get方法，在需要用到类的对象时再去创建对象
	{
		if(instance == null)
		{
			return instance = new Test1();
		}
		return instance;
	}
}
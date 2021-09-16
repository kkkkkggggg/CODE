package day18exer3;
/*
 * 类的内部成员之五：内部类
 * 1.Java中允许将一个类A声明在另一个类B中，则类A就是内部类，类B称为外部类
 * 
 * 2.内部类的分类：成员内部类(静态、非静态) VS 局部内部类(方法内、代码块内、构造器内)
 * 
 * 3.成员内部类：
 * 		一方面，作为外部类的成员：
 * 			>调用外部类的结构
 * 			>可以用static修饰
 * 			>可以被四种不同的权限修饰符修饰
 * 			>
 * 		另一方面，作为一个类：
 * 			>类内可以定义属性、方法、构造器等
 * 			>可以被final修饰，表示此类不能被继承，言外之意，不适用final，可以被继承
 * 			>可以被abstract修饰，表明此类不能被实例化
 * 
 * 4.关注如下三个问题
 * 		4.1如何实例化成员内部类的对象
 * 			
 * 		4.2如何在成员内部类中去区分调用外部类的结构
 * 			
 * 		4.3开发中局部内部类的使用,见《InnerClassTest.java》 
 * 			
 * 
 * 
 * 
 * 
*/			
public class InnerClassTest
{
	public static void main(String[] args)
	{
		//创建EE的实例(静态的成员内部类):
		Person.EE ee = new Person.EE();
		ee.ee();
		//创建DD的实例(非静态的成员内部类)
//		Person.DD dd = new Person.DD();错误的
		Person p = new Person();
		Person.DD dd = p.new DD();
		dd.dd();
		dd.display("大大");
		
		
		
	}
}

class Person
{
	
	String name = "person";
	int person;
	public void eat()
	{
		System.out.println("人吃饭");
	}
	
	//静态成员内部类，直接声明在外部类中
	static class EE
	{
		String name = "ee";
		int ee;
		
		public void ee()
		{
			System.out.println("ee人ee");
		}
	}
	
	//非静态成员内部类，直接声明在外部类中
	class DD
	{
		String name = "dd";
		int dd;
		
		public DD()
		{
			
		}
		
		public void dd()
		{
			System.out.println("dd人dd");
			eat();//可以调用外部类的非静态方法
			Person.this.eat();
			
		}
		
		public void display(String name)
		{
			System.out.println(name);//方法的形参
			System.out.println(this.name);//内部类的属性
			System.out.println(Person.this.name);//外部类的属性
			
		}
		
		
	}
	
	public Person()
	{
		//局部内部类，声明在外部类的构造器中
		class CC
		{
			
		}
	}
	public void method()
	{
		//局部内部类，声明在外部类的方法中
		class AA
		{
			
		}
	}
	
	{
		//局部内部类，声明在外部类的代码块中
		class BB
		{
			
		}
	}
	
	
}
package day14;
/*
类的结构之三：构造器（或构造方法、constructor）的使用
construct：建设、建造，construction：CCB constructor:建设者


一、构造器的作用
创建对象
初始化对象的信息

二、说明：
1、如果没有显式的定义构造器的话，则系统默认提供一个空参的构造器
2、定义构造器的格式：权限修饰符 类名(形参列表){}
3、一个类中定义的多个构造器彼此构成重载
4、一旦我们显式的定义了类的构造器之后，系统不再提供默认的空参构造器
5、一个类中，至少会有一个构造器
*/
public class PersonTest
{
	public static void main(String args[])
	{
		
		//创建类的对象时new + 构造器
		Person p = new Person();
		
		p.eat();  
	}
}

class Person
{
	//属性
	String name;
	int age;
	
	//构造器
	public Person()
	{
		System.out.println("Person().....");
	}
	
	public Person(String n)
	{
		name = n;//构造器可以初始化属性
	}
	
	
	//方法
	public void eat()
	{
		System.out.println("人吃饭");
	}
	
	public void study()
	{
		System.out.println("人可以学习");
	}
}
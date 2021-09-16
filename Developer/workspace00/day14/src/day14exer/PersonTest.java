package day14exer;
/*
this关键字的使用
1、this可以用来修饰：属性、方法、构造器

2、this修饰属性和方法
	this理解为：当前对象
	
	2.1、在类的方法中，我们可以使用“this.属性”或“this.方法”的方式，
	调用当前对象的属性或方法，但是通常情况下我们选择省略“this”
	特殊情况下，当方法内的形参和属性重名时，我们显式的使用“this.变量”
	的方式，表示此变量时属性，而非形参
	
	2.2、在类的构造器中，我们可以使用“this.属性”或“this.方法”的方式，
	调用当前对象的属性或方法，但是通常情况下我们选择省略“this”
	特殊情况下，当方法内的形参和属性重名时，我们显式的使用“this.变量”
	的方式，表示此变量时属性，而非形参
	
3、this调用构造器
	①我们在类的构造器中，可以显式的使用“this(形参列表)”方式，调用本类
	中指定的其他构造器
	②构造器中不能使用“this(形参列表)”调用自己
	③如果一个类中有n个构造器，最多有n-1个构造器中使用“this(形参列表)”
	④构造器内部只能调用一个其他的同一个类中的构造器，且“this(形参列表)”
	必须写在构造器中的第一行

*/
public class PersonTest
{
	public static void main(String args[])
	{
		Person p1 = new Person();
		p1.setAge(2);
		System.out.println(p1.getAge());
		
		Person p2 = new Person("tom", 34);
		System.out.println(p2.getAge());
	}
}

class Person
{
	private String name;
	private int age;
	
	public Person()
	{
//		this.getAge();
//		Person初始化时，需要考虑如下的1，2，3，4...(共40行代码)
		String info = "Person初始化时，需要考虑如下的1，2，3，4...(共40行代码)";
		System.out.println(info);
	}
	
	public Person(int age)
	{
		this.age = age;
//		Person初始化时，需要考虑如下的1，2，3，4...(共40行代码)
	}
	
	public Person(String name)
	{
		this();//在一个构造器中调用另一个构造器:调用空参构造器
		this.name = name;
//		Person初始化时，需要考虑如下的1，2，3，4...(共40行代码)
	}
	
	public Person(String name,int age)
	{
		this(age);//在构造器中调用另一个构造器：调用有形参的构造器
		this.name = name;
//		this.age = age;
//		Person初始化时，需要考虑如下的1，2，3，4...(共40行代码)
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public int getAge()
	{
		return age;
	}
}
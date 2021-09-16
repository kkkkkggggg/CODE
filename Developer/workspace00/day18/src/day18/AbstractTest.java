package day18;
/*
 * abstract关键字的使用
 * 
 * 1.抽象的
 * 2.abstract可以用来修饰结构、类、方法
 * 3.abstract修饰类：抽象类
 * 		>此类不能实例化
 * 		>抽象类中一定有构造器，便于子类对象实例化时调用（涉及：子类对象实例化的全过程）
 * 		>开发中，都会提供抽象类的子类，让子类实例化，完成相关操作
 * 4.abstract修饰方法：抽象方法
 * 		>抽象方法，只有方法声明，没有方法体
 * 		>包含抽象方法的类，一定是一个抽象类，反之抽象类中可以没有抽象方法
 * 		>若子类重写了父类中所有的抽象方法后，此子类方可实例化
 * 		>若子类没有重写父类中所有的抽象方法，则此子类也是抽象类，需使用abstract修饰
*/
public class AbstractTest
{
	public static void main(String args[])
	{
		//一旦Person类抽象了，就不可实例化
//		Person p1 = new Person();
//		p1.eat();
	}
}


abstract class Creature
{
	public abstract void breath();
}


abstract class Person extends Creature
{
	int age = 1;
	String name;
	public Person()
	{
		
	}
	
	public abstract void eat();//抽象类
	
//	public abstract void eat()  不是抽象类
//	{
//		
//	}
	
//	public void eat()
//	{
//		System.out.println("吃饭");
//	}
	
//	public abstract void breath();
	
	public void walk()
	{
		System.out.println("走路");
	}
	
	
}


class Student extends Person
{
	String name;
	int age;
	
	public Student()
	{
		
	}
	
	public Student(String name,int age)
	{
		this.name = name;
		this.age = age ;
	}
	
	
	public void eat()
	{
		System.out.println("学生吃饭");
	}
	
	public void walk()
	{
		System.out.println("学生走路");
	}
	
	public void breath()
	{
		System.out.println("学生呼吸");
	}
}
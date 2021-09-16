package day15;

public class Person
{
	String name;
	
	int age;
	
	public Person()
	{
		
	}
	
	public Person(String name,int age)
	{
		this.age = age;
		this.name = name;
	}
	
	public void eat()
	{
		System.out.println("吃饭");
	}
	
	public void sleep()
	{
		System.out.println("睡觉");
	}
}

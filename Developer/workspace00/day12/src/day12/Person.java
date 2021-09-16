package day12;

public class Person
{
	public static void main(String args[])
	{
		Personal p1 = new Personal();
		p1.name = "Tom";
		p1.age = 2;
		p1.sex = "male";
		p1.study();
		
		p1.showAge();
		int newAge = p1.addAge(2);
		System.out.println(p1.name + "的新年龄为" + newAge);
		//*********************************
		Personal p2 = new Personal();
		p2.showAge();
	}
}
class Personal
{
	String name;
	int age;
	String sex;
	public void study()
	{
		System.out.println("studying");
	}
	public void showAge()
	{
		System.out.println("age=" + age);
	}
	
	public int addAge(int i)
	{
		age += i;
		return age;
			
	}

}
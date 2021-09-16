package day12;

/*
一、设计类就是设计类的成员

属性 = 成员变量 = field = 域、字段

方法 = 成员方法 = 函数 = method

创建类的对象 = 类的实例化 = 实例化类

二、类和类的对象（面向对象思想落地的实现）
1.创建类，设计类的成员
2.创建类的对象
3.通过“对象.属性”或“对象.方法”调用对象的结构

三、如果创建了一个类的多个对象，则每个对象拥有一套类的属性（非staitc的）
如果修改一个对象的属性不会影响另一个对象的属性
*/
//测试类
public class PersonTest
{
	public static void main(String args[])
	{
	//创建Person类的对象
	Persona p1 = new Persona();
	//Scanner scan = new Scanner(System.in);
	
	//调用对象的结构：属性、方法
	
	p1.name = "Tom";
	p1.isMale = true;
	System.out.println(p1.name);
	
	//调用方法：“对象、方法”
	p1.eat();
	p1.sleep();
	p1.talk("Chinese");
	}
}

class Persona
//属性
{
	String name;
	int age;
	boolean isMale;
	
	//方法
	public void eat()
	{
		System.out.println("人可以吃饭");
	}
	
	public void sleep()
	{
		System.out.println("人可以睡觉");
	}
	public void talk(String language)
	{
		System.out.println("人可以交流" + language);
	}
	
}

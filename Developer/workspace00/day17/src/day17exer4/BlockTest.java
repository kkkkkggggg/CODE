package day17exer4;
/*
 * 类的成员之四：代码块(初始化块)
 * 1.代码块的作用：用来初始化类、对象
 * 2.代码块如果有修饰的话，只能用static
 * 
 * 3.分类：静态代码块 VS 非静态代码块
 * 
 * 4.静态代码块
 * 		>内部可以有输出语句
 * 		>随着类的加载而执行,而且只执行一次，只要当前类没有重新加载，就不会加载
 * 		>作用：初始化类的信息
 * 		>如果一个类中定义了多个静态代码块，则按照声明的先后顺序执行
 * 		>静态代码块的执行要优先于非静态代码块的执行
 * 		>静态代码块内只能调用静态的属性、方法，不能调用非静态的结构		
 * 
 * 
 * 
 * 5.非静态代码块
 * 		>内部可以有输出语句
 * 		>随着对象的创建而执行，每创建一个对象就执行一次
 * 		>作用：可以在创建对象时对对象的属性等进行初始化
 * 		>如果一个类中定义了多个非静态代码块，则按照声明的先后顺序执行
 * 		>非静态代码块内可以调用静态的或非静态的属性、方法
 * 
 * 对属性可以赋值的位置
 * ①默认初始化
 * ②显式初始化
 * ③构造器中初始化
 * ④有了对象以后，可以通过 “对象.属性”或“对象.方法”的方式进行赋值
 * ⑤在代码块中赋值 
*/
public class BlockTest
{
	public static void main(String[] args)
	{
		String desc = Person.desc;
		Person p1 = new Person();
		Person p2 = new Person();
		System.out.println(p1.age);
	}
}

class Person
{
	//属性
	String name;
	int age;
	static String desc = "人";
	
	//构造器
	public Person()
	{
		
	}
	
	public Person(String name,int age)
	{
		this.age = age;
		this.name = name;
		
	}
	
	//代码块：用static修饰，静态代码块
	static
	{
		System.out.println("hello,static block-1");
		//只能调用静态的结构
		//eat();
		desc = "我是一个爱学习的人";
		System.out.println(desc);
		info();
	}
	
	static
	{
		System.out.println("hello,static block-2");
		desc = "我是一个爱学习的人";
		System.out.println(desc);
	}
	
	//代码块：无修饰，非静态代码块
	{
		System.out.println("hello,notstatic block-2");
		age = 1;
	}
	
	{
		System.out.println("hello,notstatic block-1");
		//调用非静态结构
		age = 1;
		eat();
		//调用静态结构
		desc = "我是一个爱学习的人";
		info();
	}
	
	//方法
	public void eat()
	{
		System.out.println("吃饭");
	}

	@Override
	public String toString()
	{
		return "Person [name=" + name + ", age=" + age + ", desc=" + desc + "]";
	}
	
	public static void info()
	{
		System.out.println("我是 一个快乐的人");
	}
	
	
}

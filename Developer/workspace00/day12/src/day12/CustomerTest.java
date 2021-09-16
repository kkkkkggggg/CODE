package day12;
/*
类中方法的声明和使用
方法：描述类具有的功能
例如：Math类：sqrt()\random()\...
	 Scanner类：nextInt\.....
	 Array类：sort()\binarySearch()\toString()\equals()
	 
1.举例
public void eat(){}  //void : 没有返回值
public void sleep(int hour){}
public String getName(){}  //String : 返回值为String类型的数据
public String getNation(String nation){}

2.方法的声明：权限修饰符 返回值类型 方法名(形参列表)
				{
					方法体
				}
static\final\abstract 来修饰的方法以后再学
形参列表可有可无且可以有多个

3.说明
	3.1关于权限修饰符
		Java规定的4种权限修饰符：private、public、缺省、protected
	3.2返回值类型：有返回值 VS 无返回值
		3.2.1如果方法有返回值则必须在方法声明时指定返回值的类型，
			同时方法中要使用return语句来返回指定类型的数据
		   如果方法没有返回值，在方法声明时使用void来表示，通常，没有
		   返回值的方法中不需要使用return，如果要使用的话只能使用:
		   return;//起到结束方法的作用
		3.2.2定义方法该不该有返回值
		①题目要求
		②凭经验，具体分析需不需要有返回值
	3.3方法名
		属于标识符，在命名时要遵循标识符的规则规范
	3.4形参列表：方法可以声明0个、1个或多个形参
		3.4.1格式：数据类型1 形参1,数据类型2 形参2,数据类型3  形参3.。。。。。
		
		3.4.2定义方法时要不要形参
			①题目要求
			②凭经验
	3.5方法体：方法功能的体现  
	
	4.return关键字的使用
	1.使用范围：使用在方法体中
	2.作用：①结束方法
			②针对有返回值的方法，使用“return 数据”方法返回数据
	3.return关键字后不可以声明执行语句
	
	5.方法的使用中，可以调用当前类的属性或方法
*/
public class CustomerTest
{
	public static void main(String args[])
	{
		Customer cust1 = new Customer();
		cust1.eat();
	}
}
//客户类
class Customer
{
	String name;
	int age;
	boolean isMale;
	
	//方法
	public void eat()
	{
		System.out.println("客户吃饭");
		return;//return后不可声明表达式
	}
	
	public void sleep(int hour)
	{
		System.out.println("休息了" + hour + "个小时");
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getNation(String nation)
	{
		String info = "我的国籍是" + nation;
		return info;
	}
}

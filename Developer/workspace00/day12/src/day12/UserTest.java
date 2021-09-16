package day12;
/*
类中属性的使用

属性（成员变量） VS 局部变量
1.相同点
	1.1定义变量的格式：数据类型 变量名 = 变量
	1.2先声明 后使用
	1.3变量都有其作用域


2.不同点
	2.1在类中声明的位置不同
	属性：直接定义在类的一对{}内
	局部变量：声明在方法内、方法形参、构造器形参、构造器内部的变量
	
	2.2关于权限修饰符的不同
	属性：可以在声明属性时，使用权限修饰符
		常用的权限修饰符：private\public\缺省(不使用权限修饰符)\protected
		局部变量不可以使用权限修饰符
	
	2.3默认初始化值的情况
	属性：类的属性根据其类型都有初始化值
		整型（byte、short、 int、long）：0
		浮点型（float、double）：0.0
		char ：ASCII 码中的0或'/u000'
		boolean ： false
		引用数据类型（类、数组接口） ：null
	局部变量：没有默认的初始化值
		在调用局部变量之前必须要显式赋值
		特别的：形参在调用时进行赋值
		
	2.4在内存中加载的位置：
	属性：加载到堆空间中（非static）
	局部变量：加载到栈空间中
	
*/
public class UserTest
{

}
class User
{
	String name;
	int age;
	boolean isMale;
	
	public void talk(String language)//String language 方法形参，也是局部变量
	{
		System.out.println("我们使用" + language + "进行交流");
	}
	
	public void eat()
	{
		String food = "烙饼";//局部变量，声明在方法内
		System.out.println("北方人喜欢吃" + food);
	}
}





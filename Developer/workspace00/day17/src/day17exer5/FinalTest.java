package day17exer5;
/*
 * final:最终的
 * 
 * 1.final可以用来修饰的结构：类、方法、变量
 * 
 * 2.final用来修饰一个类:此类不能被其他类所继承。
 * 				比如String类，System类，StringBuffer类
 * 
 * 3.final用来修饰方法：表明此方法不可以被重写
 * 				比如：Object类中的getClass()方法
 * 
 * 4.final用来修饰变量：此时”变量“就称为是一个常量，不能再变了
 * 			4.1final修饰属性，可以考虑赋值的位置有：显式初始化、代码块中初始化
 * 				构造器中初始化
 * 			4.2final修饰局部变量
 * 				尤其是final修饰形参时，表明此形参是一个常量，当我们调用此方法时
 * 				，给常量形参赋一个实参，一旦赋值以后，就只能再方法体内使用此形参
 * 				但不能进行重新赋值
 * 				
 * static final 用来修饰常量：全局常量
 * 
*/
public class FinalTest
{
	public static void main(String[] args)
	{
		FinalTest f1 = new FinalTest(2);
		
		FinalTest f2 = new FinalTest(5);
		
		System.out.println(f1.RIGHT + "  " + f2.RIGHT);
		
		f1.show(10);
		
		
	}
	
	
	
	final int WIDTH = 10;
	final int LEFT;
	final int RIGHT;
//	final int DOWN;
	
	public FinalTest()
	{
		RIGHT = 2;
	}
	
	public FinalTest(int n)
	{
		RIGHT = n;
	}
	
	
//	public void setDown(int down)   
//	{
//		this.DOWN = down;
//	}
	
	{
		LEFT = 1;
	}
	
	public void show()
	{
		final int NUM = 10;//常量
		//NUM += 20;
	}
	
	public void show(final int num)
	{
		System.out.println(num);
		//num = 20;
	}
	
//	public void doWidth()
//	{
//		width = 20;
//	}
	
}

final class FinalA
{
	
}

//class B extends FinalA
//{
//	
//}

class AA
{
	public final void show()
	{
		
	}
}

//class BB extends AA
//{
//	public void show()
//	{
//		
//	}
//}


//练习：单例模式，懒汉式
class DanLi
{
	private DanLi()
	{
		
	}
	
	private static DanLi instance = new DanLi();
	
	public static DanLi getInstance()
	{
		return instance;
	}
}

class DanLi2
{
	private DanLi2()
	{
		
	}
	
	private static DanLi2 instance = null;
	
	public static DanLi2 getInstance()
	{
		if(instance == null)
		{
			return instance = new DanLi2();
		}
		return instance;
	}
	
}

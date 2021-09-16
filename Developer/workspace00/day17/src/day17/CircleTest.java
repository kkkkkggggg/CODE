package day17;
//static关键字的应用 
public class CircleTest
{
	public static void main(String args[])
	{
		Circle c1 = new Circle();
		
		Circle c2 = new Circle();
		
		Circle c3 = new Circle(3.4);
		
		System.out.println(c1.getId());
		System.out.println(c2.getId());
		
		System.out.println(Circle.getTotal());
	}
}

class Circle
{
	private double radius;
	private int id;
	
	public Circle()//每创建一个对象，在创建时对id进行赋值，每次id的数值加一
	{
		id = init++;
		total++;//每创建一个对象就会调用一次构造器，同时total增加一，用于计算总共创建了几个对象
	}
	
	public Circle(double radius)
	{
		this();//调用空参构造器，使用空参构造器里的id = init++; 和total++;实现id的赋值和计算总数
		this.radius = radius;
		
//		id = init++;//直接在构造器内对属性id和静态属性total进行操作
//		total++;
	}
	
	private static int total;
	private static int init = 1001;
	
	
	
	public double getRadius()
	{
		return radius;
	}



	public void setRadius(double radius)
	{
		this.radius = radius;
	}



	public int getId()
	{
		return id;
	}



	public void setId(int id)
	{
		this.id = id;
	}



	public static int getTotal()
	{
		return total;
	}



	public static void setTotal(int total)
	{
		Circle.total = total;
	}



	public static int getInit()
	{
		return init;
	}



	public static void setInit(int init)
	{
		Circle.init = init;
	}



	public double findArea()
	{
		return Math.PI * radius * radius;
	}
}
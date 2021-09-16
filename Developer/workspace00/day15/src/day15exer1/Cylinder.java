package day15exer1;
/*
 * super关键字的使用
 * 1.super理解为：父类的
 * 2.super可以用来调用：属性、方法、构造器
 * 3.属性不会被覆盖，如果父类和子类中有两个同名属性，那么子类在调用
 * 该属性时默认是子类的属性，如果要在子类中调用父类的同名属性或重写的方法，
 * 必须显式的使用使用“super.属性”或“super.方法”调用
 *
 * 4.super来调用构造器
 * 	1.我们可以在子类的构造器中显式的使用“super(形参列表)”，的方式，调用父类声明的指定的构造器
 * 	2.“super(形参列表)”的使用，必须声明在子类构造器中的首行
 * 	3.我们在类的构造器中，针对于“this(形参列表)”或“super(形参列表)”只能二选一，不能同时出现
 * 	4.在构造器的首行，没有显式的声明“this(形参列表)” 或 “super(形参列表)”，则默认的调用的
 * 	是父类的空参构造器
 *  5.在类的多个构造器，至少有一个类的构造器使用了“super(形参列表)”，调用父类中的构造器
 *  
*/

public class Cylinder extends Circle
{
	private double length;

	public Cylinder()
	{
		this.length = 1;
	}
	
	public Cylinder (double length,double radius)
	{
		super(radius);//在子类中调用父类的构造器
		this.length = length;//thi(形参列表) 和 super(形参列表)只能出现一个
		
	}
	
	public double getLength()
	{
		return length;
	}

	public void setLength(double length)
	{
		this.length = length;
	}
	
	public double findVomule()
	{
		
		double vomule = super.findArea() * length;//这里要调用父类Circle中的findArea方法求圆柱的体积，但是子类中重写了findArea，此时
												  //使用super.findArea()来表示调用的是父类中的方法
				return vomule;
	}
	
	public double findArea()//返回圆柱的表面积,是对父类Circle中返回圆的面积的方法的重写
	{
		return 2 * super.findArea() + 2 * Math.PI * getRadius() * getLength();
	}
	
}

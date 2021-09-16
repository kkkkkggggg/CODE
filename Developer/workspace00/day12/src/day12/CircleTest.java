package day12;

public class CircleTest
{
	public static void main(String args[])
	{
		Circle c1 = new Circle();
		c1.radius = 4;
		double area = c1.getArea();
		System.out.println("面积为=" + area);
	}
}
class Circle
{
	//属性
	double radius;
	
	//求圆的面积
	
	public double getArea()
	{
		double area = 3.14 * radius * radius;
		return area;
	}
}
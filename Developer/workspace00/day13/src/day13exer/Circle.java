package day13exer;

public class Circle
{
	public static void main(String args[])
	{
		CircleTest test = new CircleTest();
		Circle c = new Circle();
		test.Test(c, 5);
		System.out.println("此时半径为：" + c.radius);
	}
	
	int radius;
	public double getArea()
	{
		return Math.PI * radius * radius;
	}
	
}
class CircleTest
{
	
	public void Test(Circle c,int time)
	{
		
		System.out.println("Radius\t\tArea");
		int i = 1;
		for(;i <= time;i++)
		{
			c.radius = i;
			System.out.println(c.radius + "\t\t" + c.getArea());
		}
		c.radius = i;
	}
}
package day15exer1;

public class Circle
{
	private double radius;
	
	public Circle()
	{
		this.radius = 1;
	}
	
	public Circle(double radius)
	{
		this.radius = radius;
	}

	
	public double getRadius()
	{
		return radius;
	}

	public void setRadius(double radius)
	{
		this.radius = radius;
	}
	
	//返回圆的面积
	public double findArea()
	{
		double area = radius * radius * Math.PI;
		
		return area;
	}
}

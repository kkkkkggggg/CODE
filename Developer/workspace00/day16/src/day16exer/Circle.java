package day16exer;

public class Circle extends GeometricObject
{
	private double radius;
	
	public Circle()
	{
		
	}
	
	public Circle(double radius,String color,double weight)
	{
		this.radius = radius;
		this.color = color;
		this.weight = weight;
	}

	public double getRadius()
	{
		return radius;
	}

	public void setRadius(double radius)
	{
		this.radius = radius;
	}
	
	public double findArea()
	{
		return Math.PI * radius * radius;
	}
}

package day16exer;

public class MyRectangle extends GeometricObject
{
	private double width;
	private double height;
	
	public MyRectangle(double width,double height,String color,double weight)
	{
		this.width = width;
		this.height = height;
		this.color = color;
		this.weight = weight;
		
		
	}

	public double getWidth()
	{
		return width;
	}

	public void setWidth(double width)
	{
		this.width = width;
	}

	public double getHeight()
	{
		return height;
	}

	public void setHeight(double height)
	{
		this.height = height;
	}
	
	public double findArea()
	{
		return width * height;
	}
}

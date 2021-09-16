package day16exer;

public class GeometricTest
{
	
	public static void main(String args[])
	{
		 GeometricTest test = new GeometricTest();
		 
		 boolean x = test.equalsArea(new Circle(4, "圆形", 10), new MyRectangle(5, 6, "矩形", 12));
		 System.out.println(x);
		 test.displayGeometricObject(new Circle(4, "圆形", 10));
		 test.displayGeometricObject(new MyRectangle(5, 6, "矩形", 12));
	}
	
	
	
	
	
	
	
	
	
	public boolean equalsArea(GeometricObject a,GeometricObject b)
	{
		if(a.findArea() == b.findArea())
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	
	public void displayGeometricObject(GeometricObject d)
	{
		System.out.println(d.findArea());
	}
}

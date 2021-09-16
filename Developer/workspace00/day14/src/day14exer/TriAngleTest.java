package day14exer;

public class TriAngleTest
{
	public static void main(String args[])
	{
		TriAngle a = new TriAngle();
		a.setBase(6);
		a.setHeight(7);
		TriAngle b = new TriAngle(6, 7);
		System.out.println("底边长是 " + a.getBase() + " 高是：" + a.getHeight() + " 面积是：" + a.getArea());
		System.out.println("底边长是 " + b.getBase() + " 高是：" + b.getHeight() + " 面积是：" + b.getArea());
	}
	
}

package day12;

public class ExerTest
{
	public static void main(String args[])
	{
		Exer ex = new Exer();
		ex.length = 10;
		ex.wide = 8;
		ex.build();
		int area = ex.getArea();
		System.out.println(area);
		System.out.println(ex.getArea());//输出时也可以调用方法
	}
}

class Exer
{
	
//	public int method(int length,int wide)
//	{
//		
//		for(int i = 0;i < length;i++)
//		{
//			for(int j = 0;j < wide;j++)
//			{
//				System.out.print("*  ");
//			}
//			System.out.println();
//		}
//		return length * wide;
//		
//	}一个方法可以同时有返回值和形参
	
	
	int length;
	int wide;
	public void build()
	{
		
		for(int i = 0;i < length;i++)
		{
			for(int j = 0;j < wide;j++)
			{
				System.out.print("*  ");
			}
			System.out.println();
		}
		
	}
	
	public int getArea()
	{
		int area = length * wide;
		return area;
	}
}
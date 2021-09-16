package day13exer;
/*
方法的重载（overload）loading
1.定义：在同一个类中允许存在一个以上的同名方法，只要他们的参数个数或
参数类型不同即可
"两同一不同"：同一个类，同一个方法名
		参数类型或参数个数不同
2.举例Array类中的重载sort()、binarySearch()

3.判断是否重载：
		跟方法的权限修饰符、返回值类型、形参变量名、方法体都没有关系

4.在通过对象调用方法时，如何确定一个指定的方法
		方法名--->参数列表


*/
public class OverLoadTest
{
	public void mOL(int a)//三个重载方法mOL
	{
		System.out.println(a * a);
	}
	
	public void mOL(int a,int b)
	{
		System.out.println(a * b);
	}
	
	public void mOL(String a)
	{
		System.out.println(a);
	}
	
	public void max(int a,int b)//三个重载方法max
	{
		int max = 0;
		if(a > b)
		{
			max = a;
		}else if(a < b)
		{
			max = b;
		}else
		{
			max = b;
		}
		System.out.println(max + "是最大的数");
		
	}
//	public int max(int a,int b)
//	{
//		return(i > j)? i : j;
//	}
//	
//	public double max(double a,double b)
//	{
//	return(i > j)? i : j;
//  }
//	
//	
//	
	public void max(double a,double b)
	{
		double max = 0;
		if(a > b)
		{
			max = a;
		}else if(a < b)
		{
			max = b;
		}else
		{
			max = b;
		}
		System.out.println(max + "是最大的数");
	}
	
	public void max(double a,double b,double c)
	{
		double max;
		if(a > b)
		{
			max = a;
		}else if(a < b)
		{
			max = b;
		}else
		{
			max = (a + b)/2;
		}
		double finalMax;
		if(max > c)
		{
			finalMax = max;
		}else if(max < c)
		{
			finalMax = c;
		}else
		{
			finalMax = (max + c)/2;
		}
		
		System.out.println(finalMax + "最大的数是");
	}
	
	public static void main(String args[])
	{
		OverLoadTest test = new OverLoadTest();
		test.max(5, 10);
		test.max(9.6, 8.5);
		test.max(2.1, 4, 3.2);
		test.mOL(6);
		test.mOL(5, 9);
		test.mOL("sex");
	}
}

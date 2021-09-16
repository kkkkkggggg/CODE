package test;

public class Test
{
	int a;
	double b;
	

	
	public Test(int a)
	{
		this.a = a;
	}
	
	public Test(double b)
	{
		this.b = b;
	}
	
	public Test(double b,int a)
	{
		this.b = b;
		this.a = a;
	}
	
	public Test()
	{
		System.out.println("我无处不在");// TODO Auto-generated constructor stub
	}

	public void getA()
	{
		System.out.println(a);
	}
	
	public void getB()
	{
		System.out.println(b);
	}
	
	public void getAB()
	{
		System.out.println(a + "" + b);
	}
}

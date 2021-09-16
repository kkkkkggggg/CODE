package test;

public class Test1 extends Test
{
	int c;
	double d;
	
	public Test1()
	{
		this(6);
	}
	
	public Test1(int c)
	{
		this(2.0);
		this.c = c;
	}
	
	public Test1(double d)
	{
		this.d = d;
	}
	
	public Test1(int c,double d)
	{
		this.c = c;
		this.d = d;
	}
	public static void main(String args[])
	{
		Test1 t = new Test1(6);
		t.getA();
		System.out.println(t.c + "  " + t.d);
		
	}
}

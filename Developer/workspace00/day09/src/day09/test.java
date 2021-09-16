package day09;

public class test
{
	public static void main(String args[])
	{
		int a = 3;
		int b = 8;
		int c = 12;
		int Max = (a > b)? ((a > c) ? a : c) : ((b > c)? b : c);
		System.out.println("Max=" + Max);
	}

}

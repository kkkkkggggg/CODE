package day18exer2;

public class Test
{
	public static void main(String[] args)
	{
		ComparableCircle c1 = new ComparableCircle(5);
		ComparableCircle c2 = new ComparableCircle(6);
		
		int r = c1.compareTo(c2);
		System.out.println(r);
		
		
	}
}


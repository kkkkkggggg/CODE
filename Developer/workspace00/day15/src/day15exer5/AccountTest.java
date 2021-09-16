package day15exer5;

public class AccountTest
{
	public static void main(String args[])
	{
		CheckAccount s = new CheckAccount(1122, 20000, 0.45, 5000);
		s.withDraw(5000);
		s.withDraw(18000);
		s.withDraw(3000);
	}
}

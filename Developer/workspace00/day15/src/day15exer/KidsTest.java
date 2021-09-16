package day15exer;
import java.util.Scanner;
public class KidsTest
{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		Kid someKid = new Kid();
		
		someKid.sex = 1;
		someKid.salary = 200;
		someKid.yearsOld = 10;
		someKid.manOrWoman();
		someKid.employeed();
		someKid.printYearsOld();
		
		System.out.println(scan.hasNextLine());
		
		String line = "1213245";
		System.out.println(line.length());
	}
}

package day09;
import java.util.Scanner;
public class ForTest01
{
	@SuppressWarnings("resource")
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入第一个数：");
		int num1 = scan.nextInt();
		System.out.println("请输入第二个数：");
		int num2 = scan.nextInt();
		int theSmallNumber = (num1 > num2)? num2 : num1;
		for(;;theSmallNumber--)
		{
			if(num1 % theSmallNumber == 0 && num2 % theSmallNumber == 0)
			{
				System.out.println("最大公约数是" + theSmallNumber);
				break;
			}	
		}
		
		for(int i = 1;;i++)
		{
			if(i % num1 == 0 && i % num2 == 0)
			{
				System.out.println("最小公倍数是" + i);
				break;
			}
			
		}
		
	}
}

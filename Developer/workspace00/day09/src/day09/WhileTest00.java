package day09;
import java.util.Scanner;
public class WhileTest00
{
	public static void main(String args[])
	{
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int positive = 0;
		int negetive = 0;
		System.out.println("请输入任意整数");
		for(;;)
		{
			int i = scan.nextInt();
			/*
			if(i == 0)
			{
				break;
			}
			if(i > 0)
			{
				positive++;记录整数个数
			}
			else
			{
				negetive++;记录负数个数
			}
			*/
			if(i > 0)
			{
				positive++;
			}else if(i < 0)
			{
				negetive++;
			}else
			{
				break;
			}
		}
		System.out.println("正数的个数为：" + positive + "负数的个数为：" + negetive);
	}
}

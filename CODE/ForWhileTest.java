/*
题目：从键盘读入个数不确定的整数，并判断读入的正数和负数的个数，输入为0时结束程序

说明：不在循环条件部分限制次数的结构：for(;;)或while（true）

结束循环有几种方式
一：循环条件部分返回false
二：在循环体中，执行break
*/
import java.util.Scanner;

class ForWhileTest 
{
	public static void main(String[] args) 
	{
		Scanner scan =new Scanner(System.in);

		int numPositive = 0;
		int numNegetive = 0;
		
		while (true)
		{
			int number = scan.nextInt();


			if (number > 0)
			{
				numPositive++;
			}
			else if (number < 0)
			{
				numNegetive++;
			}
			else
			{
				break;
			}
		}



		System.out.println("正数的个数:" + numPositive);
		System.out.println("负数的个数:" + numNegetive);
		

	}
}

package day09;
import java.util.Scanner;
public class SwitchTest
{
	public static void main(String args[])
	{
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("请输入年份：");
		int year = scan.nextInt();
		
		System.out.println("请输入月份：");
		int month = scan.nextInt();
		
		System.out.println("请输入这是哪一天：");
		int day = scan.nextInt();
		
		int dayOfFebruary;
		int sumDay = 0;
		
		if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
		{
			dayOfFebruary = 29;
		}
		else
		{
			dayOfFebruary = 28;
		}
		
		switch(month)
		{
			case 12:
				sumDay += 31;
			case 11:
				sumDay += 30;
			case 10:
				sumDay += 31;
			case 9:
				sumDay += 30;
			case 8:
				sumDay += 31;
			case 7:
				sumDay += 31;
			case 6:
				sumDay += 30;
			case 5:
				sumDay += 31;
			case 4:
				sumDay += 30;
			case 3:
				sumDay += 31;
			case 2:
				/*
				if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
				{
					sumDay += 29;
				}
				else
				{
					sumDay += 28;
				}
				*/
				sumDay += dayOfFebruary;
			case 1:
				sumDay += day;
				break;
		}
		
		System.out.println(year + "年" + month + "月" + day + "日是这一年的第" + sumDay + "天");
			
		
	}
}

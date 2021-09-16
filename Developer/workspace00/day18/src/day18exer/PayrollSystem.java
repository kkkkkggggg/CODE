package day18exer;

import java.util.Calendar;
import java.util.Scanner;

public class PayrollSystem
{
	public static void main(String[] args)
	{
		//方式一
//		Scanner scan = new Scanner(System.in);
//		System.out.println("请输入当月的月份：");
//		int month = scan.nextInt();
		
		//方式二
		Calendar calendar = Calendar.getInstance();
		int month = calendar.get(Calendar.MONTH);//获取当前月份
		//System.out.println(month);//一月份：0
		
		Employee[] arr = new Employee[2];
		arr[0] = new SalariedEmployee("1", 1, new MyDate(1, 1, 1),10000);
		arr[1] = new HourlyEmployee("2", 2, new MyDate(2, 2, 2),60,240);
		
		for(int i = 0;i < arr.length;i++)
		{
			System.out.println(arr[i]);
			double salary = arr[i].earning();
			System.out.println("月工资为： " + salary);
			if(month == arr[i].getBirthday().getMonth())
			{
				System.out.println("生日快乐！奖励100元");
			}
		}
	}
}

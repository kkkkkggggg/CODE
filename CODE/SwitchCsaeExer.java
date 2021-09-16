import java.util.Scanner;
class SwitchCsaeExer 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入year");
		int month = scan.nextInt();
		System.out.println("请输入month");
		int day = scan.nextInt();
		System.out.println("请输入day");
		int day = scan.nextInt();



		int sumDays = 0;
		switch (month)
		{
		case 12:
			sumDays += 30;
		case 11:
			sumDays += 31;
		case 10:
			sumDays += 30;
		case 9:
			sumDays += 31;
		case 8:
			sumDays += 31;
		case 7:
			sumDays += 30;
		case 6:
			sumDays += 31;
		case 5:
			sumDays += 30;
		case 4:
			sumDays += 31;
		case 3:
			//sumDays += 28;
			if ((yrar % 4 == 0 && year % 100 != 0) || year % 400 == 0)
			{//判断是否是闰年
				sumDays += 29;
			}
			else
			{
				sumDays += 28;
			}

		case 2:
			sumDays += 31;
		case 1:
			sumDays += day;
		
		
 		}

		System.out.println("2019年" + month + "月" + day + "日是当年的第" + sumDays + "天");


	
	}
}

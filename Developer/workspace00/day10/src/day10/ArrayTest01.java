package day10;
import java.util.Scanner;
public class ArrayTest01
{
	@SuppressWarnings("resource")
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入学生的人数：");
		int number = scan.nextInt();
		//创建数组存放学生成绩
		int[] arr = new int[number];
		//使用for循环将成绩存入数组
		for(int i = 0;i < arr.length;i++)
		{
			System.out.println("请输入第" + (i+1) + "位学生的成绩");
			int score = scan.nextInt();
			arr[i] = score;	
		}
		
		int max = 0;
		//获取最大成绩
		for(int i = 0;i < arr.length - 1;i++)
		{
			if(arr[i] > arr[i+1])
			{
				max = arr[i];
			}
		}
		System.out.println("最高分是" + max + "分");

		//判断学生等级并输出
		for(int i = 0;i < arr.length;i++)
		{
			if(arr[i] >= max - 10)
			{
				System.out.println("学生" + i + "的成绩是" + arr[i] + "等级是:A");
			}else if(arr[i] >= max - 20)
			{
				System.out.println("学生" + i + "的成绩是" + arr[i] + "等级是:B");
			}else if(arr[i] >= max - 30)
			{
				System.out.println("学生" + i + "的成绩是" + arr[i] + "等级是:C");
			}else
			{
				System.out.println("学生" + i + "的成绩是" + arr[i] + "等级是:D");
			}
		}
		
	}
}

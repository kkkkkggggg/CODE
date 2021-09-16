package day11;
import java.util.Scanner;
public class PaiXu
{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入数组的元素个数:");
		int number = scan.nextInt();
		int[] arr = new int[number];
		for(int i = 0;i < arr.length;i++)
		{
			System.out.println("请输入第" + (i+1) + "个元素");
			arr[i] = scan.nextInt();
		}
		
		for(int i = 0;i < arr.length;i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
//		int length = arr.length - 1;
		int temp;
		
		//冒泡排序
		for(int i = 0;i < arr.length - 1;i++)
		{
			for(int j = 0;j < arr.length - 1 - i;j++)
			{
				if(arr[j] > arr[j + 1])
				{
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
//		
//		while(length > 0)
//		{
//			for(int i = 0;i < arr.length - 1;i++)
//			{	
//				if(arr[i] > arr[i + 1])
//				{
//					temp = arr[i];
//					arr[i] = arr[i + 1];
//					arr[i + 1] = temp;
//				}
//			}
//			
//			length--;
//		}
		
		for(int i = 0;i < arr.length;i++)
		{
			System.out.print(arr[i] + " ");
		}
		
	}
}

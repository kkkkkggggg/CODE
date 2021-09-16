package day07;
/*
 * 数组常见异常
 * 1.数组角标越界异常
 * 
 * 
 * 2.空指针异常
 * 
 * 
 * 
 */

public class ArrayExcepption
{
	public static void main(String[] args)
	{
		//1.角标越界异常
		int[] arr = new int[]{1,2,3,4,5};
		for(int i = 0;i <= arr.length;i++)
		{
			System.out.print(arr[i] + " ");
		}
		//2.空指针异常
		//情况1
		//int[] arr1 = new int[]{1,2,3};
		//arr1 = null;
		//System.out.println(arr1[0]);
		//情况2
		//int[][] arr2 = new int[5][];
		//System.out.println(arr2[2][2]);
		//情况3
		//String[] arr3 = new String[]{"aa","bb","cc"};
		//arr3[0] = null; 
		//System.out.println(arr3[0].toString());
 	}

}

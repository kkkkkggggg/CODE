package day07;

import java.util.Arrays;

public class ArrayTest
{
	public static void main(String[] args)
	{
		//1.boolean equals(int[] a,int[] b);
		int[] arr1 = new int[]{1,2,3,4};
		int[] arr2 = new int[]{1,3,2,4};
		boolean isEquals = Arrays.equals(arr1,arr2);
		System.out.println(isEquals);
		//2.String toString(int[] a);输出数组信息
		System.out.println(Arrays.toString(arr1));
		//3.void fill(int[] a;int val);将指定值填充到数组中
		Arrays.fill(arr1, 10);
		System.out.println(Arrays.toString(arr1));
		//4.void sort(int[] a);对数组进行排序
		Arrays.sort(arr2);
		System.out.println(Arrays.toString(arr2));
		//5.int binarySearch(int[] a;int key);
		int[] arr3 = new int[]{1,7,46,53,88,90,120,231,318,456};
		int index = Arrays.binarySearch(arr3, 46);
		if(index >= 0)
		{
			System.out.println("找到了");
		}
		else
		{
			System.out.println("没找到");
		}
	}

}

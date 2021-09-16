package day13;

public class ArrayUtil
{
//	求数组的最大值
	public int getMax(int[] arr)
	{
		int max = arr[0];
		for(int i = 1;i < arr.length - 1;i++)
		{
			if(arr[i] > max)
			{
				max = arr[i];
			}
			
		}
				
		return max;
	}
//	求数组的最小值
	public int getMin(int[] arr)
	{
		int min = arr[0];
		for(int i = 1;i < arr.length - 1;i++)
		{
			
			if(arr[i] < min)
			{
				min = arr[i];
			}
		}		
		return min;
	}
//	求数组的总和
	public int getSum(int[] arr)
	{
		int sum = 0;
		for(int i = 0;i < arr.length;i++)
		{
			sum += arr[i];
		}
		return sum;
//		return getSum(arr) / arr.length;方法中调方法
		
	}
//	求数组的平均值
	public double getAverage(int[] arr)
	{
		int sum = 0;
		
		for(int i = 0;i < arr.length;i++)
		{
			sum += arr[i];
		}
		double average = sum/arr.length;
		return average;
	}
//	反转数组
	public void reverse(int[] arr)
	{
		for(int j = 0;j < arr.length / 2;j++)
		{
			int temp = 0;
			temp = arr[j];
			arr[j] = arr[arr.length - 1 - j];
			arr[arr.length - 1 - j] = temp;
		}
		
	}
//	复制数组
	public int[] copy(int[] arr)
	{
		int[] arrCopy = new int[arr.length];
		for(int i = 0;i < arr.length;i++)
		{
			arrCopy[i] = arr[i];
		}
		return arrCopy;
	}
//	数组排序
	public void sort(int[] arr)
	{
		for(int i = 0;i < arr.length;i++)
		{
			for(int j = 0;j < arr.length - 1 - i;j++)
			{
				int temp = 0;
				if(arr[j] > arr[j + 1])
				{
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
//	遍历数组
	public void print(int[] arr)
	{
		for(int i = 0;i < arr.length;i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
//	查找指定元素
	public void search(int[] arr,int dest)
	{
		boolean flag = true;
		for(int i = 1;i < arr.length;i++)
		{
			if(arr[i] == dest)
			{
				flag = false;
				System.out.println("找到了,是该数组的第" + (i + 1) + "个元素");
				break;
			}
		}
	
		if(flag)
		{
			System.out.println("没找到");
		}
	}
}

package exercise;

public class ArrayTest1
{
	public static void main(String[] args)
	{
		int[] arr = new int[10];
		
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = (int)(Math.random() * (99 - 10 + 1) + 10);
		}
		
		for (int i = 0; i < arr.length; i++)
		{
			
			
			System.out.print(arr[i] + " ");
			
		}
		
		int maxValue = arr[0];
		for (int j = 1; j < arr.length; j++)
		{
			if (maxValue < arr[j])
			{
				maxValue = arr[j];
			}
		}
		System.out.println("最大值为：" + maxValue);
		
		int minValue = arr[0];
		for (int j = 1; j < arr.length; j++)
		{
			if (minValue > arr[j])
			{
				minValue = arr[j];
			}
		}
		System.out.println("最小值为：" + minValue);
		
		int sum = 0;
		for (int i = 0; i < arr.length; i++)
		{
			sum += arr[i];
		}
		System.out.println("总和为：" + sum);
		
		int avgValue = sum/arr.length;
		System.out.println("平均数为：" + avgValue);
	}

}

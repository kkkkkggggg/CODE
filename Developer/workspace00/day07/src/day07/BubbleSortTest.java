package day07;

public class BubbleSortTest
{
	public static void main(String[] args)
	{
		int[] arr = new int[]{12,53,123,58,90,1,47,59,35,29,38};
		
		//冒泡排序
		for(int i = 0;i < arr.length;i++)
		{
			for(int j = 0;j < arr.length - 1 - i;j++)
			{
				if(arr[j] > arr[j + 1])
				{
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		
		
		for(int i = 0;i < arr.length;i++)
		{
			System.out.print(arr[i] + "\t");
		}
	}

}

package day10;

public class ArrayTest
{
	public static void main(String args[])
	{
		int[] arr = new int[5];
		for(int i = 0;i < arr.length;i++)
		{
			arr[i] = i;
			System.out.println(arr[i]);
		}
		    
		arr[0] += 2;
		System.out.println(arr[0]);
		
	}
}


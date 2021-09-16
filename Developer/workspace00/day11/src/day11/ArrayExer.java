package day11;

public class ArrayExer
{
	public static void main(String args[])
	{
		int[] array1 = {2,3,5,7,11,13,19};
		for(int i = 0;i < array1.length;i++)
		{
			System.out.print(array1[i] + "\t");
		}
		System.out.println();
		int[] array2 = array1;
		
		for(int i = 0;i < array2.length;i++)
		{
			if(i % 2 == 0)
			{
				array2[i] = i ;
			}
		}
		
		for(int i = 0;i < array1.length;i++)
		{
			System.out.print(array1[i] + "\t");
		}
	}
}

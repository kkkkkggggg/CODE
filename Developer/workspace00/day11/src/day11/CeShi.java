package day11;

public class CeShi
{
	public static void main(String args[])
	{
		int[] arr = new int[6];
		for(int i = 0;i < arr.length;i++)
		{
			arr[i] = (int)((Math.random() * 30) + 1);
			for(int j = 0;j < i;j++)
			{
				if(arr[i] == arr[j])
				{
					i--;
					break;
				}
			}
		}
		
		for(int i = 0;i < arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	}
	
}

package day09;

public class ZhiShuTest
{
	public static void main(String args[])
	{
		int count = 0;
		label:for(int i = 2;i < 100000;i++)
		{
			boolean flag = true;
			for(int j = 2;j <= Math.sqrt(i);j++)
			{
				if(i % j == 0)
				{
					flag = false;
				}
				if(flag == false)
				{
					continue label;
				}
			}
			count++;
			System.out.print(i);
			System.out.println(" " + flag);
		}
		System.out.println(count);
	}
}

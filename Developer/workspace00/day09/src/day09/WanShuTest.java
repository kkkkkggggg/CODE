package day09;

public class WanShuTest
{
	public static void main(String args[])
	{
		
		for(int i = 1;i <= 10000;i++)
		{
			String YingZi = "因子:";
			int totel = 0;
			for(int j = 1;j <= i/2;j++)
			{
				if(i % j == 0)
				{
					YingZi += j+" ";
					totel += j;
				}
			}
			if(totel == i)
			{
				System.out.print(YingZi);
				System.out.println(i);
			}
		}
	}
}

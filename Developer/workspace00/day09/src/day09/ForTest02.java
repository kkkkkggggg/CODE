package day09;

public class ForTest02
{
	public static void main(String args[])
	{
		int i;
		for(i = 100;i < 1000;i++)
		{
			int bai = (i / 100);
			int shi = ((i % 100) / 10);
			int ge = (i % 10);
			if(bai*bai*bai + shi*shi*shi + ge*ge*ge == i)
			{
				System.out.println(i);
			}
		}
	}
}

package day09;

public class BreakContinueTest
{
	public static void main(String args[])
	{
		label:for(int i = 1;i <= 4;i++)
		{
			for(int j = 1;j <= 10;j++)
			{
				if(j % 4 == 0)
				{
					//break;默认跳出包裹此字段最近的一层循环
					//continue;跳出当次循环
					//break label;结束指定标识的一层循环结构
					continue label;//结束指定标识的一层循环结构的当次循环
					//break;和continue;语句后不可直接跟语句
				}
				System.out.println(j);
			}
			
		}
	}

}

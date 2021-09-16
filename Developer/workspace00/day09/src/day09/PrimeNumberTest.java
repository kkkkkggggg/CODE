package day09;

public class PrimeNumberTest
{
	public static void main(String args[])
	{
		boolean flag = true;
		int count = 0;
		long start = System.currentTimeMillis();//获取当前时间到1970-01-01 00：00：00的毫秒数
		
		for(int i = 2;i <= 100000;i++)
		//label:for(int i = 2;i <= 100000;i++)
		{
			//boolean flag = true;
			for(int j = 2;j <= Math.sqrt(i);j++)//优化二：只取到i开根号
			//for(int j = 2;j <= (i - 1);j++)
			//for(int j = 2;j < i;j++)
			{
				if(i % j == 0)
				{
					//continue label;如果有除尽的情况发生直接跳过第一层for循环的此次循环，开始判断下一个数是否为质数
					//不需要定义标识变量，如flag
					flag = false;
					break;//优化一：发现有能除尽时跳出循环
				}
				
			}
			if(flag)
			{
				System.out.print(i + " ");
				count++;
			}
			
			flag = true;
			
		}
		long end = System.currentTimeMillis();
		System.out.println("100000以内的质数有" + count + "个");
		System.out.println("花费时间为：" + (end - start) + "ms");
		
	}
}

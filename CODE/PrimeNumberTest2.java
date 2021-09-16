/*
优化100000以内质数的输出，实现方式二
*/
class PrimeNumberTest2 
{
	public static void main(String[] args) 
	{
		boolean isFlag = true;
		int count = 0;//记录质数的个数
		//获取当前时间距离1970-01-01 00：00：00的毫秒数
		long start = System.currentTimeMillis();

		label1:for (int i = 2;i <= 100000 ;i++ )//遍历100以内的自然数
		{ 
			//优化二：对本身是质数的自然数是有效的
			for (int j = 2;j <= Math.sqrt(i) ;j++ )//j：被i去除
			{//          或j <= i
				if (i % j == 0)//i被j除尽
				{
					continue label1;
				}
				
			}
				//能执行到此步骤的，都是质数
				count++;
		}
		System.out.println(count);
		long end = System.currentTimeMillis();
		
		System.out.println("所花费的时间为：" + (end - start));//20039-2386-826-15
	}
}

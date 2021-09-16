/*
优化100000以内质数的输出，实现方式一
*/
class PrimeNumberTest1 
{
	public static void main(String[] args) 
	{
		boolean isFlag = true;
		int count = 0;//记录质数的个数

		long start = System.currentTimeMillis();

		for (int i = 2;i <= 100000 ;i++ )//遍历100以内的自然数
		{ 
			//优化二：对本身是质数的自然数是有效的
			for (int j = 2;j <= Math.sqrt(i) ;j++ )//j：被i去除
			{//          或j <= i
				if (i % j == 0)//i被j除尽
				{
					isFlag = false;
					break;//优化一：只对本身非质数的自然数有效
				}
				/*
				if (isFlag == false)
				{
					break;
				}
				*/
			}

			if (isFlag == true)
			{
				//System.out.println(i);
				count++;
			}

			isFlag = true;//重置isFlag
		}
		System.out.println(count);
		long end = System.currentTimeMillis();
		
		System.out.println("所花费的时间为：" + (end - start));//20039-2386-826-15
	}
}

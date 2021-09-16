/*
while循环的结构

①初始条件
while(②循环条件--Boolean类型)
{
	③；循环体
	④；迭代条件
}


说明：写while循环的时候千万不用丢了④迭代条件，一旦丢了可能导致死循环
for循环和while循环是可以相互转换的 

*/




class WhileTest  
{
	public static void main(String[] args) 
	{
		//遍历100以内的所有偶数
		int i = 1;
		while (i <= 100)
		{
			if (i % 2 == 0)
			{
				System.out.println(i);
			}

			i++;
		}
	}
}

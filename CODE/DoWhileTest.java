/*
do-while循环

结构

①
do
{
	③；
	④；
}while(②)；

执行过程：①-- ③-- ④-- ②-- ③-- ④-- ②-- ③-- ④
do-while循环至少会执行一次循环体
*/
class DoWhileTest 
{
	public static void main(String[] args) 
	{
		int num = 1;
		do
		{
			if(num % 2 == 0)
			{
				System.out.println(num);
			}
			num++;
		}
		while (num <= 100);
	}
}

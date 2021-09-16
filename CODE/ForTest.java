/*
For循环结构的四个要素
一、循环结构的四个要素
①初始化条件
②循环条件
③循环体
④迭代条件

二、for循环的结构
 
for(①;②;④)
{
	③
}

执行过程① - ② - ③ - ④ - ② - ③ - ④ - ... - ②


*/

class ForTest 
{
	public static void main(String[] args) 
	{
		/*
		int i;
		for (i = 1;i <= 150 ;i++ )
		{
			if ((i % 3) == 0 && (i % 5) == 0 && (i % 7) == 0)
			{
				System.out.println(i + " " + "foo" + " " + "biz" + " " + "baz");
			}
			else if ((i % 3) == 0 && (i % 5) == 0)
			{
				System.out.println(i + " " + "foo" + " " + "biz");
			}
			else if ((i % 3) == 0 && (i % 7) == 0)
			{
				System.out.println(i + " " + "foo"+ " " + "baz");
			}
			else if ((i % 5) == 0 && (i % 7) == 0)
			{
				
				System.out.println(i + " " + "biz"+ " " + "baz");

			}
			else if ((i % 3) == 0)
			{
				System.out.println(i + " " + "foo");
			}
			else if ((i % 5) == 0)
			{
				System.out.println(i + " " + "biz");
			}
			else if ((i % 7) == 0)
			{
				System.out.println(i + " " + "baz");
			}
			else
			System.out.println(i);
		}
		*/
		for (int i = 1;i <= 150 ;i++ )
		{
			System.out.print(i + "  ");
			if (i % 3 == 0)
			{
				System.out.print("foo ");
			}
			if (i % 5 == 0)
			{
				System.out.print("biz ");
			}
			if (i % 7 == 0)
			{
				System.out.print("baz ");
			}
			System.out.println(); //换行
		}
		
	}
}

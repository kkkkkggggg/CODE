/*
循环嵌套的使用
1，嵌套循环：将一个循环结构A声明在另一个循环结构B的循环体中，就构成了循环嵌套

2，外层循环：循环结构B
   内层循环：循环结构A
3，内存循环结构遍历一遍，只相当于外层循环体执行了一次

*/
class ForForTest 
{
	public static void main(String[] args) 
	{
		/*
		for (int i = 1;i <= 6 ;i++ )
		{
			System.out.print("*");
		}

		System.out.println();
		
		
		for (int a = 1;a <= 4 ;a++ )
		{
			for (int i = 1;i <= 6 ;i++ )
			{
				System.out.print("*");
			}
			System.out.println();
		}
		
		int b = 1;
		for (int a = 1;a <= 5 ;a++ )
		{
			for (int i = 1;i <= b ;i++ )
			{
				System.out.print("*");
			}
			System.out.println();
			b++;

		}
		*/


/*
   ----*-
   ---*-*-
   --*-*-*-
   -*-*-*-*-
   *-*-*-*-*-
   -*-*-*-*-
   --*-*-*-
   ---*-*-
   ----*-
*/
		
			for (int a = 1;a <= 5 ;a++ )
			{
				
				for (int b = 1;b <= 5-a ;b++ )
				{
					System.out.print("-");
				}
				
				for (int c = 1;c <= a ;c++ )
				{
					System.out.print("*-");
				}
				System.out.println();
			}

			for (int a = 1;a <= 4 ;a++ )
			{
				for (int b = 1;b <= a ;b++ )
				{
					System.out.print("-");
				}

				for (int c = 1;c <= 5-a ;c++ )
				{
					System.out.print("*-");
				}
				System.out.println();
			}
			
		
		
		
		
	}
}

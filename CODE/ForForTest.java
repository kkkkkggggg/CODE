/*
ѭ��Ƕ�׵�ʹ��
1��Ƕ��ѭ������һ��ѭ���ṹA��������һ��ѭ���ṹB��ѭ�����У��͹�����ѭ��Ƕ��

2�����ѭ����ѭ���ṹB
   �ڲ�ѭ����ѭ���ṹA
3���ڴ�ѭ���ṹ����һ�飬ֻ�൱�����ѭ����ִ����һ��

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

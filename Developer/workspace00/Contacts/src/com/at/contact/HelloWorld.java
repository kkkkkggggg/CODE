package com.at.contact;


/**
 * 
 * @author chenk  Email:
 *
 */

public class HelloWorld 
{
	public static void main(String[] args)
	{
		int i;
		int j;
		int x;
	
		for(i = 0; i < 10; i++)
		{
			
			for(j = 10;j > i;j--)
			{
				System.out.print(" ");
			}
			for(x = i;x >= 0;x--)
			{
				System.out.print("+ ");
			}
			System.out.println();
		}
		for(i = 0;i < 9;i++)
		{
			for(j = 0;j < i + 2;j++)
			{
				System.out.print(" ");
			}
			for(x = 9 - i;x > 0;x--)
			{
				System.out.print("+ ");
			}
			System.out.println();
		}
				
		 
	}

}

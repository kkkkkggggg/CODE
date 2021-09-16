package day13exer;
/*
递归方法的使用（了解）
1.递归方法：一个方法体内调用他自身
2.方法递归包含了一种隐式循环，它会重复执行某段代码，但这种重复无需循环
控制，递归一定要向已知方向递归，否则这种递归就变成了无穷递归，类似于
死循环




*/
public class RecursionTest
{
	public static void main(String args[])
	{
		//例一：计算1-100之间所有自然数的和
		int sum = 0;
		for(int i = 1;i <= 100;i++)
		{
			sum += i;
		}
		System.out.println(sum);
//		**********************************
//		使用递归求1-100之间所有自然数的和
		RecursionTest test = new RecursionTest();
		int sum1 = test.getSum(100);
		System.out.println(sum1);
//		**********************************
//例三：已知有一个数列：f(0) = 1,f(1) = 4,f(n + 2) = 2*f(n + 1) + f(n)
//其中n是大于0的整数，求f(10)的值
//		使用循环求出f(10)
		int num = test.getF(10);
		System.out.println(num);
//		**********************************
		//使用递归求出f（10）
		test.getF(10, 1, 4);
//		**********************************
//		使用递归求出斐波那契数列的第n位
		int fibon = test.fibonacci(6);
		System.out.println(fibon);
//		**********************************
//		使用递归求出上n阶台阶的方法个数
		int stair = test.upStair(6);
		System.out.println(stair);
	}
	//例二：计算1-n之间所有自然数的乘积
	public int getSum(int n)
	{
		if(n == 1)
		{
			return 1;
		}else
		{
			return n + getSum(n - 1);
		}
	}
	//例二：计算1-n之间所有自然数的乘积
	public int getSum1(int n)
	{
		if(n == 1)
		{
			return 1;
		}else
		{
			return n*getSum1(n - 1);
		}
	}
	
	//例三：已知有一个数列：f(0) = 1,f(1) = 4,f(n + 2) = 2*f(n + 1) + f(n)
	//其中n是大于0的整数，求f(10)的值
	public int getF(int n)//使用循环求出f（10）
	{
		int[] f = new int[n + 1];
		f[0] = 1;
		f[1] = 4;
		for(int j = 0;j <= n - 2;j++)
		{
			f[j + 2] = 2 * f[j + 1] + f[j];
		}
		return f[f.length -1];
//		arr[n + 2] = 2 * arr[n + 1] + arr[n];
		
	}
	public void getF(int n,int first,int second)//使用递归求出f（10）
	{
		if(n == 0)
		{
			System.out.println(first);
		}else if(n == 1)
		{
			System.out.println(second);
		}else
		{
			int temp = 0;
			temp = 2 * second + first;
			n--;
			if(n - 2 >= 0)
			{
				first = second;
				second = temp;
				getF(n, first, second);
			}else
			{
				System.out.println(temp);
			}
		}
		
	}
	
	public int f(int n)//简洁的递归方法
	{
		if(n == 0)
		{
			return 1;
		}else if(n == 1)
		{
			return 4;
		}else
		{
			return 2 * f(n - 1) + f(n - 2);
		}
		
	}
	//例：用递归求斐波那契数列的第n项
	public int fibonacci(int n)
	{
		
		if(n == 1)
		{
			return 1;
		}else if(n == 2)
		{
			return 1;
		}else
		{
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
			
	}
	//例：一个人上台阶，每次只能登两个台阶或一个台阶，求走完n阶有多少方式
	public int upStair(int n)
	{
		
		if(n == 1)
		{
			return 1;
		}else if(n == 2)
		{
			return 2;
		}else
		{
			return upStair(n - 1) + upStair(n - 2);
		}
	}
	
}

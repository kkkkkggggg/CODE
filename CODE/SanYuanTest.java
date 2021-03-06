/*
运算符之六：三元运算符
结构：（条件表达式）？表达式1：表达式2
说明
1.条件表达式的结果为boolean类型
2.根据表达式真假，决定执行表达式1还是表达式2
  如果表达式为true，执行表达式1
  如果结果为flase,执行表达式2
  表达式1和表达式2要求是一致的
  三元运算符可以嵌套使用
3.凡是可以使用三元 运算符的地方都可以改写为if else
  反之不成立
4.如果程序既可以使用三元运算符，又可以用if else, 优先使用三元运算符，简洁
执行效率高


*/

class SanYuanTest 
{
	public static void main(String[] args) 
	{
		//获取两个整数的最大值
		int m = 12;
		int n = 5;
 
		int max = (m > n)? m : n;
		
		System.out.println(max);

		double num = (m > n)? 2 : 1.0；
		
		//(m > n)? 2 : "n大"；//编译错误

		//***************************
		String maxStr = (m > n)? "m大" : ((m == n)? "m和n相等" : "n大")；
		System.out.println(maxStr);

		//***************************
		int n1 = 12;
		int n2 = 30;
		int n3 = -43;

		int max1 = (n1 > n2)? n1 : n2;
		int max2 = (max1 > n3)? max1 : n3;
		System.out.println("三个数中的最大值为： " + max2);

		int max3 = (((n1 > n2)? n1 : n2) > n3)? ((n1 > n2)? n1 : n2) : n3;
	}
}

package day19;

public class InnerClassTest
{
	/*
	 * 在局部内部类的方法中(比如：show)如果调用局部内部类所声明在的
	 * 方法(比如method)中的局部变量(比如：num)，要求此局部变量声
	 * 明为final的
	 * jdk7及之前的版本：要求此局部变量显式的声明为final的
	 * jdk8及之后的版本：可以省略final的声明
	 */
	public void method()
	{
		int num = 10;
		
		class AA
		{
			public void show()
			{
//				num = 20;
				System.out.println(num);
			}
		}
	}
}

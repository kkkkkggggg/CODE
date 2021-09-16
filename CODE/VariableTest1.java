/*
 基本数据类型之间的运算规则：

 前提 ： 这里只讨论7种基本数据类型变量间的运算，不包括boolean类型

 1. 自动类型提升：
	当容量小的数据类型的变量与容量大的数据类型的变量做运算时，结果自动提升为容量大的数据类型
	byte、char、short-->int-->long-->float-->double
	特别的：当byte、char、short三种类型变量做运算时，结果为int型





 2. 强制类型转换：







说明：此时的容量大小指的是，表示数的范围的大小，例如：float的容量大于long的容量

*/
class VariableTest1
{
	public static void main(String[] args)
	{
		byte b1 = 2;
		int i1 =129;
		//byte b2 = b1 + i1;   编译不通过 byte型取值 -128~127
		int l1 = b1 + i1;
		System.out.println(l1);

		char c1 = 'a';
		int c2 = 10;
		int c3 = c1 + c2;
		System.out.println(c3);
		
	}
}

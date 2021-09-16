/*
强制类型转换：自动类型提升运算的逆运算。
需要使用强制转换符：（）



*/

class VariableTest2 
{
	public static void main(String[] args) 
	{
	double d1 = 12.3;//精度损失例一

	int i1 = (int)d1;//截断操作，只取整数部分，可能会损失精度

	System.out.println(i1);

	long l1 = 123;  //没有精度损失
	short s1 = (short)l1;

	int i2 = 128;  //精度损失例二
	byte a = (byte)i2;
	System.out.println(a);//-128

	//编码情况一
	long b = 121123;//整型常量，默认为int型，变量值未超过int范围，默认为int，不会报错
	System.out.println(b);
	//编译失败：过大的整数
	//long c = 121314125125213561412; 超过int的范围，报错
	long c = 121314125125213561412L; 
	

	byte d = 12;
	//byte d1 = d + 1;  编译失败，整型常量1被默认为int型，转换为更小的byte型会报错
	
	//float f = 12.3； 编译失败，浮点型常量12.3被默认为double型，转换为范围更小的float型会报错
	float f = 12.3F；//编译成功
	//float f1 = d + 12.3；  编译失败

	}
}

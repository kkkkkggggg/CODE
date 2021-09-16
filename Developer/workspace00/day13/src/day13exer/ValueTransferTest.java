package day13exer;
/*
方法形参的传递机制:值传递

1.形参：方法定义时：声明在小括号内的参数
   实参：方法调用时，实际传递给形参的值









*/public class ValueTransferTest
{
	public static void main(String args[])
	{
//		交换两个变量值的操作
		int n = 10;
		int m = 20;
		
		System.out.println("m = " + m + "n = " + n);
//		int temp = m;
//		m = n;
//		n = temp;
		ValueTransferTest test = new ValueTransferTest();
		test.swap(m, n);

		System.out.println("m = " + m + "n = " + n);
//		输出结果m = 20n = 10
//			   m = 20n = 10
//		为什么没换成？实参m、n的值传递给了方法中的形参m、n
//		此时是传值操作，在内存的栈空间中存在实参m、n和方法中
//		形参所接收到实参数值的m、n，交换方法中m、n的值对实参
//		m、n没有影响，（实参和形参的变量名相同或不同对此结论
//		没有影响）
//		1.如果实参是基本数据类型，实参赋给形参的是这个实参实际的值
//		2.如果实参是引用数据类型，实参赋值给形参的是实参存储数据的地址值
	}
	
	public void swap(int m,int n)
	{
		int temp = m;
		m = n;
		n = temp;
	}
}

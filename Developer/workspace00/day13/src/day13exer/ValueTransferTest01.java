package day13exer;

public class ValueTransferTest01
{
	public static void main(String argsp[])
	{
		Data test = new Data();//创建Data类的
		test.m = 10;//对对象test的属性m、n进行赋值
		test.n = 20;
		
		ValueTransferTest01 test01 = new ValueTransferTest01();
		test01.swap(test);//创建ValueTransferTest01类的对象，并调用
						//声明在其中的swap方法，将Data类的对象test作为
						//实参传给ValueTransferTest01类中的swap方法，
						//类是引用数据类型，类的实例化对象也是引用数据类型
						//此时将test作为实参传给ValueTransferTest01类中的
						//swap方法传的是地址值
	}
	
	public void swap(Data test) //将交换两个数的值的功能封装进方法
	{							//Data类型的数据作为形参
		int temp = test.m;
		test.n = test.m;
		test.m = temp;
	}
}

class Data
{
	int m;//将m和n作为方法的属性封装进方法中
	int n;
}
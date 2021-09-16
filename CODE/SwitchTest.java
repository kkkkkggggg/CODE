/*分支结构之二：switch-case

1.格式
switch(表达式)
{
	case 常量1；
	//break;

	case 常量2；
	//break;

	....

	default:
		执行语句n;
		//break


}

说明：根据switch表达式中的值，依次匹配各个case中的常量，一旦匹配成功，
则进入相应的case结构中，调用其执行语句。当调用完执行语句后，继续向下执行其他case结构中的执行语句
知道执行到  break; 语句，或者switch-case 结构的末尾结束为止

break; 可以使用在switch-case结构中，表示一旦执行到了此关键字，跳出switch-case结构

switch结构中的表达式，只能是：byte,short,char,int,枚举类型，String类型
case只能声明常量，不能声明范围
break关键字是可选的
default:相当于if-else结构中的else，也是可选的，而且位置是灵活的  



*/

class SwitchTest 
{
	public static void main(String[] args) 
	{
		int number = 2;

		switch(number)
		
		case 0;
			System.out.println("zero");

		case 1;
			System.out.println("one");

		case 2;
			System.out.println("two");
		
		case 3;
			System.out.println("three");

		case 4;
			System.out.println("four");



	}
}

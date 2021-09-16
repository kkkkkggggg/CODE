/*
逻辑运算符
&  &&  |  ||  !  ^

说明：
逻辑运算符操作的都是boolean类型的变量






*/





class  LogicTest
{
	public static void main(String[] args) 
	{
        //区分 & 与 &&
		//相同点1：& 与 && 的运算结果相同
		//相同点2：当符号左边是true时，二者都会执行符号右边的运算
		//不同点：当符号左边是false时，& 会继续执行符号右边的运算， && 不再执行符号右边的运算
		//开发中推荐使用 && ||
		boolean a1 = true;
		a1 = false;
		int num = 10;
		if(a1 & (num++ > 0))
		{
			System.out.println("我现在在北京");
		}	
		else
		{
			System.out.println("我现在在南京");
		}

		System.out.println("num = " + num);


		boolean a2 = true;
		a2 = false;
		int num1 = 10;
		if(a1 && (num1++ > 0))
		{
			System.out.println("我现在在北京");
		}	
		else
		{
			System.out.println("我现在在南京");
		}

		System.out.println("num1 = " + num1);

		// 区分： | 与 ||


	}
}

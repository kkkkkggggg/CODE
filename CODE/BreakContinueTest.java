/*
break和continue关键字的使用
                使用范围        循环中使用的作用   
break           switch-case
                循环结构中      结束当前循环

continue        循环结构中      结束当次循环

相同点 关键字后面不能声明执行语句

*/
class BreakContinueTest 
{
	public static void main(String[] args) 
	{
		for (int i = 1;i <= 10 ;i++ )
		{
			if (i % 4 == 0)
			{
				//break;//123
				continue;//1235678910
			}
		}
		System.out.print(i);
		//**********************************

		Label1:for (int i = 1;j <= 10 ;j++ )
		{
			for (int j = 1;j <= 10 ;j++ )
			{
				if (j % 4 == 0)
				{
					//break;//默认跳出包裹此关键字最近的一层循环
					//continue;//

					//break Label1;//结束指定标识的一层循环结构
					continue Label1;//结束指定标识的一层循环结构当次循环
				}
					System.out.print(j);
			}
			System.out.println();
		}
	}
}

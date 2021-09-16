package day18;

public class TemplateTest
{
	public static void main(String[] args)
	{
		Subtemplate t = new Subtemplate();
		
		t.spendTime();
	}

}

abstract class Template
{
	public void spendTime()
	{
		long start = System.currentTimeMillis();
		
		this.code();
		
		long end = System.currentTimeMillis();
		
		System.out.println("花费的时间为：" + (end - start));
	}
	
	
	public abstract void code();
}

class Subtemplate extends Template
{

	@Override
	public void code()
	{
		for(int i = 2;i <= 1000;i++)
		{
			boolean isFlag = true;
			
			for(int j = 2;j <= Math.sqrt(i);j++)
			{
				if(i % j == 0)
				{
					isFlag = false;
					break;
				}
			}
			
			if(isFlag)
			{
				System.out.println(i);
			}
		}
		
	}
	
}
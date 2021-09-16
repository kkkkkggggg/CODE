package day14exer3;

public class Account
{
	private double balance;
	
	public Account(double init_balance)
	{
		balance = init_balance;
	}

	public double getBalance()
	{
		return balance;
	}
	
	//取钱操作
	public void deposit(double amt)
	{
		if(amt > balance)
		{
			System.out.println("余额不足，取钱失败");
		}else
		{
			balance -= amt;
			System.out.println("成功取出 " + amt +" 元/n" + "账户余额是 " + balance +" 元" );
		}
	}
	
	//存钱操作
	public void withDraw(double amt)
	{
		if(amt < 0)
		{
			System.out.println("请输入正确的存款金额");
		}else
		{
			balance += amt;
			System.out.println("成功存入 " + amt + " 元" + "账户余额是 " + balance + " 元");
		}
				
	}
}

package day14exer2;

public class Account
{
	private int id;
	private double balance;//余额
	private double annuallnterestRate;//年利率
	
	public Account(int id,double balance,double annuallnterestRate)
	{
		this.setId(id);
		this.setBalance(balance);
		this.setAnnuallnterestRate(annuallnterestRate);
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public void setBalance(double balance)
	{
		this.balance = balance;
	}
	
	public void setAnnuallnterestRate(double annuallnterestRate)
	{
		this.annuallnterestRate = annuallnterestRate;
	}
	
	public int getId()
	{
		return id;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public double getAnnuallnterestRate()
	{
		return annuallnterestRate;
	}
	
	public void withDraw(double amount)//取钱
	{
		if(amount > this.balance)
		{
			System.out.println("余额不足，取款失败");
		
		}else
		{
			this.balance -= amount;
			System.out.println("成功取出: " + amount + "元");
		}
	}
	
	public void deposit(double amount)//存钱
	{
		if(amount < 0)
		{
			System.out.println("请输入正确的存钱金额");
		
		}else
		{
			this.balance += amount;
			System.out.println("成功存入: " + amount + "元");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

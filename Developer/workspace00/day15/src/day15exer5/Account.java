package day15exer5;

public class Account
{
	private int id;
	private double balance;
	private double annuallnterestRate;
	
	public Account()
	{
		
	}
	
	public Account(int id,double balance,double annuallnterestRate)
	{
		this.id = id;
		this.balance = balance;
		this.annuallnterestRate = annuallnterestRate;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public double getBalance()
	{
		return balance;
	}

	public double getAnnuallnterestRate()
	{
		return annuallnterestRate;
	}

	public void setAnnuallnterestRate(double annuallnterestRate)
	{
		this.annuallnterestRate = annuallnterestRate;
	}
	
	public double getMonthlyinterest()
	{
		return annuallnterestRate / 12;
	}
	
	public void withDraw(double amount)
	{
		if(amount <= balance)
		{
			balance -= amount;
//			System.out.println("取钱成功,共取出:" + amount + "元\n" + "余额:" + balance + "\n");
		}else
		{
			System.out.println("余额不足\n");
			return;
		}
	}
	
	public void deposit(double amount)
	{
		if(amount > 0)
		{
			balance += amount;
			System.out.println("存钱成功,共存入:" + amount + "元\n" + "余额:" + balance + "\n");
		}
	}
	
	public static void main(String args[])
	{
		Account a = new Account(1122, 20000, 0.045);
		
		a.withDraw(30000);
		a.withDraw(2500);
		a.deposit(3000);
		double s = a.getMonthlyinterest();
		System.out.println("月利率是:" + s + "\n");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

package day15exer5;

public class CheckAccount extends Account
{
	private double overdraft;
	
	public CheckAccount()
	{
		
	}
	
	public CheckAccount(double overdraft)
	{
		this.overdraft = overdraft;
	}
	
	public CheckAccount(int id,double balance,double annuallnterestRate,double overdraft)
	{
		super(id, balance, annuallnterestRate);
		this.overdraft = overdraft;
		
	}
	
	public double getOverdraft()
	{
		return overdraft;
	}

	public void setOverdraft(double touZhi)
	{
		overdraft -= touZhi;
	}
	
	@Override
	public void withDraw(double amount)
	{
		if(amount <= getBalance())
		{
			super.withDraw(amount);//setBalance((getBalance()- amount));
			System.out.println("取款成功,共取出:" + amount + "元\n" + "余额 :" + getBalance() + "\n" +
			"可透支余额:" + getOverdraft() + "\n");
		}else if(amount <= (getBalance() + overdraft))
		{
			
			double touZhi = amount - getBalance();
			setOverdraft(touZhi);
			super.withDraw(getBalance());
			System.out.println("取款成功,共取出:" + amount + "元\n" + "透支金额:" + touZhi + "元\n" + 
			"账户余额: 0\n" + "可透支余额:" + getOverdraft() + "\n");
		}else
		{
			System.out.println("超过可透支余额上限，取款失败\n");
		}
	}
	
	
}

package day14exer2;

public class AccountTest
{
	public static void main(String args[])
	{
		Account a = new Account(0012, 5000, 0.01);
		int id = a.getId();
		System.out.println("账户id是:" + id);
		
		double balance = a.getBalance();
		System.out.println("余额是:" + balance);
		
		double annuallnterestRate = a.getAnnuallnterestRate();
		System.out.println("年利率是:" + annuallnterestRate);
		
		a.withDraw(4000);
		System.out.println("余额是:" + a.getBalance());
		
		a.withDraw(1200);
		
		a.deposit(6000);
		System.out.println("余额是:" + a.getBalance());
	}
}

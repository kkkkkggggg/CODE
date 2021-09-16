package day14exer3;

public class BankTest
{
	public static void main(String args[])
	{
		
//		连续操作
		Bank bank = new Bank();
		
		bank.addCustomer("Jean", "Smith");
		
		bank.getCustomer(0).setAccount(new Account(2000));
		
		bank.getCustomer(0).getAccount().withDraw(500);
		
		double balance = bank.getCustomer(0).getAccount().getBalance();
		System.out.println("客户 " + bank.getCustomer(0).getFirstName() + "的账户余额为：" + balance);
		bank.addCustomer("s", "b");
		
		System.out.println(bank.getNumberOfCustomers());
	}
}

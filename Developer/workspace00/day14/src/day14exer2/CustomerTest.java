package day14exer2;

public class CustomerTest
{
	public static void main(String args[])
	{
		Customer a = new Customer("Jean", "Smith");
		Account account = new Account(1000, 2000, 0.0123);
		
		a.setAccount(account);
		
		account.deposit(100);
		
		account.withDraw(960);
		
		account.withDraw(2000);
		
		System.out.println("Customer [" + a.getFirstName() + "," + a.getLastName() + "] has a account:id is" + account.getId() + "," 
		+ "annuallnterestRate is:" + account.getAnnuallnterestRate() + " balance is:" + account.getBalance());
	}
}

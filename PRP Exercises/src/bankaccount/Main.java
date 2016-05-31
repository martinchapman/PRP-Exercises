package bankaccount;
import java.awt.geom.Rectangle2D;
import java.util.Arrays;


public class Main {

	public static void main(String[] args) {
		
		BankAccount accountA = new BankAccount();
		BankAccount accountB = new BankAccount();
		
		accountA.depositMoney(100.00);
		accountB.depositMoney(50.00);
		
		System.out.println(accountA.queryBalance());
		System.out.println(accountB.queryBalance());
		
		BankAccount[] accounts = new BankAccount[2];
		
		accounts[0] = accountA;
		accounts[1] = accountB;
		
		for(int i = 0; i < accounts.length; i++) {
			
			System.out.println(accounts[i].queryBalance());
			
		}
		
		accountA.bankTransfer(accountB, 100.00);
		System.out.println(accountA.queryBalance());
		System.out.println(accountB.queryBalance());
		
		Rectangle2D.Double rectA = new Rectangle2D.Double(4, 4, 4, 4);
		Rectangle2D.Double rectB = new Rectangle2D.Double(7, 7, 5, 5);
		System.out.println(rectA.intersects(rectB));
		
		String[] list = {"A", "B", "C"};
		swap(list, 0, 1);
		
		System.out.println(Arrays.toString(list));
		
	}
	
	public static void swap(Object[] os,int i,int j)
	{
		Object tmp = os[i];
		os[i] = os[j];
		os[j] = tmp;
	}
	
}

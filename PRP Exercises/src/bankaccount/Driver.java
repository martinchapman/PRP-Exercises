package bankaccount;

import java.util.ArrayList;


public class Driver {
	
	public static void main(String[] args) {
		
		ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
		
		for (int i = 0; i < 5; i++) {
			
			accounts.add(new BankAccount(i));
			
		}
		
		for (BankAccount b : accounts) {
			
			b.printNumber();
			
		}
		
	}
	
}

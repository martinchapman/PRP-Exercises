package bankaccount;

public class BankAccount {

	// Fields
	private double currentBalance;
	private boolean overdrawn;
	private int number;
	private String password;
	
	// Constructor
	public BankAccount() { 
		
		currentBalance = 0; 
		overdrawn = false; 
	}
	
	public BankAccount(double balance) {
		
		this.currentBalance = balance;
		
	}
	
	public BankAccount(int number, String password, double initialDeposit) {
		
		this.number = number;
		this.password = password;
		this.currentBalance = initialDeposit;
		
	}
	
	public BankAccount(int number, String password) {
		
		this(number, password, 0);
		
	}
	
	// Methods
	public void depositMoney(double amount) { 
		
		currentBalance += amount; 
		
	}
	
	public double withdrawMoney(double amount) { 
		
		currentBalance -= amount; return amount; 
		
	}
	
	public double queryBalance() { 
		
		return currentBalance; 
	
	}
	
	public void setOverdrawn() { 
		
		overdrawn = true; 
	
	}
	
	public int getNumber() {
		
		return number;
		
	}

	public void bankTransfer(BankAccount toAccount, double amount) {
		
		toAccount.depositMoney(withdrawMoney(amount));
		
	}
	
	public void transferMoneyIn(BankAccount otherAccount, double transferAmount) {
		
		currentBalance += transferAmount;
		
		otherAccount.currentBalance -= transferAmount;
		
	}
	
	public void printNumber() {
		
		System.out.println(number);
		
	}
	
	public String getPassword() {
		
		return password;
		
	}

}

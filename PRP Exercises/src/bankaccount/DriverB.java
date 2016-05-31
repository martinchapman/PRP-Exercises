package bankaccount;

import java.util.*;

public class DriverB
{
	private static ArrayList<BankAccount> accounts = new ArrayList<BankAccount>(); //This is an array list in which all the data is stored
	private static BankAccount accountInUse;
	private static Scanner reply = new Scanner(System.in); //Global Scanner
	public static void main (String[] args)
	{
		System.out.println("Hello Welcome to Martin's bank of KCL. \nPlease enter L to login or R to register");
		while (true) {
			//BankAccount bankAccount1 = new BankAccount("name");
				
			//ArrayList<String> account = new ArrayList<String>();
			
			//ArrayList<Double> balance = new ArrayList<Double>();
			
					String response = reply.next(); //This lets the user decide to login or to register.
			
					if (response.equalsIgnoreCase("r"))
					{
						register(); 
					}
					else if (response.equalsIgnoreCase("l"))
					{
						// Ask for credentials 
					} 
					
					System.out.println("\nHello Welcome to Martin's bank of KCL. \nPlease enter L to login or R to register");
			}
		
		
	}

	public static void loggedIn() //once the user has logged in, the program will go to login options.
	{
		loginOptions();
		
	}
	
	public static void loginOptions() //these are the login options.
	{
		while(true)
		{
			System.out.println("\nPlease enter 1 to view balance:\nPlease enter 2 to withdraw:\nPlease enter 3 to transfer:\nPlease enter 4 to deposit:\nPlease enter 5 to quit:");
			
			int response = reply.nextInt();
			
			switch (response)
			{
				case 1: System.out.println("�" + accountInUse.queryBalance()); break;
				case 2: withdraw(); break;
				case 3: transfer(); break;
				case 4: deposit(); break;
				case 5: return;
	
			}
		}
	}
	
	private static void transfer() //This is the transfer option.
	{
		System.out.println("\nWhat is the name of the recipient's account:");
				
		String response = reply.next();
		
		boolean found = false;
		
		for (BankAccount currentAccount : accounts) // for every element in the ArrayList accounts look for BankAccount and store them in the variable currentAccount.
		{
		
			if (response.equals(currentAccount.getNumber()))
			{
				found = true;
				
				System.out.print("\nPlease enter an amount to transfer: " );
				
				double amount = reply.nextDouble();
				
				accountInUse.transferMoneyIn(currentAccount, amount);
				
				System.out.println("\nThe amount of �" + amount + " has been transfered succsessfully to " + response);
			}
			
		}
		
		
		if (!found) System.err.println("Invalid details!");
	}
	
	private static void withdraw()
	{
		System.out.println("Please enter the amount you would like to withdraw:");
		
		double response = reply.nextDouble();
		
		accountInUse.withdrawMoney(response);
		
		System.out.println("Your new account balance is: �" + accountInUse.queryBalance());
		
	}
	
	public static void register() 
	{
		System.out.println("Please enter an account name:");
		
		Scanner response = new Scanner(System.in);
		
		int number = Integer.parseInt(response.next());
		
		System.out.println("Please enter a password for your account");
		
		String password = response.next();
		
		accounts.add(new BankAccount(number, password)); // this should add the entered name into the account
		
	}
	
	public static void login(int number, String password)
	{
		
		boolean found = false;
		
		for (BankAccount currentAccount : accounts)
		{
		
			if (number == currentAccount.getNumber() && password.equals(currentAccount.getPassword()))
			{
				found = true;
				
				accountInUse = currentAccount;
				
				System.out.println("\nHello " + accountInUse.getNumber() + " you are sucsessfully logged in.");
				
				loggedIn();
			}
			
		}
		
		
		if (!found) System.err.println("Invalid details!");
			
	
	}
	
	public static void deposit()
	{
		System.out.println("Please enter the amount you would like to deposit");
		
		double response = reply.nextDouble();
		
		accountInUse.depositMoney(response);
		
		System.out.println("Your new account balance is: �" + accountInUse.queryBalance());
		
		
		
	}
	 
	
}

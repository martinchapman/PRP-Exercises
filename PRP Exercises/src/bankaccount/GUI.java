package bankaccount;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Button;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JTextField;
import javax.swing.JPasswordField;


public class GUI extends JFrame {

	private JPanel loginOrRegister;
	private JPanel loginPane;
	private JPanel loginOptions;
	private JPanel Register;
	private final JLabel lblNewLabel = new JLabel("Welcome to Bank of Martin");
	
	private ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
	private BankAccount accountInUse;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		
		// Configure window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		// Whole Content Pane //////////////////////////////////////////////
		JPanel windowPanel = new JPanel();
		windowPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(windowPanel);
		windowPanel.setLayout(new BoxLayout(windowPanel, BoxLayout.Y_AXIS));
		///////////////////////////////////////////////////////////////////
		
		// Panel to hold login or register buttons //////////////////////
		loginOrRegister = new JPanel();
		loginOrRegister.setBorder(new EmptyBorder(5, 5, 5, 5));
		windowPanel.add(loginOrRegister);
		loginOrRegister.setLayout(null);
		///////////////////////////////////////////////////////////////////
		
		// make a login frame /////////////////////////////////////////////
		loginPane = new JPanel();
		loginPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		windowPanel.add(loginPane);
		loginPane.setLayout(null);
		
		loginPane.setVisible(false);
		////////////////////////////////////////////////////////////////////
		
		// logged in options ///////////////////////////////////////////////
		JPanel loggedInOptions = new JPanel();
		loggedInOptions.setBorder(new EmptyBorder(5, 5, 5, 5));
		windowPanel.add(loggedInOptions);
		loggedInOptions.setLayout(null);
		
		loggedInOptions.setVisible(false);
		////////////////////////////////////////////////////////////////////
		
		//register window //////////////////////////////////////////////////
		Register = new JPanel();
		Register.setBorder(new EmptyBorder(5, 5, 5, 5));
		windowPanel.add(Register);
		Register.setLayout(null);
		
		Register.setVisible(false);
		///////////////////////////////////////////////////////////////////
		
		// Login or Register  //////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////
		
		// Make a label ////////////////////////////////////////////////////
		lblNewLabel.setBounds(5, 5, 422, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginOrRegister.add(lblNewLabel);
		
		JLabel lblPleaseSelectOne = new JLabel("Please Select one of the following options:");
		lblPleaseSelectOne.setBounds(77, 77, 271, 25);
		lblPleaseSelectOne.setFont(new Font("Tahoma", Font.PLAIN, 15));
		loginOrRegister.add(lblPleaseSelectOne);
		
		// Make a register button ///////////////////////////////////////////
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(251, 115, 97, 25);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				loginOrRegister.setVisible(false);
				Register.setVisible(true);
			
			}
		});
		
		loginOrRegister.add(btnRegister);
		///////////////////////////////////////////////////////////////////
		
		// Make a login button //////////////////////////////////////////////
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(77, 115, 97, 25);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				loginOrRegister.setVisible(false);
				loginPane.setVisible(true);
				
			}
		});
		
		loginOrRegister.add(btnLogin);
		////////////////////////////////////////////////////////////////////
		
		// Login  //////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////
		
		JLabel lblPleaseEnterAn = new JLabel("Please enter the account name:");
		lblPleaseEnterAn.setBounds(6, 13, 218, 25);
		loginPane.add(lblPleaseEnterAn);
		lblPleaseEnterAn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textField = new JTextField();
		textField.setBounds(228, 15, 175, 22);
		loginPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPleaseEnterA = new JLabel("Please enter the password:");
		lblPleaseEnterA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPleaseEnterA.setBounds(12, 64, 204, 25);
		loginPane.add(lblPleaseEnterA);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(228, 66, 175, 22);
		loginPane.add(passwordField);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(150, 100, 97, 25);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				login(textField.getText(), passwordField.getPassword());
				
			}
		});
		
		loginPane.add(btnSubmit);
		
		loginPane.setVisible(false);
		
		////////////////////////////////////////////////////////////////////
		
		// Logged in ///////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////
		
		JLabel lblNewLabel_1 = new JLabel("Please select a option:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(0, 28, 331, 33);
		loggedInOptions.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Currnet Balance");
		btnNewButton.setBounds(193, 20, 161, 25);
		loggedInOptions.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Withdraw");
		btnNewButton_1.setBounds(100, 20, 97, 25);
		loggedInOptions.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Deposit");
		btnNewButton_2.setBounds(10, 20, 97, 25);
		loggedInOptions.add(btnNewButton_2);
		
		JButton btnTransfer = new JButton("Transfer");
		btnTransfer.setBounds(343, 20, 97, 25);
		loggedInOptions.add(btnTransfer);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(343, 54, 97, 25);
		loggedInOptions.add(btnLogOut);
		
		////////////////////////////////////////////////////////////////////
		
		// Register ////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////
		
		// register options
		JLabel lblNewLabel_2 = new JLabel("Please enter an account name:");
		lblNewLabel_2.setBounds(10, 9, 262, 16);
		Register.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(210, 6, 116, 22);
		Register.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Please enter a password:");
		lblNewLabel_3.setBounds(10, 48, 198, 16);
		Register.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(171, 45, 116, 22);
		Register.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Please enter initial deposit \u00A3:");
		lblNewLabel_4.setBounds(10, 90, 262, 16);
		Register.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(210, 90, 116, 22);
		Register.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Submit\r\n");
		btnNewButton_3.setBounds(0, 120, 97, 25);
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				register(Integer.parseInt(textField_1.getText()), textField_2.getText(), textField_3.getText());
				Register.setVisible(false);
				loginOrRegister.setVisible(true);
				
			}
		});
		
		Register.add(btnNewButton_3);
		
		
		
	}
	
	public void register(int number, String password, String initialDeposit) 
	{
		
		accounts.add(new BankAccount(number, password, Double.parseDouble(initialDeposit))); // this should add the entered name into the account
		
	}
	
	public void login(String name, char[] password)
	{	
		boolean found = false;
		
		String convertedPassword = new String(password);
		
		for (BankAccount currentAccount : accounts)
		{
			//System.out.println(currentAccount.getName() + " " + name +  " " + currentAccount.getPassword() + " " + convertedPassword);
			
			if (name.equals(currentAccount.getNumber()) && convertedPassword.equals(currentAccount.getPassword()))
			{
				found = true;
				
				accountInUse = currentAccount;
				
				System.out.println("\nHello " + accountInUse.getNumber() + " you are sucsessfully logged in.");
				
				return;
				
			}
			
		}
		
		
		if (!found) System.err.println("Invalid details!");
			
	
	}
}

package emailapp;

import java.util.Scanner;

public class Email {
//Private makes it encapsulation: Not wanting anyone to access it 
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String department;
//Default mail capacity could be changed.
	private int mailboxCapacity = 500;
	private String alternateEmail;
	private String companySuffix = "aey.com";
	private int defaultPasswordLength = 10; 
	// Constructor to receive first and last name
	
	public Email (String firstName, String lastName) {
	//This. refers to the class of a variable, = firstname/lastname refers to the local variable that's being passed to the parameter thru the argument.
		this.firstName = firstName;
		this.lastName = lastName;	
		
	// Call a method for the department - return the department
		this.department = setDepartment();
		
	// Call a method that returns a random password 
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is: " + this.password);
		
	// Combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "."  + companySuffix;
	}
	
	// Ask for department
	private String setDepartment() {
	//Prompt the departments
		System.out.print("New worker: " + firstName + " Department codes: \n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code ");
	//Scanner object to read that - how to get user from the console.
		Scanner in = new Scanner(System.in);
	// To enter 0,1,2 or 3 based on that department will be set.
		int depChoice = in.nextInt();
		if (depChoice == 1) {return "sales";}	
		else if (depChoice == 2) {return "dev";}
		else if (depChoice == 3) {return "acct";}
		else {return "";}
	}
	// Generate a random password
	private String randomPassword(int length) {
	// Define what it's going to be chosen from - all the possibilities
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];// Password is equal to a new sequence of characters of the size of the length
	// So for each value inside the length it will grab the value inside the array
		for (int i=0; i<length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
// This is an encapsulate but making it public so it can set some properties and hiding the actual properties.
	// Set the mailbox capacity
	public void setMailboxCapacity(int capacity) {
	
		this.mailboxCapacity = capacity;
	}
	// Set the alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	// Change the password
	public void changePasswrod(String password) {
		this.password = password;
	}
// Public methods that's going to access the properties.
	public int getMAilCapacity() { return mailboxCapacity;}
	public String getAlternateEmail() {return alternateEmail;}
	public String getPassword() {return password;}
	
	public String showInfo () {
		return "DISPLAY NAME: " + firstName + " " + lastName +
				"\nCOMPANY EMAIL: " + email +
				"\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
								
	}
}

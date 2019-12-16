/**
 * 
 */
package edu.cvtc.edu;

/**
 * @author david.kittle
 *
 */
public abstract class BankAccount {
	// Variables 
	private double balance; 
	private double MIN_BALANCE = 0.0;

	//Default Constructor 
	public BankAccount() {
		
	}
	// Overloaded
	public BankAccount(double balance) {
		this.balance = balance;
		
	}
	// Getters and Setters 
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	public abstract void deposit(double amount);
	
	public abstract void withdraw(double amount);
	
	// toString
	@Override
	public String toString() {
		return "BankAccount [balance=" + balance + ", MIN_BALANCE=" + MIN_BALANCE + "]";
	}
	
	

}

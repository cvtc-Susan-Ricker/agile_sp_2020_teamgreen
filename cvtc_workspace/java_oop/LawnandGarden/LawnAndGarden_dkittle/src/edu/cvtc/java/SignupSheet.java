/**
 * 
 */
package edu.cvtc.java;

/**
 * @author david.kittle
 *
 */
public class SignupSheet {
	
	// Attributes 
	private Customer customer;
	private Service[] service; 
	
	//Default Constructor 
	public SignupSheet() {
		
	}
	
	// Methods Getters and Setters 
	public Customer getCustomer() {
		return this.customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer; 
	}
	
	public Service[] getService() {
		return this.service;
		
	}
	
	public void setService(Service[] service) {
		this.service = service;
	}
	

}

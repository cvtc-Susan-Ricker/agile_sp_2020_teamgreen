/**
 * 
 */
package edu.cvtc.edu;

/**
 * @author david.kittle
 *
 */
public class BankAccountDemoTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BusinessCheckingAccount accounts1= new BusinessCheckingAccount(100.1);
		FreeCheckingAccount accounts2 = new FreeCheckingAccount(101.0);
		SavingsAccount accounts3 = new SavingsAccount(6.0);
		

			if (accounts1 instanceof BusinessCheckingAccount) {
				accounts1.accruesInterest();
			} else {
				System.out.println("not an instace of BusinessCheckingAccount");
			}
			
			if (accounts2 instanceof FreeCheckingAccount) {
				accounts2.accruesInterest();
			} else {
				System.out.println("not an instace of FreeCheckingAccount");
			}
			
			if (accounts3 instanceof SavingsAccount) {
				accounts3.accruesInterest();
			} else {
				System.out.println("not an instace of SavingsAccount");
			}
			
					

		

	}

}

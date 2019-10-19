/**
 * 
 */
package edu.cvtc.java;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author david.kittle
 *
 */
public class FlooringCalculatorProgram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Attributes 
		 Integer length; 
		 Integer width; 
		 
		 Scanner keyboard = new Scanner(System.in);
		 DecimalFormat dollar = new DecimalFormat("#,###.00");

		 System.out.print("Enter the length: ");
		 length = keyboard.nextInt();
		 System.out.print("Enter the width: "); 
		 width = keyboard.nextInt();
		
		 System.out.println(RoomDimension.area(length, width));

	}

}

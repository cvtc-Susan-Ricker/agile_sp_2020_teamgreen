/**
 * 
 */
package edu.cvtc.java;


import java.util.Scanner;
import java.text.DecimalFormat;


/**
 * @author david.kittle
 *
 */
public class EmployeeApplicationProgram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String name = null; // hold the value of employeeName
		String number = null; // hold the value of employeePayRate 
		String dateHired = null; // hold the value of employeeHireDate
		Double monthlyBonus = null; // hold the value of teamLeaderMonthlyBonus
		Double trainHours = null; // hold the value of teamLeaderTrainingHours
		Double hoursAttended = null; // hold the value of teamLeaderHoursAttended
		Integer shift; // hold the value of workerShift
		Double payRate; // hold the value of workerPayRate 
		Double salary; // hold the value of supervisorAnnualSalary
		Double bonus; // hold the value of sepervisorAnnualBones

		
		// Create Objects for Employee, Production Worker, Shift Supervisor, Team Leader 
		Employee employee = new Employee();
		ProductionWorker productionWorker = new ProductionWorker(); 
		ShiftSupervisor shiftSupervisor = new ShiftSupervisor(); 
		TeamLeader teamLeader = new TeamLeader();
		
		
		// Scanner 
		Scanner input = new Scanner(System.in);
		// Formatting 
		DecimalFormat fmt = new DecimalFormat("$###,###.##");
		DecimalFormat ft = new DecimalFormat("####");
		
	
		// Input for Employee 
		System.out.println("Enter Employee Name: ");
		name = input.next();
		System.out.println("Enter Employee Number: ");
		number = input.next();
		System.out.println("Enter Employee Hire Date: ");
		dateHired = input.next();
         
		// Input for Production Worker 
        System.out.println("Enter the production worker shift: ");
        shift = input.nextInt();
        System.out.println("Enter the production worker Pay Rate: ");
        payRate = input.nextDouble();
        
		// Input for Shift Supervisor 
        System.out.println("Enter the Suprevisor Annual Salary: ");
        salary = input.nextDouble();
        System.out.println("Enter the Supervisor Annual Bonus: ");
        bonus = input.nextDouble();
        
		 // Input for Team Leader
        System.out.println("Enter Team Leader Monthly Bounus: ");
        monthlyBonus = input.nextDouble();
        System.out.println("Enter Team Leader Training Hours : ");
        trainHours = input.nextDouble();
        System.out.println("Enter Team Leader hours attented: ");
        hoursAttended = input.nextDouble();
        input.close();
        
        // Set Employee object  
        employee.setEmployeeName(name);
		employee.setEmployeeNumber(number);
		employee.setEmployeeHireDate(dateHired);
		
		// set the Team lead object 
        teamLeader.setTeamLeaderMonthlyBonus(monthlyBonus);
        teamLeader.setTeamLeaderTrainingHours(trainHours);
        teamLeader.setTeamLeadertrainHoursAttended(hoursAttended);
        
        // set the production worker object 
        productionWorker.setWorkerShift(shift);
        productionWorker.setWorkerPayRate(payRate);
        
        // set the Shift Supervisor 
        shiftSupervisor.setSupervisorAnnualSalary(salary);
        shiftSupervisor.setSupervisorAnnualBonus(bonus);
        
        // Display the Employee 
        System.out.println(" Employee Name is " + employee.getEmployeeName());
        System.out.println("Employee Number is " + employee.getEmployeeNumber());
        System.out.println("Employee Hire Date is " + employee.getEmployeeHireDate());
        
        // Display Team lead 
        System.out.println("Team lead Monthly Bonus is " + fmt.format(teamLeader.getTeamLeaderMonthlyBonus()));
        System.out.println("Team lead training hours are " + ft.format(teamLeader.getTeamLeaderTrainingHours()));
        System.out.println("Team lead hours attented are " + ft.format(teamLeader.getTeamLeadertrainHoursAttended()));
        
        // Display Production Worker
        System.out.println("Production Worker Shift is " + ft.format(productionWorker.getWorkerShift()));
        System.out.println("Production Worker Pay Rate is " + fmt.format(productionWorker.getWorkerPayRate()));
        
        // Display the Shift Supervisor 
        System.out.println("Shift Supervisor Annual Salary is  " + fmt.format(shiftSupervisor.getSupervisorAnnualSalary()));
        System.out.println("Shift Supervisor Annual Bonus is  " + fmt.format(shiftSupervisor.getSupervisorAnnualBonus()));
        
                

	}
	
	

}
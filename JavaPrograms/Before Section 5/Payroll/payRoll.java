/* 
Travis Delly
1/27/15
CIS 279 module 1
Programming Assignment 2.2
Textbook Programming Exercise 4.23
Point of program: Figuring out payroll after taxes.
*/
import java.util.Scanner;
public class payRoll{
	
	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args){
		System.out.println("Hello Welcome to the Payroll program");
		String name = "";
		double[] information = new double[4];
		getInfo(name, information);
		/* Separated information to make main look cleaner */
		
		System.out.println("\n\n");
		
		double total = information[0]*information[1];
		double fedPay = information[2]*(total);
		double statePay = information[3]*(total);
		double deductionTotal = fedPay + statePay;
		double netPay = total - deductionTotal;
		
		
		System.out.println("Employee Name: " + name);
		System.out.println("Hours worked: " + information[0]);
		System.out.println("Pay Rate: $" + information[1]);
		System.out.println("Gross Pay: $" + total);
		System.out.println("Deduction: ");
		System.out.println("\t Federal Tax Deduction: $" + fedPay);
		System.out.println("\t State Tax Deduction: $" + statePay);
		System.out.println("\t Total Deduction: $" + deductionTotal);
		System.out.println("Net Pay: $" + netPay);
	}
	public static void getInfo(String name, double[] information){
		System.out.print("Enter employee's name: ");
		name = input.nextLine();
		System.out.print("Enter number of hours worked: ");
		information[0] = input.nextDouble();
		System.out.print("Enter hourly pay rate: ");
		information[1] = input.nextDouble();
		System.out.print("Enter federal tax with-holding rate(0-100): ");
		information[2] = input.nextDouble()/100;
		System.out.print("Enter state tax with-holding rate(0-100): ");
		information[3] = input.nextDouble()/100;
		/*This only works if user doesn't input invalid data.... waiting for tryParse chapter!*/
	}
}	
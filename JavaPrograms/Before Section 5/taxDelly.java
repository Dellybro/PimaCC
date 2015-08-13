/* 
Travis Delly
Feb 6, 2015
CIS 279 module 4
Programming Assignment 4.3
Textbook Programming Exercises 8.12
Point of Assignment: Make tax brackets easier

Edit: Counter was going until 5 changed to go until length of size of 2nd dimension.
*/
import java.util.Scanner;
public class taxDelly{
	
	public static Scanner input = new Scanner(System.in);
	public static void main(String[] args){
		double[] taxRates = {0.10,0.15,0.25,0.28,0.33,0.35};
		int[][] Brackets = {
			{8350,33950,82250,171550,372950},
				{16700,67900,137050,200885,372950},
			{8350,13950,68525,104425,186475},
				{11950,45500,117450,190200,372950}
		};
		int status = 0;
		double tax;
		/*Initial variables*/
		
		
		while(status!=4){
			System.out.println("0-Single filer, 1-Married jointly or qualify widow, 2-married separately, 3-Head of household, 4-EXIT");
			System.out.print("Enter the filing status: ");
			status = input.nextInt();
			if(status !=4){
				System.out.print("Enter the taxable income: ");
				double income = input.nextDouble();
		
				tax = incomeRate(income, taxRates, Brackets, status);
				System.out.printf("\tTaxable: $%-10.2f \n\n", tax); 
			}
		}

		
	}
	public static double incomeRate(double income, double[] taxRates, int[][] Brackets, int status){
		double tax = 0;
		for(int i = 1; i< Brackets[1].length;i++){
			if(income <= Brackets[status][0]){
				tax = income * taxRates[0];
				return tax;
			}/*For income less than first bracket*/
			else if(income <= Brackets[status][i]){
				tax = Brackets[status][0]*taxRates[0];
				if(i!=1){
				for(int j = 0; j < i; j++){
					tax = tax + (Brackets[status][j+1] - Brackets[status][j]) * taxRates[j+1]; 
				}
				return tax = tax + ((income-Brackets[status][i]) * taxRates[i+1]);
				}
				else{
					return Brackets[0][0]*taxRates[0] + (income - Brackets[0][0]) * taxRates[1];
				}/*For income greater than 2nd bracket but less than last bracket*/
			}
			else if(income > Brackets[status][4]){
				tax = Brackets[status][0]*taxRates[0];
				for(int j = 0; j < 4; j++){
					tax = tax + (Brackets[status][j+1] - Brackets[status][j]) * taxRates[j+1]; 
					if(j == 3){
						tax = tax + ((income - Brackets[0][j+1]) * taxRates[j+2]);
						return tax;
					}
				}/*For income any higher than last bracket*/
			}
		}
		
		return tax;
	}
}


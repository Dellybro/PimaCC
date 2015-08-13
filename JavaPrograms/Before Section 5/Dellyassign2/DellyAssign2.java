/* 
Travis Delly
Jan 22, 2015
CIS 279 module 1
Programming Assignment 1.2
Textbook Programming Exercise 2.17
Wind-chill index (apparent temparature due to wind-chill) calculation.  Reads the following from user input: 

Temperature (Fahrenheit between -58 and +41)
Wind speed (>= 2 mph)

Calculates and displays the resulting wind-chill index.  
*/ 
import java.util.Scanner; // utilizes input;

class Windchill{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("This program will decide the WindChill");
		System.out.println("Enter the Fahrenheit between -58 and 41:");
		double Fahrenheit = input.nextDouble(); //User input
		boolean exit = false; //Created a boolean for whileLoop
		while(exit == false)
		{
			if(Fahrenheit > 41 || Fahrenheit < -58)
			{
				System.out.println("Enter -58 - 41");
				Fahrenheit = input.nextDouble();
			}
			else{
				exit = true; //Exits if Fahrenheit is valid tempature
			}
		}
		System.out.println("Enter the wind speed (>= 2) in miles per hour:");
		int windSpeed = input.nextInt();
		exit = false; // Reset boolean value
		while(exit == true)
		{
			if(windSpeed < 2){
				System.out.println(" >= 2");
				windSpeed = input.nextInt();
			}
			else{
				exit = true;
			}
		}
		double windSpeed2 = Math.pow(windSpeed, .16);
		double total = (35.74 + (0.6215*Fahrenheit) - 35.75*windSpeed2 + (0.4275*windSpeed2*Fahrenheit));
		System.out.println(total);
		//End Program;
	}
}
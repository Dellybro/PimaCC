/* 
Travis Delly
1/27/15
CIS 279 module 1
Programming Assignment 2.2
Textbook Programming Exercise 4.23
Point of program: Value of Pi
*/
import java.util.Scanner;
public class valueOfPi{
	
	public static void main(String[] args){
		double startPoint = 1;
		double numerator = 1;
		double denom = 1;
		int count = 0;
		for(int i = 3; i < 100055; i = i + 2){ /*I offset the number for it to stop on to ensure all values are shown */
			numerator = numerator*-1;
			denom = denom + 2;
			startPoint = startPoint + numerator/denom;
			count++;
			if(count == 5000){
				System.out.println(startPoint*4);
				count = 0;
			}
		}
		
		System.out.println("\n\n Pi is served!");
	}
}
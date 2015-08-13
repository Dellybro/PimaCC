/* 
Travis Delly
1/27/15
CIS 279 module 1
Programming Assignment 2.1
Textbook Programming Exercise 3.17
Point of program: Play rock paper scissors with the "program", which generates a number 0-2
These are each implemented in the main() method of this class.  
*/
import java.util.Scanner;
public class RPS{
	
	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args){
		int userChoice = -1;
		int programChoice = -1;
		String[] wordArray = {"Rock", "Paper", "Scissors"};
		System.out.println("Hello Welcome to RoshamBoe! (A.K.A Rock, Paper, Scissors)");
		
		
		userChoice = getUser(userChoice);
		programChoice = getProgram(programChoice);
		System.out.println("\nProgram chose " + wordArray[userChoice] + " and you are " + wordArray[programChoice]);
		
		int win = winner(userChoice, programChoice);
		switch(win){
			case 0:
				System.out.println("\nDraw!");
				break;
				
			case 1:
				System.out.println("\nPlayer Wins!");
				break;
			case 2:
				System.out.println("\nProgram Wins!");
				break;
		} /* Winner returns 0-2, Switch choses appropriate match */
	}
	public static int getUser(int userChoice){
		while(userChoice < 0 || userChoice > 2){
			System.out.print("Now than chose Rock(0), paper(1), or scissors(2): ");
			userChoice = input.nextInt();
		}/*Use a while loop in order to check if user input correct data*/
		return userChoice;
	}
	public static int getProgram(int programChoice){
		while(programChoice < 0 || programChoice > 2){
			/*Do the same thing for the computer using Math.random
			Using this code though, i've noticed 0 is hit more times than 1 and 2.*/
			programChoice = (int)(Math.random()*10);
		}
		return programChoice;
	}
	public static int winner(int choice1, int choice2){
		if(choice1 == choice2){
			return 0; /* 0 is used as draw */
		}
		if(choice1 == 0){
			if(choice2 == 1){
				return 2;
			}
			if(choice2 == 2){
				return 1;
			}
		}/* Rock Win */
		if(choice1 == 1){
			if(choice2 == 0){
				return 1;
			}
			if(choice2 == 2){
				return 2;
			}
		}/* Paper Win */
		if(choice1 == 2){
			if(choice2 == 0){
				return 2;
			}
			if(choice2 == 1){
				return 1;
			}
		}/* Scissors Win */
		return 0; /*default*/
	}
}
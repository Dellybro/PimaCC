/*
Developper - Travis Delly
Assignment 7.1
March/19/2015
Purpose - Learn how to handle exceptions


*/

import java.util.*;

public class Utilities{

	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {


		tryCatch();
		System.out.println("Now without using try/Catch");
		misMatch();

	}

	public static int misMatch(){
		System.out.print("\nEnter a number: ");

		//The way i'm catching the input here is by simply using an if
		//statement to check the next line, one the line is checked
		//if true, do something, if false, return nothing.

		if (input.hasNextInt()){
			int userInput = input.nextInt();
			System.out.println("You number was " + userInput + "\n");
			return userInput;
		} else {
			System.out.println("Returning nothing and exiting.. Integer was required...\n");
		}
		return 0;
	}

	public static int tryCatch(){
		while(true) {
			try{
				System.out.print("Enter a number: ");
				int userInput = input.nextInt();
				System.out.println("Your number was " + userInput + "\n\n");
				return userInput;
			}
			catch(InputMismatchException ex) {
				System.out.println("Integer is required");
				//This is the important part of the catch sequence
				//Once the Java program realizes an error occured
				//We need to fix it by chomping the line
				input.nextLine();
			}
		}
	}

	
}
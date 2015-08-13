/*
Developper - Travis Delly
Assignment 7.1
March/19/2015
Purpose - Learn how to handle exceptions


*/

import java.util.*;

public class parseInput{
	public static Scanner input = new Scanner(System.in);
	public static <E>
			int strInput(String type){
			while (true){
			try{
				System.out.print("Enter a " + type +": ");
				int userInput = input.nextInt();
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

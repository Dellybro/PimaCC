/*
Developper - Travis Delly
Assignment 8.2
March/19/2015
Purpose - Inheritance Cloneable


*/

import java.util.*;

public class Utilites{
	public static Scanner input = new Scanner(System.in);
	public static double strInput(String type){
			while (true){
			try{
				System.out.print("Enter a " + type +": ");
				double userInput = input.nextDouble();
				return userInput;
			}
			catch(InputMismatchException ex) {
				System.out.println("Integer - Double is required");
				//This is the important part of the catch sequence
				//Once the Java program realizes an error occured
				//We need to fix it by chomping the line
				input.nextLine();
			}
		}
	}
}

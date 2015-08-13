
/* 
Travis Delly
April 2nd, 2015
CIS 279 module 10
Programming Assignment 10.2
Textbook Programming Exercises 20.11
Point of Assignment: Learning stacks

*/

import java.io.FileNotFoundException;
import java.util.*;


public class MatchGroupingSymbols {
	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Name of File: ");
		String fileName = input.nextLine();
		//Ask user for filename using commandline
		
		java.io.File file = new java.io.File(fileName);
		if(file.exists()){
			System.out.println("File exists...");
		}else{
			System.out.println("File does not exist.. Exiting");
			System.exit(1);
		}//Check if file exists if it doesnt exit.

		//createScanner
		Scanner scanFile = new Scanner(file);
		//CheckFile
		if(checkSymbols(scanFile)){
			System.out.println("No error found while grouping symbols");
		} else {
			System.out.println("Error found in grouping symbols");
		}
	}

	public static boolean checkSymbols(Scanner scanFile){
		Stack<Character> myList = new Stack<>();
		//Scan using Delimiter to check for char
		scanFile.useDelimiter("");
		while(scanFile.hasNext()){
			Character word = scanFile.next().charAt(0);
			if(word == '[' || word == '{' || word == '('){
				myList.add(word);
			} else if(word == ']' || word == '}' || word == ')'){
				if(word == ']' && myList.peek() == '[') {
					myList.pop();
				} else if(word == '}' && myList.peek() == '{') {
					myList.pop();
				} else if(word == ')' && myList.peek() == '('){
					myList.pop();
				}
			}//myList stacks the first symbol
		}//Once a second symbol if found it check if the last symbol is the symbols other part
		//If the second symbol matches first symbol gets popped off stack,
		//by the end if the stack isnt empty that means the grouping was incorrect
		if (myList.isEmpty()) { return  true; } else { return false; }
	}
}
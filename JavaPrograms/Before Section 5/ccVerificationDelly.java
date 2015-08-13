/* 
Travis Delly
1/27/15
CIS 279 module 1
Programming Assignment: 3.1
Textbook Programming Exercise 6.28
Point of program:Check whether or not CC is valid. 
*/

import java.util.Scanner;

public class ccVerificationDelly{
	
	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args){
		System.out.print("Card Number:");
		String userCC = input.nextLine();
		getSize(userCC);
		/*User input return if not between 13-16*/
		long tempUserCC = Long.parseLong(userCC);
		if(isValid(tempUserCC)){
			System.out.println("Valid");
		}
		else{
			System.out.println("Invalid");
		}
		/*end of main*/
	}
	public static boolean isValid(long number){
		String numHolder = Long.toString(number);
		/*convert to string*/
		int doubleUp;
		int total = 0;
		for(int i = numHolder.length()-2; i >= 0 ; i = i - 2){
			char c = numHolder.charAt(i);
			/*Convert to char*/
			doubleUp = Character.getNumericValue(c);
			doubleUp = doubleUp*2;
			if(doubleUp > 9){
				doubleUp = getDigit(doubleUp);
			}
			total = total + doubleUp;
		}
		int sumTotal = sumOfOddPlace(number);
		int realTotal = sumTotal + total;
		/* *TESTS* System.out.println(sumTotal);
		System.out.println(total);
		System.out.println(realTotal); *TEST* */
		if(realTotal%10 == 0){
			if(prefixMatched(number)){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
		/*Double if don't forget double else*/
	}
	//Return the sum of a single or else return 12 = 1 + 2 = 3;
	public static int getDigit(int number){
		String split = Integer.toString(number);
		int d1 = Character.getNumericValue(split.charAt(0));
		int d2 = Character.getNumericValue(split.charAt(1));
		number = d1 + d2;
		return number;
		/*if number > 9 split up values*/
	}
	//return sum of odd placed digits
	public static int sumOfOddPlace(long number){
		String numHolder = Long.toString(number);
		int start;
		int total = 0;
		for(int i = 1; i < numHolder.length(); i = i + 2){
			char c = numHolder.charAt(i);
			start = Character.getNumericValue(c);
			total = total + start;
		}
		return total;
	/*every other variable*/
	}
	public static boolean prefixMatched(long number){
		String numHolder = Long.toString(number); 
		char[] checker = new char[3];
		if(getPrefix(checker, numHolder)){
			return true;
		}
		else{
			return false;
		}
		
	}
	public static String getSize(String d){
		while(d.length() > 16 || d.length() < 13){
			System.out.print("Invalid # of digits\n Card Number:");
			d = input.nextLine();
		}
		return d;
	}
	//Return first k number of digits from number, if number of digits in number is less than k
	//return number
	public static boolean getPrefix(char[] checker, String numHolder){
		for(int i = 0; i < 3; i++){
			checker[i] = numHolder.charAt(i);
		}
		if(checker[0] == '4'){
			return true;
		}
		else if(checker[0] == '5'){
			return true;
		}
		else if(checker[0] == '6'){
			return true;
		}
		else if(checker[0] == '3' && checker[1] == '7'){
			return true;
		}
		else{
			return false;}
	}
}
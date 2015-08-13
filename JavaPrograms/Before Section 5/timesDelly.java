/* 
Travis Delly
Feb 6, 2015
CIS 279 module 4
Programming Assignment 4.2
Textbook Programming Exercises 8.6
Point of Assignment: Multiply Matrices


Edited: Major bug, printing new array, for loop was breaking it because i didnt
have the size of dimensions correct.
*/


import java.util.Scanner;
/*Start class*/
public class timesDelly{
	
	public static Scanner input = new Scanner(System.in);
	public static void main(String[] args){
		/*Initial Variables*/
		int firstSize1 = 0;
		int firstSize2 = 0;
		int secondSize1 = 1;
		int secondSize2 = 1;
		

		while(firstSize1 != secondSize2){
			System.out.println("What size would you like your first matrix?");
			System.out.println("First x Second");
			firstSize1 = input.nextInt();
			firstSize2 = input.nextInt();
			System.out.println("What size would you like your first matrix?");
			secondSize1 = input.nextInt();
			secondSize2 = input.nextInt();
		}
		double[][] multiArray1 = new double[firstSize1][firstSize2];
		double[][] multiArray2 = new double[secondSize1][secondSize2];
		/*Initial arrays and output given and created.*/
		double[][] multipliedArray3 = multiplyMatrix(multiArray1, multiArray2,firstSize1,firstSize2,secondSize1,secondSize2);
		/*New Array multiplied*/
		for(int i = 0; i<multipliedArray3[0].length;i++){
			for(int j = 0; j<multipliedArray3[1].length;j++){
				System.out.print(multipliedArray3[i][j] + ",  ");
			}
			System.out.println();
		}
		/*New Array printed*/
	}
	public static double[][] multiplyMatrix(double[][] array1, double[][] array2, int firstSize1, int firstSize2, int secondSize1, int secondSize2){
		System.out.print("\n\nEnter " + firstSize1*firstSize2 + " numbers for the first Array: ");
		System.out.println("\nEx Matrix.\t1,2,3");
		System.out.println("\t\t4,5,6");
		System.out.println("\t\t7,8,9");
		/*Ex. of how input gets put into Matrices*/
		for(int i = 0; i<firstSize1;i++){
			for(int j = 0; j<firstSize2;j++){
				array1[i][j] = input.nextDouble();
			}
		}
		System.out.println("\n\nEnter " + secondSize1*secondSize2 + " numbers for the second Array: ");
		for(int i = 0; i<secondSize1;i++){
			for(int j = 0; j<secondSize2;j++){
				array2[i][j] = input.nextDouble();
			}
		}
		/*Input numbers for both arrays*/
		double[][] newArray = new double[firstSize1][secondSize2];
		double newNumber = 0;
		/*Initialize new number before for loop*/
         for (int i = 0 ; i < firstSize1 ; i++ ) {
            for (int j = 0 ; j < secondSize2 ; j++ ){   
               for (int k = 0 ; k < secondSize1 ; k++ ){
                  newNumber = newNumber + array1[i][k]*array2[k][j];
               }
			   newArray[i][j] = newNumber;
               newNumber = 0;
            }
         }
		return newArray;
		/*Returned newArray*/
	}
}
/* 
Travis Delly
1/29/15
CIS 279 module 1
Programming Assignment 3.2
Textbook Programming Exercise 18.18
Point of program: Tower of Hanoi, count number of moves from tower A to tower B
*/

import java.util.Scanner;
public class TowerOfH{
	
	private static Scanner input = new Scanner(System.in);
	public static int count = 0;
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter number of disks: ");
		int n = input.nextInt();
		
		System.out.println("The moves are: ");
		moveDisks(n, 'A', 'B', 'C');
		
		System.out.println("\nThe total amount of moves from A to B: " + count);
		
	}
	public static void moveDisks(int n, char fromTower, char toTower, char auxTower){
		if(n == 1){
			System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
		} // stopping condition
		else{
			moveDisks(n-1, fromTower, auxTower, toTower);
			System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
			moveDisks(n-1, auxTower, toTower, fromTower);
		}
		count++;
	}
}
/*
Modify listing 18.8 TowerOfHanoi.java so that the program finds the number of moves needed to 
move disks from tower A to tower B. (Use a static Variable increment it every time method is called(recursively))

So i'm a little confused becauase this assigment is pretty simple, i made a static variable before the main
so i could call it throughout the program and made it static so it could be changed.
*/
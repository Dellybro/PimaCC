/* 
Travis Delly
Feb 15, 2015
CIS 279 module 5
Programming Assignment 5.2
Textbook Programming Exercises 10.11
Point of Assignment: Learning classes

*/
public class lapCirclesDelly{
	
	public static void main(String[] args){
		Circle c1 = new Circle(2,2,5.5);
		System.out.println("The radius of c1 is: " + c1.getRadius() + "\nThe X coordinate: " + c1.getX() + "\nThe Y coordinate: " + c1.getY());
		
		System.out.println("\n The result of the 3 methods is as follows: ");
		System.out.println("\nX and Y inside c1: " +  c1.inside(3,3) + "\nc1 inside newCircle: " + c1.contain(new Circle(4,5,10.5)) + "\nc1 overlaps with newCircle: " + c1.overlaps(new Circle(3,5,2.3)));
		
		
		
	}
}
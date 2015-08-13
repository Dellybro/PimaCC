/* 
Travis Delly
Feb 15, 2015
CIS 279 module 5
Programming Assignment 5.1
Textbook Programming Exercises 9.9
Point of Assignment: Learning classes

*/
public class testPolygon{
	public static void main(String[] args){
		dellyPolygon myPolyone = new dellyPolygon();
		dellyPolygon myPolytwo = new dellyPolygon(6,4);
		dellyPolygon myPolythree = new dellyPolygon(10, 4.0, 5.6, 7.8);
		
		System.out.println("Perimeter 1: " + myPolyone.getPerimeter() + "\nArea 1: " + myPolyone.getArea());
		System.out.println("Perimeter 2: " + myPolytwo.getPerimeter() + "\nArea 2: " + myPolytwo.getArea());
		System.out.println("Perimeter 3: " + myPolythree.getPerimeter() + "\nArea 3: " + myPolythree.getArea());
	}
}
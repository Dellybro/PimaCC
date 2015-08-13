/* 
Travis Delly
Feb 15, 2015
CIS 279 module 5
Programming Assignment 5.1
Textbook Programming Exercises 9.9
Point of Assignment: Learning classes

*/
import java.util.Scanner;
public class dellyPolygon{
	private int n;
	private double length;
	private double x;
	private double y;
	/*Variables*/
	public dellyPolygon(){
		this.n = 3;
		this.length = 1;
		this.x = 0;
		this.y = 0;
	}
	public dellyPolygon(int n, double length){
		this.n = n;
		this.length = length;
	}
	public dellyPolygon(int n, double length, double x, double y){
		this.n = n;
		this.length = length;
		this.x = x;
		this.y = x;
	}
	/*Constructors*/
	public double getPerimeter(){
		return length*n;
	}
	public double getArea(){
		return (this.n*Math.pow(this.length, 2))/(4*Math.tan(Math.PI/this.n));
	}
}

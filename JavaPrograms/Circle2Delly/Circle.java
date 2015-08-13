/* 
Travis Delly
Feb 15, 2015
CIS 279 module 5
Programming Assignment 5.2
Textbook Programming Exercises 10.11
Point of Assignment: Learning classes

*/



public class Circle{
	private double x;
	private double y;
	private double radius;
	
	public double getX(){
		return this.x;
	}
	public double getY(){
		return this.y;
	}
	public double getRadius(){
		return this.radius;
	}
	public Circle(){
		this.x = 0;
		this.y = 0;
		this.radius = 1;
	}
	public Circle(double x, double y, double radius){
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	public double getArea(){
		return Math.PI*Math.pow(this.getRadius(),2);
	}
	public double getPerimeter(){
		return Math.PI*2*this.getRadius();
	}
	public boolean inside(double x, double y){
		double distance = Math.sqrt(Math.pow(y-this.getY(),2) + Math.pow(x-this.getX(),2));
		if(distance < this.radius){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean contain(Circle theCircle){
		double distance = Math.sqrt(Math.pow(theCircle.getY()-this.getY(),2) + Math.pow(theCircle.getX()-this.getX(),2));
		double totalRadius = this.getRadius() + theCircle.getRadius();
		
		if(distance < theCircle.getRadius()){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean overlaps(Circle theCircle){
		double distance = Math.sqrt(Math.pow(theCircle.getY()-this.getY(),2) + Math.pow(theCircle.getX()-this.getX(),2));
		double totalRadius = this.getRadius() + theCircle.getRadius();
		
		if(distance <= totalRadius){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	
	
}

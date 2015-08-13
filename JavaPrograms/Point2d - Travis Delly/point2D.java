/*
Developper - Travis Delly
Assignment 6.1
feb/16/2015
Purpose - Distance of 2 points using classes


*/

public class point2D{
	private double x;
	private double y;
	
	public point2D(){
		this.x = 0;
		this.y = 0;
	}
	public point2D(double x, double y){
		this.x = x;
		this.y = y;
	}
	public double distance(double x, double y){
		return Math.sqrt(Math.pow(y-this.getY(),2) + Math.pow(x-this.getX(),2));
	}
	public double distance(point2D difPoint){
		return Math.sqrt(Math.pow(difPoint.getY()-this.getY(),2) + Math.pow(difPoint.getX()-this.getX(),2));
	}
	
	
	
	/*Setter and getter methods*/
	public void setX(double x){
		this.x = x;
	}
	public void setY(double y){
		this.y = y;
	}
	public double getX(){
		return this.x;
	}
	public double getY(){
		return this.y;
	}
	
}
/*
 * 	Programmer: TravisDelly
 *  Date: March 19th, 2015
 *  PointofProgram -> Learn loads about inheritance and polymorphism
 *  Assignment: 8.1
 */

import java.util.Date;


public abstract class GeometricObject implements Comparable<GeometricObject> {
	private String color = "white";
	private boolean filled;
	private java.util.Date dateCreated;
	
	
	protected GeometricObject(String color, boolean filled) {
		dateCreated = new java.util.Date();
		this.color = color;
		this.filled = filled;
	}


	protected GeometricObject() {
		dateCreated = new java.util.Date();
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}


	public boolean isFilled() {
		return filled;
	}


	public void setFilled(boolean filled) {
		this.filled = filled;
	}


	public java.util.Date getDateCreated() {
		return dateCreated;
	}
	
	@Override
	public String toString() {
		return "Creatd on: " + dateCreated + "\nColor: " + color + "\nFilled: " + filled;
	}
	//AbstractMethod
	public abstract double getArea();
	//AbstractMethod
	public abstract double getPerimeter();


	public int compareTo(Circle o) {
		return 0;
	}



}

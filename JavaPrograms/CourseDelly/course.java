/*
 
 Developper - Travis Delly
 Assignment 6.2
 feb/16/2015
 Purpose - course class. Learning inheritance and polymorphism

 Edit: 3/29/15, added header
*/

import java.util.ArrayList;

public class course {
	private String courseName;
	ArrayList<String> studentsList = new ArrayList<>();
	private int numberOfStudent;
	
    
    
	public int getNumberOf(){
		return this.numberOfStudent;
	}
	public course(String courseName){
		this.courseName = courseName;
	}
	public void addStudent(String newStudent){
		studentsList.add(newStudent);
		this.numberOfStudent++;
	}
	public void deleteStudent(String studtoDelete){
		studentsList.remove(studtoDelete);
		this.numberOfStudent--;
	}
	public String getcourseName(){
		return this.courseName;
	}
}
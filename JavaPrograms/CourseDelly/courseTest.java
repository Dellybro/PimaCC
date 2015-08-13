/*
 
 Developper - Travis Delly
 Assignment 6.2
 feb/16/2015
 Purpose - course class. Learning inheritance and polymorphism
 
 Edit: 3/29/15, added header
 */

public class courseTest{
	public static void main(String[] args){
		course Data = new course("Data Structures");
		course Systems = new course("DataBase Systems");
	
		Data.addStudent("Peter Jones");
		Data.addStudent("Travis Delly");
		Data.addStudent("Remy Smith");
	
		Systems.addStudent("Travis Delly");
		Systems.addStudent("Remy Smith");
		
		System.out.println("Number of Students in Data: " + Data.studentsList.size());
		for(int i = 0; i < Data.studentsList.size();i++){
			System.out.println("Student Name: " + Data.studentsList.get(i));
		}
		
		System.out.println("\nNumber of Students in Systems: " + Systems.studentsList.size());
		for(int i = 0; i < Systems.studentsList.size();i++){
			System.out.println("Student Name: " + Systems.studentsList.get(i));
		}
	}
	
}
#include "Student.h"

#include <cstring>
#include <sstream>
#include <string>
#include "Utility.h"

int Student::getStudentID(){
	return this->StudentID;
}
char* Student::getLastName(){
	return this->firstName;
}
char* Student::getFirstName(){
	return this->lastName;
}
char* Student::getMajorCode(){
	return this->MajorCode;
}
int Student::getCredits(){
	return this->credits;
}
double Student::getGPA(){
	return this->GPA;
}
/*Get*/
/*Set*/
Student::Student(){
	setFirstName("");
	setLastName("");
	setStudentID(0);
	setMajorCode("");
	setCredits(0);
	setGPA(0);
}
Student::Student(int SD, char* last, char* first, char* code, int credit, double gpa){
	setFirstName(first);
	setLastName(last);
	setStudentID(SD);
	setMajorCode(code);
	setCredits(credit);
	setGPA(gpa);

}
string Student::toString(){
	return  "Student ID  : " + UtilityFunctions::convertToString(StudentID) + "\n" +
		"Last name   : " + UtilityFunctions::convertToString(lastName) + "\n" +
		"First Name  : " + UtilityFunctions::convertToString(firstName) + "\n" +
		"Major Code  : " + UtilityFunctions::convertToString(MajorCode) + "\n" +
		"Credits     : " + UtilityFunctions::convertToString(credits) + "\n" +
		"Student GPA : " + UtilityFunctions::convertToString(GPA) + "\n" +
		"\n";

}
void Student::setStudentID(int studentID){
	this->StudentID = studentID;
}
void Student::setLastName(char* firstName){
	strcpy_s(this->lastName, firstName);
}
void Student::setFirstName(char* lastName){
	strcpy_s(this->firstName, lastName);
}
void Student::setMajorCode(char* majorCode){
	strcpy_s(MajorCode, majorCode);
	/*testing without this.*/
}
void Student::setCredits(int credits){
	this->credits = credits;
}
void Student::setGPA(double gpa){
	GPA = gpa;
}
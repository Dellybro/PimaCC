
#ifndef _STUDENT
#define _STUDENT

#include <string>
#include <iostream>


using namespace std;

class Student{
public:
	int getStudentID();
	char* getLastName();
	char* getFirstName();
	char* getMajorCode();
	int getCredits();
	double getGPA();
	/*Get*/
	/*Set*/
	void setStudentID(int studentID);
	void setLastName(char* lastName);
	void setFirstName(char* firstName);
	void setMajorCode(char* majorCode);
	void setCredits(int credits);
	void setGPA(double gpa);

	/*toString*/
	string toString();

	Student();
	Student(int, char*, char*, char*, int, double);


private:
	//StudentID, lastName, firstName, major, credits, gpa
	int StudentID;
	char lastName[20];
	char firstName[20];
	char MajorCode[20];
	int credits;
	double GPA;

	

};
#endif
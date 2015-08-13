/*
Programmer - Travis Delly
Purpose - Write students into a vector class;
Date - 2/13/15
Assignment 6

I feel like i went a little above and beyond on this project
The only thing I'm still having a problem with is tryparsing inputs...
My program is easily breakable, just type a wrong data type when asked...

*/

#include <iostream>
#include <fstream>
#include "Student.h"
#include "Utility.h"
#include <vector>

using namespace std;



const char FILE_NAME[] = "C:\\Users\\Dellybro\\Desktop\\C++\\Holder";
void initialObjects(fstream& bW, vector<Student> &stud);
void writeFile(fstream& binaryFS, vector<Student>& student);
void menu();
Student newStudent(fstream& binaryFS);
void readAll();
/*All Extra Methods I fealt didn't need to be written for this assignment*/



/*Reads in FILE_NAME*/
bool fileRead(fstream& binaryFS, Student& StudInput)
{
	binaryFS.read(reinterpret_cast<char*> (&StudInput), sizeof(Student));

	if (!binaryFS)
		return true;
	else
		return false;
}
vector<Student> readFile()
{
	vector<Student> stud;
	Student holder;
	fstream binaryReader;
	/*Stud pushes back the holders, and binary Reader reads the File*/

	/*These lines write from the file to the vector*/

	binaryReader.open(FILE_NAME, ios::in | ios::binary);

	bool eof = fileRead(binaryReader, holder);
	while (!eof){
		stud.push_back(holder);
		eof = fileRead(binaryReader, holder);
	}

	binaryReader.close();
	/*End read file*/


	return stud;
}
/*End readFile*/


/*Read Record*/
void readRecord(fstream& binaryFS, Student& studInput){
	Student theReader;
	binaryFS.open(FILE_NAME, ios::in | ios::binary);
	bool eof = fileRead(binaryFS, theReader);
	while (!eof){
		if (theReader.getStudentID() == studInput.getStudentID()){
			cout << theReader.toString();
		}
		eof = fileRead(binaryFS, theReader);
	}
	binaryFS.close();

	cout << "Reading Record..." << studInput.getStudentID();
	cin.get();

}
void whosRecord(fstream& binaryFS, vector<Student>& studInput){
	int choice;

	cout << "Who's record are you editing?\n";
	for (size_t i = 0; i < studInput.size(); i++){
		cout << i << ". " << studInput[i].getFirstName() << endl;
	}
	cin >> choice;
	cin.ignore();
	system("cls");
	readRecord(binaryFS, studInput[choice]);
}
/*read Records*/


/*Update Record*/
void updateStudent(fstream& binaryFS, Student& studInput, int pos){
	Student theWriter;

	binaryFS.open(FILE_NAME, ios::in | ios::out | ios::binary);
	int beginPoint = (pos * (sizeof(Student)));
	/*Because im loading and saving in a vector, this ended up working, for every position multiply it by sizeof student
	once mulitiplied it should be on the correct file to write over... file 5 = 5 * 80 = pos 400. */
	binaryFS.seekp(beginPoint);
	binaryFS.write(reinterpret_cast<char*> (&studInput), sizeof(Student));

	binaryFS.close();
	cout << "Updating student..." << studInput.getStudentID();
	cin.get();
	cin.ignore();


}
void updateWho(fstream& binaryFS, vector<Student>& list){
	/*UserChoices*/
	int choice;
	char field;
	/*User Fields*/
	int ID = 0;
	double gpa = 0;
	int credits = 0;
	char firstName[20];
	char lastName[20];
	char Major[20];
	/*I could make this into a struct*/

	bool update = true;
	cout << "Who's record are you editing?\n";
	for (size_t i = 0; i < list.size(); i++){
		cout << i << ". " << list[i].getFirstName() << endl;
	}
	cin >> choice;
	Student holder = list[choice]; /*Create student Holder incase user doesnt update*/

	while (update){
		system("cls");
		cout << holder.toString();
		cout << "\n\n Type 1-6 to change a field: ";
		cout << "\n <8. Save and Exit>";
		cout << "\n <9. Quit without saving>\n\n Enter input: ";
		cin.ignore();
		cin >> field;
		cin.ignore();


		switch (field){
		case '1':
			cout << "\n\n New ID: ";
			cin >> ID;
			holder.setStudentID(ID);
			break;
		case '2':
			cout << "\n\n New Last Name: ";
			cin >> lastName;
			holder.setLastName(lastName);
			break;
		case '3':
			cout << "\n\n New firstName: ";
			cin >> firstName;
			holder.setFirstName(firstName);
			break;
		case '4':
			cout << "\n\n New major: ";
			cin >> Major;
			holder.setMajorCode(Major);
			break;
		case '5':
			cout << "\n\n New Credits: ";
			cin >> credits;
			holder.setCredits(credits);
			break;
		case '6':
			cout << "\n\n New gpa: ";
			cin >> gpa;
			holder.setGPA(gpa);
			break;
		case '8':
			update = false;
			list[choice] = holder;
			updateStudent(binaryFS, list[choice], choice);
			break;
		case '9':
			update = false;
			break;
		default:
			break;
		}
	}
}
/*End update Record*/


void assignmentPage(fstream& binaryFS, vector<Student>& list){
	system("cls");


	readRecord(binaryFS, list[1]);
	cout << "\n";
	list[2].setMajorCode("Justice");
	updateStudent(binaryFS, list[2], 2);
	readRecord(binaryFS, list[2]);
	list[3].setCredits(75);
	updateStudent(binaryFS, list[3], 3);
	readRecord(binaryFS, list[3]);
	list[4].setGPA(3.5);
	updateStudent(binaryFS, list[4], 4);
	readRecord(binaryFS, list[4]);

	cout << "\n\n Assignment Page. Read and change 3 records." << endl;
	system("pause");
}
void readAll(){
	/*Read*/
	fstream binaryFS;
	binaryFS.open(FILE_NAME, ios::in | ios::binary);


	Student studInput;
	bool eof = false;
	while (eof == false){
		if (!binaryFS.read(reinterpret_cast<char*> (&studInput), sizeof(Student))){
			eof = true;
		}
		else{
			cout << "\n" << studInput.toString() << "\n";
		}
	}

	binaryFS.close();
	system("pause");
	/*Read end*/
}
int main()
{
	fstream binaryFS;
	vector<Student> stud = readFile();
	//initialObjects(binaryFS, stud); //UNCOMMENT FOR INITIAL 5 WITHOUT LOADIN FROM FILE;
	bool program = true;

	while (program){
		system("cls");
		menu();
		char choice;
		cin >> (choice);

		switch (choice){
		case '1':/*Also appends to file*/
			stud.push_back(newStudent(binaryFS));
			break;
		case '2':
			updateWho(binaryFS, stud);
			break;
		case '3':/*Just a method that doesn't need to exist*/
			writeFile(binaryFS, stud);
			break;
		case '4':/*Reads file until EOF*/
			readAll();
			break;
		case '5':/*Reads specific Record*/
			whosRecord(binaryFS, stud);
			break;
		case '6':/*Closes Program*/
			program = false;
			break;
		case '7':
			assignmentPage(binaryFS, stud);
			break;
		default:
			cout << "---------------Chose another option-------------\n";
			cin.get();
			cin.ignore();
		}
	}

	system("pause");

	return 0;

}








/*Extra Methods*/
void menu(){
	cout << "1. Add Student\n"
		"2. Update Student"
		"\n3. Write to File<Emergency only | Ex. File deleted, vectors secure input>"
		"\n4. Show all Student"
		"\n5. Read file"
		"\n6. Exit"
		"\n7. Assignment Page"
		"\n\nEnter Input ";
}
void initialObjects(fstream& bW, vector<Student>& stud){
	bW.open(FILE_NAME, ios::out | ios::binary);

	//StudentID, lastName, firstName, major, credits, gpa
	stud = {
			{ 11234, "Delly", "Travis", "CS", 42, 3.9 },
			{ 11663, "Smith", "Bob", "App", 45, 3.4 },
			{ 11754, "Mell", "Shirly", "Psy", 70, 2.7 },
			{ 11655, "Snell", "Kiko", "Nurs", 45, 3.7 },
			{ 11546, "Pollack", "Niko", "Scie", 55, 4.0 }
	};
	/*create initial objects*/
	for (size_t i = 0; i < stud.size(); i++){
		bW.write(reinterpret_cast<char*> (&stud[i]), sizeof(Student));
	}

	bW.close();


}
Student newStudent(fstream& binaryFS){
	system("cls");
	Student holder;
	int ID;
	char name[20];
	char last[20];
	char Major[20];
	int credits;
	double gpa;


	cout << "Student Name: ";
	cin >> name;
	holder.setFirstName(name);

	cout << "Student ID: ";
	cin.ignore();
	cin >> ID;
	holder.setStudentID(ID);

	cout << "Student last Name: ";
	cin.ignore();
	cin >> last;
	holder.setLastName(last);

	cout << "Student major: ";
	cin.ignore();
	cin >> Major;
	holder.setMajorCode(Major);

	cout << "Student gpa: ";
	cin.ignore();
	cin >> gpa;
	holder.setGPA(gpa);

	cout << "Student credits: ";
	cin.ignore();
	cin >> credits;
	holder.setCredits(credits);





	binaryFS.open(FILE_NAME, ios::out | ios::binary | ios::app);
	binaryFS.write(reinterpret_cast<char*>(&holder), sizeof(Student));
	binaryFS.close();
	/*Append to file*/

	return holder;
}
void writeFile(fstream& binaryFS, vector<Student>& student){
	binaryFS.open(FILE_NAME, ios::out | ios::binary);

	for (size_t i = 0; i < student.size(); i++){
		binaryFS.write(reinterpret_cast<char*> (&student[i]), sizeof(Student));
	}

	binaryFS.close();
	/*Using a vector for my assigment so for loop makes this easiest*/
}/*Done*/
/*Extra Methods*/


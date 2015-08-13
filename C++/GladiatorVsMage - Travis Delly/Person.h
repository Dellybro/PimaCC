#ifndef _PERSON
#define _PERSON


#include <iostream>
#include <sstream>
#include <string>

using namespace std;

class Person {
private:
	string firstName;
	string origin;
	string ID;
public:
	bool alive = true;
	Person();
	Person(string, string, string);

	virtual string toString()=0;

	string getName() const;
	string getOrigin() const;
	string getID() const;

	void setID(string ID);
	void setName(string firstName);
	void setOrigin(string Origin);
};

#endif _PERSON
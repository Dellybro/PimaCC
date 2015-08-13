#include "Person.h"




Person::Person(){
	setName("N/A");
	setID("N/A");
	setOrigin("N/A");
}
Person::Person(string firstName, string origin, string ID){
	this->firstName = firstName;
	this->origin = origin;
	this->ID = ID;
}

string Person::toString(){
	stringstream strm;

	strm << "Name: " << getName()
		<< "\n Origin: " << getOrigin() <<
		"\n ID: " << getID();
	return strm.str();
}
void Person::setID(string ID){
	this->ID = ID;
}
void Person::setName(string firstName){
	this->firstName = firstName;
}
void Person::setOrigin(string lastName){
	this->origin = lastName;
}

string Person::getID() const{
	return this->ID;
}
string Person::getOrigin() const{
	return this->origin;
}
string Person::getName() const{
	return this->firstName;
}

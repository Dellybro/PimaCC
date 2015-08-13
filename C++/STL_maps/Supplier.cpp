#include "Supplier.h"


Supplier::Supplier(){
	setSupplierName(" ");
	setSupplierID(" ");
	setSupplierE(" ");
}
Supplier::Supplier(string e1, string e2, string e3){
	setSupplierName(e1);
	setSupplierID(e2);
	setSupplierE(e3);
}
void Supplier::setSupplierE(string newEmail){
	eMail = newEmail;
}
void Supplier::setSupplierName(string newName){
	supplierName = newName;
}
void Supplier::setSupplierID(string newID){
	supplierID = newID;
}

string Supplier::getSupplierE(){
	return eMail;
}
string Supplier::getSupplierName(){
	return supplierName;
}
string Supplier::getSupplierID(){
	return supplierID;
}
string Supplier::getListof(){
	string str = "";

	str = "Supplier Name: " + supplierName;
	str = str + "\n\t" "Supplier ID: " + supplierID;
	str = str + "\n\t" + "Supplier eMail: " + eMail;
	return str;
}

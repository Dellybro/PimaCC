/*
Assignment 8 
Programmer: Travis Delly

Purpose: Learning about STL maps

Date 2/21/2015

*/



#include <iostream>
#include <string>
#include <vector>
#include "StoreItem.h"
#include <iomanip>
#include <map>
#include <iterator>

using namespace std;

int Menu(){
	system("cls");
	cout << "========================\n";
	cout << "=1   Create new Item   =\n";
	cout << "=2   Current items     =\n";
	cout << "=3   Find item         =\n";
	cout << "=4   Exit              =\n";
	cout << "========================\n";
	cout << "\n\n Type a number: ";
	return 0;

	/*Menu reappears after each choice.*/

}

void createItem(map < string, StoreItem >& supplyMap){
	string name1;
	string desc;
	int ammount;
	double price;
	string sID;
	string sName;
	string eMail;
	string itemKey;

	StoreItem holder;

	/*Create holder variables*/

	cout << "Set new Item name: ";
	cin.ignore();
	getline(cin, name1);

	cout << "Set Item Key: ";
	cin >> itemKey;
	cin.ignore();

	cout << "Set new Item desc: ";
	getline(cin, desc);

	cout << "Set new Item price: ";
	cin >> price;

	cout << "Set new ammount: ";
	cin.ignore();
	cin >> ammount;

	cout << "Set supplier Name: ";
	cin.ignore();
	getline(cin, sName);

	cout << "Set supplier ID: ";
	getline(cin, sID);

	cout << "Set supplier eMail: ";
	getline(cin, eMail);

	/*I dislike cin....*/

	cout << "\n Saving new item.... " << endl;
	holder.setItemKey(itemKey);
	holder.setName(name1);
	holder.setDesc(desc);
	holder.setPrice(price);
	holder.setAmmount(ammount);
	holder.setSupplierE(eMail);
	holder.setSupplierID(sID);
	holder.setSupplierName(sName);
	/*Set methods*/

	supplyMap[holder.getItemKey()] = holder;

	supplyMap[holder.getItemKey()].toString();

	cout << "\n" << endl;

	system("pause");
}
void findItem(map < string, StoreItem > supplyMap){
	string itemKey;
	cout << "Item Key: ";
	cin >> itemKey;


	if (supplyMap[itemKey].getName() != "-"){
		cout << supplyMap[itemKey].toString();
	}
	else{
		cout << "\nSearch returned 0 results\n\n";
	}

	system("pause");
}
void showCurrent(map < string, StoreItem > supplyMap){
	/*Have to use an iterator to iterate through the Map, can also be used in a vector*/
	map<string, StoreItem>::const_iterator iterator;
	iterator = supplyMap.begin(); 
	cout << "\n\n---- List of Item with supplier ----\n\n";
	for (int i = 0; i < supplyMap.size(); i++){
		cout << "Key: " << iterator->first << "\nData: " << supplyMap[iterator->first].toString() << "\n";
		iterator++; 
	}

	system("pause");


	/*Shows all of the current */
}
void setMap(map < string, StoreItem >& supplyMap){
	StoreItem newItem;

	newItem.setAmmount(200);
	newItem.setDesc("Frozen Food");
	newItem.setName("AmorePizza");
	newItem.setPrice(4.75);
	newItem.setSupplierE("Amore@gmail.com");
	newItem.setSupplierID("Amore6589");
	newItem.setSupplierName("Ken Amore");
	newItem.setItemKey("Amore123");

	supplyMap[newItem.getItemKey()] = newItem;

	newItem.setAmmount(100);
	newItem.setDesc("Food-Snacks");
	newItem.setName("Slim Jims");
	newItem.setPrice(1.75);
	newItem.setSupplierE("JimmySlim@gmail.com");
	newItem.setSupplierID("Slim7789");
	newItem.setSupplierName("Jim Slim");
	newItem.setItemKey("SlimJims234");

	supplyMap[newItem.getItemKey()] = newItem;

	newItem.setAmmount(300);
	newItem.setDesc("Food-Snacks");
	newItem.setName("Twinkie");
	newItem.setPrice(1.50);
	newItem.setSupplierE("Hostess@gmail.com");
	newItem.setSupplierID("Twinks7789");
	newItem.setSupplierName("Hostess");
	newItem.setItemKey("Twinkies432");
	
	supplyMap[newItem.getItemKey()] = newItem;

	/*Sets the 2nd place in the vector*/
}
int main(){
	bool program = true;
	map < string, StoreItem > supplyMap;
	setMap(supplyMap);

	while (program){
		Menu();
		char input;
		cin >> input;

		switch (input){
		case '1':
			system("cls");
			createItem(supplyMap);
			break;
		case '2':
			system("cls");
			showCurrent(supplyMap);
			break;
		case '3':
			system("cls");
			findItem(supplyMap);
			break;
		case '4':
			program = false;
			break;

		}
	}
	/*Get values*/
	/*Set methods*/

	char f = getchar();

	return 0;
}
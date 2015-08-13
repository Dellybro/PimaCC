/*

Travis Delly
Feb 4, 2015
CIS 278 module 4
Programming Assignment 4
Purpose: Create items and a supplier for inventory purposes


*/



#include <iostream>
#include <string>
#include <vector>
#include "Header.h"
#include <conio.h>

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

void createItem(vector<StoreItem>& Item0){
	string name1;
	string desc;
	int ammount;
	long itemNum;
	double price;
	string supplier;

	StoreItem holder;

	/*Create holder variables*/

	cout << "Set new Item name: ";
	cin.ignore();
	getline(cin, name1);

	cout << "Set new Item number: ";
	cin >> itemNum;

	cout << "Set new Item desc: ";
	cin.ignore();
	getline(cin, desc);

	cout << "Set new Item price: ";
	cin >> price;

	cout << "Set new ammount: ";
	cin.ignore();
	cin >> ammount;

	cout << "Set supplier: ";
	cin.ignore();
	getline(cin, supplier);

	/*I dislike cin....*/
	
	cout << "\n Saving new item.... " << endl;
	holder.setName(name1);
	holder.setItemNumber(itemNum);
	holder.setDesc(desc);
	holder.setPrice(price);
	holder.setAmmount(ammount);
	holder.setSupplier(supplier);
	/*Set methods*/

	Item0.push_back(holder);

	Item0[Item0.size()-1].toString();

	cout << "\n" << endl;

	system("PAUSE");
}
void findItem(vector<StoreItem>& item){

	cout << "What is the name of of item?" << endl;


	string itemName;
	cin >> itemName;


	for (size_t i = 0; i < item.size(); i++)
	{
		string name2 = item[i].getName();
		if (name2.compare(itemName) == 0){
			cout << item[i].toString();
		}

	}
	system("PAUSE");
}
void showCurrent(vector<StoreItem>& item){
	for (size_t i = 0; i < item.size(); i++){
		cout << item[i].toString();
	}
	system("PAUSE");
	/*Shows all of the current */
}
void setArray(vector<StoreItem>& item){
	item[1].setAmmount(100);
	item[1].setDesc("Frozen Food");
	item[1].setItemNumber(5510);
	item[1].setName("AmorePizza");
	item[1].setSupplier("Pizza Suppliers Inc.");
	item[1].setPrice(4.75);

	/*Sets the 2nd place in the vector*/
}
int main(){
	bool program = true;
	vector<StoreItem> Item0{ { "SlimJims", 5505, "Food-Snacks", 1.25, 1500, "Jimmy Slim" }, {} };
	setArray(Item0);



	while (program){
		Menu();
		char input;
		cin >> input;

		switch (input){
		case '1':
			system("cls");
			createItem(Item0);
			break;
		case '2':
			system("cls");
			showCurrent(Item0);
			break;
		case '3':
			system("cls");
			findItem(Item0);
			break;
		case '4':
			program = false;
			break;

		}
	}
	/*Get values*/
	/*Set methods*/

	system("PAUSE");

	return 0;
}

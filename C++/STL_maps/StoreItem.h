#ifndef __SUPPLIER
#define __SUPPLIER

#include <iostream>
#include <string>
#include "Supplier.h"
#include <vector>

using namespace std;

class StoreItem{
public:


	double getPrice();
	int getAmmount();
	string getDesc();
	string getName();
	/*Get methods*/

	void setDesc(string Desc);
	void setName(string name);
	void setPrice(double price);
	void setAmmount(int ammount);
	void setItemKey(string itemKey);
	/*set Methods*/

	/*Supplier object*/
	void setSupplierID(string supplierID);
	string getSupplierID();
	string getItemKey();

	void setSupplierName(string supplierName);
	string getSupplierName();

	void setSupplierE(string eMail);
	string getSupplierE();
	/*End object*/

	string toString();

	StoreItem();
	StoreItem(string, string, double, int, string);

private:
	string itemKey;
	Supplier supplyList;
	string name;
	string description;
	double sellingPrice;
	int ammount;


};
#endif

//Supplier

#include <iostream>
#include <string>

using namespace std;

class Supplier
{
public:

	Supplier();
	Supplier(string, string, string);

	void setSupplierID(string supplierID);
	string getSupplierID();

	void setSupplierName(string supplierName);
	string getSupplierName();

	void setSupplierE(string eMail);
	string getSupplierE();

	string getListof();

	

private:
	string supplierID;
	string supplierName;
	string eMail;
};

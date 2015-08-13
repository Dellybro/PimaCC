#include <iostream>
#include <string>

using namespace std;

class StoreItem{
	public:
		

		//Using return statements so this wa 
		double getPrice();
		int getAmmount();
		long getItemNumber();
		string getDesc();
		string getName();
		string getSupplier();


		//set methods are all void members of the public class
		void setItemNumber(long newNumb);
		void setDesc(string Desc);
		void setName(string name);
		void setPrice(double price);
		void setAmmount(int ammount);
		void setSupplier(string supplier);

		string toString();

		StoreItem(void);
		StoreItem(string, long, string, double, int, string);

		/*public methods*/
	private:	
		string name;
		string description;
		string supplier;
		double sellingPrice;
		int ammount;
		long itemNumber;
		/*PrivateVariables*/


};







#include "StoreItem.h"
#include <iomanip>
#include <sstream>
/*Start Constructor*/
StoreItem::StoreItem(){
	setName("-");
	setDesc("-");
	setPrice(0);
	setAmmount(0);
	setItemKey("-");
}
StoreItem::StoreItem(string name1, string desc1, double sellingPrice1, int ammount1, string itemKey){
	setName(name1);
	setDesc(desc1);
	setPrice( sellingPrice1);
	setAmmount(ammount1);
	setItemKey(itemKey);
}
/*end constructor Start Destructor*/




/*Start Class methods*/
string StoreItem::toString(){

	stringstream strm;

	strm << "Item Name: " << name <<
	 "\n\tItem Desc: " << getDesc() <<
	 "\n\tItem Price: $" << setprecision(2) << fixed << (sellingPrice)
	<< "\n\tAmmount in stock: " << (ammount) << "\n\n"
	<< supplyList.getListof() << "\n_________________________\n";

	return strm.str();

}
void StoreItem::setItemKey(string itemKey){
	this->itemKey = itemKey;
}
string StoreItem::getItemKey(){
	return itemKey;
}

void StoreItem::setDesc(string newDesc){
	description = newDesc;
}
void StoreItem::setName(string newName){
	name = newName;
}
void StoreItem::setAmmount(int newAmmount){
	ammount = newAmmount;
}
void StoreItem::setPrice(double newPrice){
	sellingPrice = newPrice;
}

/*end set methods start Get methods*/

string StoreItem::getName(){
	return name;
}
double StoreItem::getPrice(){
	return sellingPrice;
}
string StoreItem::getDesc(){
	return description;
}
int StoreItem::getAmmount(){
	return ammount;
}
/*End get methods*/

/*End Class methods*/

/*New Supplier classObject*/
void StoreItem::setSupplierE(string newEmail){
	this->supplyList.setSupplierE(newEmail);
}
void StoreItem::setSupplierName(string newName){
	this->supplyList.setSupplierName(newName);
}
void StoreItem::setSupplierID(string newID){
	this->supplyList.setSupplierID(newID);
}

string StoreItem::getSupplierE(){
	return this->supplyList.getSupplierE();
}
string StoreItem::getSupplierName(){
	return this->supplyList.getSupplierName();
}
string StoreItem::getSupplierID(){
	return this->supplyList.getSupplierID();
}
/*This acts as a pointer to the supplyList class. Built in pointer.*/
#include "Header.h"

/*Start Class*/
StoreItem::StoreItem(void){
	itemNumber = 0;
	name = "";
	description = "";
	sellingPrice = 0;
	ammount = 0;
	supplier = "";
}
StoreItem::StoreItem(string name1, long item, string desc1, double sellingPrice1, int ammount1, string supplier1){
	itemNumber = item;
	name = name1;
	description = desc1;
	sellingPrice = sellingPrice1;
	ammount = ammount1;
	supplier = supplier1;
}
void StoreItem::setSupplier(string newSupplier){
	supplier = newSupplier;
}
string StoreItem::toString(){
	string supplier1 = "Item Name: " + name;
	supplier1 = supplier1 + "\n\tItem Number: " + to_string(itemNumber);
	supplier1 = supplier1 + "\n\tItem Desc: " + description;
	supplier1 = supplier1 + "\n\tItem Price: " + to_string(sellingPrice);
	supplier1 = supplier1 + "\n\tAmmount in stock: " + to_string(ammount) + "\n";
	supplier1 = supplier1 + "\n\tSupplier: " + supplier;
	supplier1 = supplier1 + "\n_________________________\n";
	
	return supplier1;
}
void StoreItem::setDesc(string newDesc){
	description = newDesc;
}
void StoreItem::setItemNumber(long newNumb){
	itemNumber = newNumb;
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


string StoreItem::getName(){
	return name;
}
string StoreItem::getSupplier(){
	return supplier;
}
double StoreItem::getPrice(){
	return sellingPrice;
}
string StoreItem::getDesc(){
	return description;
}
long StoreItem::getItemNumber(){
	return itemNumber;
}
int StoreItem::getAmmount(){
	return ammount;
}

/*end Class*/
#include "Tomes.h"
#include <sstream>

Tomes::Tomes(){
	setStr(5);
	setIntel(5);
	setMana(5);
	setArm(5);
}
Tomes::Tomes(int str, int intel, int arm, int mana){
	setStr(str);
	setIntel(intel);
	setArm(arm);
	setMana(mana);
}
string Tomes::desc(){
	stringstream strm;

	strm << "Tome: ";

	return strm.str();

}
int Tomes::getStr() const{
	return this->strength;
	
}
int Tomes::getMana() const{
	return this->Mana;
}
int Tomes::getIntel() const{
	return this->intelligence;
}
int Tomes::getArm() const{
	return this->Armor;
}
void Tomes::setStr(int str){
	this->strength = str;
}
void Tomes::setMana(int mana){
	this->Mana = mana;
}
void Tomes::setIntel(int intel){
	this->intelligence = intel;
}
void Tomes::setArm(int Arm){
	this->Armor = Arm;
}
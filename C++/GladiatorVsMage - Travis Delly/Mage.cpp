#include "Mage.h"

using namespace std;

Mage::Mage(const Mage& obj, int mana, int intel, int arm){
	this->setOrigin(obj.getOrigin());
	this->setName(obj.getName());
	this->setID(obj.getID());
	this->setMana(mana);
	this->setIntel(intel);
	this->setArm(arm);
}
Mage::Mage(string Name, string Last, string ID, int Mana, int intelligence, int armor) : Person(Name, Last, ID){/*The parameter Person is calling the Constructor Person and filling in with given variables*/

	setMana(Mana);
	setIntel(intelligence);
	setArm(armor);
}

/*Getter*/
int Mage::getMana() const{
	return this->mana;
}
int Mage::getIntel() const{
	return this->intelligence;
}
int Mage::getArmor() const{
	return this->armor;

}
/*Setter*/
void Mage::setMana(int mana) {
	this->mana = mana;
}
void Mage::setIntel(int intel){
	this->intelligence = intel;

}
void Mage::setArm(int Arm){
	this->armor = Arm;

}
/*Derived from Person class using virtaul*/
string Mage::toString(){
	stringstream strm;

	strm << "\nMana: " << mana
		<< "\n Intelligence " << intelligence
		<< "\n Armor: " << armor;

	return Person::toString() + strm.str();

}
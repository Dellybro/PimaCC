#include "Gladiator.h"
#include "Mage.h"

using namespace std;



Gladiator::Gladiator(const Gladiator& obj, int str, int intel, int armor){
	this->setStr(str);
	this->setIntel(intel);
	this->setArm(armor);
	this->setOrigin(obj.getOrigin());
	this->setName(obj.getName());
	this->setID(obj.getID());

}
Gladiator::Gladiator(string name, string last, string id, int str, int intel, int arm) : Person(name, last, id){/*Person is derived from the class and the paramaters take in the Gladiators given paramaters and make them there own*/
	setStr(str);
	setIntel(intel);
	setArm(arm);

}

/*getter*/
int Gladiator::getStr() const{
	return this->strength;
}
int Gladiator::getIntel() const{
	return this->intelligence;
}
int Gladiator::getArmor() const{
	return this->armor;
}
/*Setter*/
void Gladiator::setStr(int str){
	this->strength = str;

}
void Gladiator::setIntel(int intel){
	this->intelligence = intel;
}
void Gladiator::setArm(int Arm){
	this->armor = Arm;
}

/*derived from the virtual string in person*/
string Gladiator::toString(){
	stringstream strm;

	strm << "\nStrength: " << strength
		<< "\n Intelligence " << intelligence
		<< "\n Armor: " << armor;

	return Person::toString() + strm.str();
}
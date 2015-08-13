#include "tomeOfBrutality.h"
#include <sstream>


tomeOfBrutality::tomeOfBrutality(){
	setArm(21);
	setIntel(28);
	setStr(31);
}

string tomeOfBrutality::desc(){
	stringstream strm;

	strm << "Tome of Brutality (" << getArm() << ", " << getStr() << ", " << getIntel() << ")\n"
		<< "Found on a road far from humanity this tome provides " << getArm() << " Armor" << "\n It also witholds " << getStr() << " Strength\n"
		<< "This book gains insight of your opponent granting " << getIntel() << " Intelligence"<< endl;

	return Tomes::desc() + strm.str();
}
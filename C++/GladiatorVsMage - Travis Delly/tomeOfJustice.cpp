#include "tomeOfJustice.h"
#include <sstream>


tomeOfJustice::tomeOfJustice(){
	setArm(22);
	setIntel(27);
	setMana(32);
}

string tomeOfJustice::desc(){
	stringstream strm;

	strm << "Tome of Justice (" << getArm() << ", " << getMana() << ", " << getIntel() << ")\n"
		<< "Forged from the brains politicians this tome provides " << getArm() << " Armor" << " \nIt also holds the power of jurisdiction gaining " << getMana() << " Mana\n"
		<< "And of the willingness of the court granting " << getIntel() << " Intelligence" << endl;

	return Tomes::desc() + strm.str();
}
#include "tomeOfKnowledge.h"
#include <sstream>


tomeOfKnowledge::tomeOfKnowledge(){
	setArm(20);
	setIntel(30);
	setMana(30);
}

string tomeOfKnowledge::desc(){
	stringstream strm;

	strm << "Tome of Knowledge (" << getArm() << ", " << getMana() << ", " << getIntel() << ")\n"
		<< "\n" << "Forged from the brains of humanity, this Tome provides " << getArm() << " Armor" << " It also holds the power of sight granting " << getMana() << " Mana\n"
		<< "Of course with such knowledge gains intelligence of " << getIntel() << endl;

	return Tomes::desc() + strm.str();
}

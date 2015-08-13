#include "tomeOfDividance.h"
#include <sstream>


tomeOfDividance::tomeOfDividance(){
	setArm(30);
	setIntel(25);
	setStr(20);
}

string tomeOfDividance::desc(){
	stringstream strm;

	strm << "Tome of Dividance (" << getArm() << ", " << getStr() << ", " << getIntel() << ")\n"
		<< "Forged from the Heavens, this Tome provides " << getArm() << " Armor with 0 chance of resistance" << " It also holds the power of " << getStr() << " strength\n"
		<< "But what would this tome be without the intelligence of the gods granting " << getIntel() << "intelligence for the user";

	return Tomes::desc() + strm.str();
}





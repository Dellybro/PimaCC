#ifndef _TOMES
#define _TOMES

#include <iostream>
#include <string>


using namespace std;

class Tomes {
private:

	int strength;
	int Mana;
	int intelligence;
	int Armor;
public:

	Tomes();
	Tomes(int, int, int, int);

	int getStr()const;
	int getMana()const;
	int getIntel()const;
	int getArm()const;

	void setStr(int str);
	void setMana(int mana);
	void setIntel(int intel);
	void setArm(int Arm);

	virtual string desc() = 0;

};

#endif
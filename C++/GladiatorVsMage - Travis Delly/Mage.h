#ifndef _MAGE
#define _MAGE

#include "Person.h"
#include <cstdlib>
#include <string>
#include <iostream>

using namespace std;

class Mage : public Person{
public:
	Mage(const Mage&, int, int, int);
	Mage(string Name, string Last, string ID, int strength, int intelligence, int armor);

	int getMana() const;
	int getIntel() const;
	int getArmor() const;

	void setMana(int str);
	void setIntel(int intel);
	void setArm(int Arm);

	virtual string toString();
private:
	int mana;
	int intelligence;
	int armor;


};
#endif
#ifndef _GLADIATOR
#define _GLADIATOR

#include "Person.h"
#include <iostream>
#include <cstdlib>
#include <string>

using namespace std;

class Gladiator : public Person{
public:
	Gladiator(const Gladiator&, int, int, int);
	Gladiator(string Name, string Last, string ID, int strength, int intelligence, int armor);

	int getMAXHP() const;
	int getStr() const;
	int getIntel() const;
	int getArmor() const;

	void setStr(int str);
	void setIntel(int intel);
	void setArm(int Arm);

	virtual string toString();
private:
	int strength;
	int intelligence;
	int armor;

};
#endif
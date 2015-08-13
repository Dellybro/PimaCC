/*
Travis Delly
Feb 20, 2015
CIS 278 module 7
Programming Assignment 7
Point of Assignment: Learning classes Derived classes, polymorphism and inheritance

*/


#include "Person.h"
#include "Gladiator.h"
#include "Mage.h"
#include <iostream>
#include <string>
#include <vector>
#include "Tomes.h"
#include "tomeOfDividance.h"
#include "tomeOfBrutality.h"
#include "tomeOfJustice.h"
#include "tomeOfKnowledge.h"

using namespace std;

template < typename T >
void displayGenericVector(vector<T*>&); // The parameter is a reference to a vector of pointers to type T, whatever it happens to be.


void createTomes(vector<Tomes*>& tomes){
	tomeOfDividance tomeOfDiv;
	tomeOfBrutality tomeOfBrut;
	tomeOfJustice tomeOfJust;
	tomeOfKnowledge tomeOfKnow;

	tomeOfDividance* tomeOfDivPtr = new tomeOfDividance(tomeOfDiv);
	tomeOfBrutality* tomeOfBrutPtr = new tomeOfBrutality(tomeOfBrut);
	tomeOfJustice* tomeOfJustPtr = new tomeOfJustice(tomeOfJust);
	tomeOfKnowledge* tomeOfKnowPtr = new tomeOfKnowledge(tomeOfKnow);

	tomes.push_back(tomeOfDivPtr);
	tomes.push_back(tomeOfBrutPtr);
	tomes.push_back(tomeOfJustPtr);
	tomes.push_back(tomeOfKnowPtr);



}
void createFighters(vector<Person*>& Fighters, vector<Tomes*> tomes){

}
int main(){

	Gladiator Spartacus("Spartacus", "Greece", "4DE", 6, 7, 5);
	Mage Lionus("Lionus", "France", "5DG", 6, 5, 7);

	vector<Person*> Fighters;
	vector<Tomes*> tomes;
	createTomes(tomes);

	/*Spartacus Tome choice*/
	cout << "Chose Spartacus' Tome (1 or 2)\n\n";
	cout << "1. " << tomes[0]->desc() << endl << endl;
	cout << "2. " << tomes[1]->desc() << endl << endl;
	int choice = 0;
	cin >> choice;
	Spartacus.setArm(tomes[choice-1]->getArm()+Spartacus.getArmor());
	Spartacus.setStr(tomes[choice - 1]->getStr() + Spartacus.getStr());
	Spartacus.setIntel(tomes[choice - 1]->getIntel() + Spartacus.getIntel());
	/*Lionus Tome Choice*/
	system("pause");
	system("cls");
	cout << "Chose Lionus' Tome (1 or 2)\n\n";
	cout << "1. " << tomes[2]->desc() << endl << endl;
	cout << "2. " << tomes[3]->desc() << endl << endl;
	int choice2 = 0;
	cin.ignore();
	cin >> choice2;
	Lionus.setArm(tomes[choice2 + 1]->getArm() + Lionus.getArmor());
	Lionus.setMana(tomes[choice2 + 1]->getMana() + Lionus.getMana());
	Lionus.setIntel(tomes[choice2 + 1]->getIntel() + Lionus.getIntel());
	system("pause");




	Gladiator* SpartacusPtr = new Gladiator(Spartacus);
	Mage* LionusPtr = new Mage(Lionus);
	Fighters.push_back(SpartacusPtr);
	Fighters.push_back(LionusPtr);


	system("cls");

	cout << "----- Fighter Cards -----\n";
	displayGenericVector(Fighters);
	cout << "\nLet the battle BEGIN!\n <Press Enter>\n";

	cin.ignore();
	char m = getchar();






	/*Fight*/
	int hp0 = (Spartacus.getArmor() *2) * Spartacus.getStr();
	int hp1 = (Lionus.getArmor() *2) * Lionus.getMana();

	while (Lionus.alive && Spartacus.alive){
		if (hp0 < 0){
			Spartacus.alive = false;
			cout << "\n\nLionus Wins!";
		}
		if (Spartacus.alive && Lionus.alive){
			hp1 = hp1 + Lionus.getArmor() - Spartacus.getStr()*Spartacus.getIntel();
			if (hp1 < 0){
				cout << "\n\nSpartacus throws a swing!\nLionus Falls";
			}
			else{
				cout << "Spartacus takes Swing!" << "\nLionus remains with " << hp1 << "hp left!" << endl;
			}
		}
		if (hp1 < 0){
			Lionus.alive = false;
			cout << "\n\nSpartucus Wins!";
		}
		if (Spartacus.alive && Lionus.alive){
			hp0 = hp0 + Spartacus.getArmor() - Lionus.getMana()*Lionus.getIntel();
			if (hp0 < 0){
				cout << "\nLionus throws a spell!\nSparatcus Falls";
			}
			else{
				cout << "Lionus throws a spell!" << "\nSpartacus remains with " << hp0 << "hp left!" << endl;
			}
		}
	}

	cout << "\n\n";
	system("pause");


	return 0;
}



/*Copied from Fred*/
template < typename T >
void displayGenericVector(vector<T*>& fighters) // The parameter is a reference to a vector of pointers to type T, whatever it happens to be.
{
	// The only way I have ever made accessing derived classes within a vector of the base class work
	// is to use iterators.

	vector<T*>::iterator cards = fighters.begin(); // iterator to vector of pointers to Employee
	vector<T*>::iterator cardsEnd = fighters.end(); // end iterator for a vector of pointers to Employee

	while (cards != cardsEnd)
	{
		cout << "\n" << (*cards)->toString() << "\n-------------------------------\n" << endl;

		cards++; // increment the iterator
	}
}
/*Credits to Fred my Professor*/
/*Using a template seems easier and simplier to me with pointers*/
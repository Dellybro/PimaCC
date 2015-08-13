/*
	Program: calcPay
	Purpose: In order to calculate monthly interest for clients 101-104
	Developer: Travis Delly
	Created: 1/22/2015
	Updates: Forgot to include getValues; now my main is cleaner;

*/
#include <iostream> //For system
#include <conio.h> // For _getch(); 
#include <cmath> //For math.pow

using namespace std;
const int ROW = 4;
const int COLUMN = 5;

void getInput(double accountInfo[ROW][COLUMN]){

	double holderVar[ROW][COLUMN] = {
			{ 101, 95000, 15, .06875, 0.0 },
			{ 102, 100000, 30, .055, 0.0 },
			{ 103, 125000, 30, .045, 0.0 },
			{ 104, 150000, 30, .0475, 0.0 } }; /*Create a holderVar with numbers hardCoded*/
	for (size_t i = 0; i < ROW; i++)
		for (size_t j = 0; j < COLUMN; j++)
			accountInfo[i][j] = (double)holderVar[i][j];
	/* Use a double for loop to input information into a 2d array*/
}
double calcPayment(double loaned, double years, double rate){
	double rateHolder = (rate / 12);
	double termInMonths = (years * 12);
	/*amount loaned / ((1 - (1 / (monthly rate + 1)^termInMonths)) / monthly rate).*/
	double monthlyPayment = pow(rateHolder + 1, termInMonths); //(monthly rate + 1)^yearHolder)
	monthlyPayment = loaned/((1-(1 / monthlyPayment)) / rateHolder); //Finish the statement with Pow used
	return monthlyPayment;
}
void getValues(const double accountInfo[ROW][COLUMN]){
	int count = 0;
	cout << "Account | Loaned | Years |   Rate   | MonthlyPay" << endl;
	for (int R = 0; R < ROW; R++){
		for (int C = 0; C < COLUMN; C++){
			count++;
			cout << accountInfo[R][C];
			cout << "      ";
			if (count == 5){ cout << endl; count = 0; }

		}
	}/*Last run through the array to print the graph*/

}
int main(){

	double accountInfo[ROW][COLUMN] = {};
	getInput(accountInfo);
	getValues(accountInfo);
	cout << "This is the initial Graph, to see monthly payments press anything";
	_getch(); /* _getch() apparently is used in visual studios but getch() is used in normal compilers?*/
	system("cls"); /*Clearing console*/
	for (size_t i = 0; i < 4; i++)
	{
		accountInfo[i][4] = calcPayment(accountInfo[i][1], accountInfo[i][2], accountInfo[i][3]);
		cout << "This first account number is: " << accountInfo[i][0] << endl;
		cout << "The total monthlyRate is: ";
		printf("%4.2f\n", accountInfo[i][4]);
	}/*Running through the Array using calcPayment to get Interest*/
	_getch();
	system("cls");
	cout << "Final Graph\n\n";
	getValues(accountInfo);
	cout << "\n\nProject 1 completed!";
	_getch();

	return 0;/*Return 0 because main is Int.*/
}
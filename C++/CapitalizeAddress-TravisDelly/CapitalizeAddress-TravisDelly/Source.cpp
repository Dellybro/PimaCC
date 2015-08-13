/*
Program: Capitalize Address
Purpose: Capitalize first letter and state of addressLine
Developer: Travis Delly
Created: 1/28/2015

*/

#include <string> /*used for string*/
#include <iostream> /*used for IO*/
#include <fstream> /*used for stream*/
#include <vector> /*Used for vector*/
#include <iomanip> /*used for IO*/


using namespace std;
const char ADDRESS_FILE[] = "C:\\Users\\Rig\\Desktop\\C++\\pcc_campuses.txt\0";
const char OUT_ADDRESS[] = "C:\\Users\\Rig\\Desktop\\C++\\revisized_pcc_campuses.txt\0";
/*Input files here, in future projects i'm guessing we will have to
let users chose their own file names?*/
void getAddress(vector< vector<string> > &address)
{
	ifstream getFile;
	getFile.open(ADDRESS_FILE);
	char symbol = ' ';
	/*symbol has to be a char in order to read in \n*/
	int count = 0;
	/*Used to figure out where dimensions stop*/

	if (!getFile.good())
	{
		cout << "\n\nCould not access " << ADDRESS_FILE << "n\n";
		cout << "Try again with another file\n. Exiting program\n\n";
		printf("\n\n Press any key to continue");
		cin.get();

		exit(EXIT_FAILURE);
	}/*Making sure there is an exit protocol incase of file failure*/
	while (!getFile.eof()){
		getFile.get(symbol);
		if (symbol != '\n'){ /*correctly reads end of line*/
			address[count][0] = address[count][0] + symbol;
		}
		else if (count != address.size() - 1)
			count++;
		/*Size of first dimension - 1 this makes it so it can work on more dimesions than just 6!*/

	}
	getFile.close();

}
void revisedText(vector< vector<string> > address){
	ofstream outStream;
	outStream.open(OUT_ADDRESS);
	if (!outStream.good())
	{
		cout << "\n\nCould not access " << ADDRESS_FILE << "n\n";
		cout << "Try again with another file\n. Exiting program\n\n";
		printf("\n\n Press any key to continue");
		cin.get();

		exit(EXIT_FAILURE);
	}/*Making sure there is an exit protocol incase of file failure*/

	for (size_t i = 0; i < address.size() - 1; i++){
		outStream << address[i][0] + '\n';
	}


}
void showAddress(vector< vector<string> > address){
	for (size_t i = 0; i < address.size(); i++){
		cout << address[i][0] << endl;
	}
}
string capitalizeWords(string& address){
	int count = 0;
	for (size_t i = 0; i < address.length() - 2; i++)
	{
		if (address[i] == ','){
			count++;
			if (count == 2){
				address[i + 2] = toupper(address[i + 2]);
				address[i + 3] = toupper(address[i + 3]);
				count = 0;
			}
			/*So reading the instructions is says "It may make sense to check for
			2 letters following a comma" but one of the inputs is rd without a comma
			so i figured, after 2 commas, because all the address', i would just
			edit the next set of first 2 values*/
		}
		else if (address[i] == ' '){
			address[i + 1] = toupper(address[i + 1]);
		}
	}
	return address;
}
int main()
{

	vector< vector<string> > campusAddress(6, vector<string>(1));


	getAddress(campusAddress);
	for (size_t i = 0; i < campusAddress.size(); i++)
	{
		campusAddress[i][0] = capitalizeWords(campusAddress[i][0]);
	}
	showAddress(campusAddress);
	revisedText(campusAddress);

	cin.get();
	return 0;
}
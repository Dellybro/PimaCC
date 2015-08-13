/*
** Program    : UtilityFunctions.h
**
** Purpose    : Declare UtilityFunctions class and define methods for providing functions to do common work.
**
** Programmer : F. D'Angelo
**
*/

#ifndef _UTILITY_FUNCTIONS
#define _UTILITY_FUNCTIONS

#include <string>
#include <sstream>

using namespace std ;

class UtilityFunctions
{
public:
    template<typename T>
    static string convertToString( T valueToConvert )
    {
        stringstream sstream ;
        sstream << valueToConvert ;
        return sstream.str();
    }
};


#endif
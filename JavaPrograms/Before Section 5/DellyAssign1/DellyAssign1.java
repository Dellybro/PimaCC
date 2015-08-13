/* 
Travis Delly
January 20, 2015
CIS 279 module 1
Programming Assignment 1.1
Textbook Programming Exercises 1.4 - 1.7
Display the results of a series of mathematical calculations: 
1.4) A table showing numbers with their squares and cubes
1.5) The result of the arithmetic expression (9.5 * 4.5 - 2.5 * 3) / (45.5 - 3.5) 
1.6) Summation of the integers 1 through 9
1.7) Approximation of pi by two series
These are each implemented in the main() method of this class.  
*/

class arithmetic {
  public static void main(String[] arguments) {
	System.out.println("Num | Square | Cube");
    for(int i = 0; i <= 4; i++){
		System.out.println(i + "  " + (i*i) + "  " + i*i*i);
	}
	
	System.out.println("Table Consists of numbers 1-4 as shown in example");
	System.out.println("Result of arithmetic Expression...");
	System.out.println((double) (9.5 * 4.5 - 2.5 * 3) / (45.5 - 3.5));
	System.out.println("Result of summation...");
	System.out.println((int)(1+2+3+4+5+6+7+8+9));
	/*For loop could of easily solved this problem adding the last counter to itself until <= 9 */
	System.out.println("Result of question <1.7>...");
	double numerator = 1;
	double denom = 1;
	double startPoint = 1;
	for(int i = 3; i < 13; i = i + 2){
			numerator = numerator*-1;
			denom = denom + 2;
			startPoint = startPoint + numerator/denom;
		}
	System.out.println(startPoint*4);
	/*Using a for loop makes me feel more comfortable*/
  }
}
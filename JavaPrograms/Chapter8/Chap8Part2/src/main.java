/*
Developper - Travis Delly
Assignment 8.2
March/19/2015
Purpose - Inheritance Cloneable


*/
public class main {
	public static Utilites myUtils = new Utilites();
	public static void main(String[] args) {
		System.out.println("Complex Number1: ");
		Complex number1 = new Complex(myUtils.strInput("number"), myUtils.strInput("number") );
		System.out.println("Complex Number2: ");
		Complex number2 = new Complex(myUtils.strInput("number"), myUtils.strInput("number") );
		number1.run(number2);
		
		System.out.println(number1.abs());
		
		
		

	}

}

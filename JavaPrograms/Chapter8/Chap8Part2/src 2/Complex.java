/*
Developper - Travis Delly
Assignment 8.2
March/19/2015
Purpose - Inheritance Cloneable


*/
public class Complex implements Cloneable{
	private double a;
	private double b;
	
	public double real;
	public double imaginary;
	
	
	public Complex(){
		a = 0;
		b = 0;
	}
	public Complex(double a){
		this.a = a;
		b = 0;
	}
	public Complex(double a, double b) {
		this.a = a;
		this.b = b;
	}


	//Setters//Getters
	public double getRealPart() {
		return a;
	}
	public void setRealPart(int a) {
		this.a = a;
	}
	public double getImaginaryPart() {
		return b;
	}
	public void setImaginaryPart(int b) {
		this.b = b;
	}
	
	
	public void run(Complex other){
		add(other);
		subtract(other);
		multiply(other);
		divide(other);
	}
	
	public String abs(){
		double result = Math.sqrt(Math.pow(getRealPart(), 2) + Math.pow(getImaginaryPart(), 2)); 
		
		String abs = "|" + getRealPart() + " + " + getImaginaryPart() + "i| = " + result;
		return abs;
	}
	public void add(Complex other){
		real = (getRealPart()+other.getRealPart());
		imaginary = (getImaginaryPart()+other.getImaginaryPart());
		System.out.println(toString(other, " + "));
	}
	public void subtract(Complex other){
		real = (getRealPart()-other.getRealPart());
		imaginary = (getImaginaryPart()-other.getImaginaryPart());
		System.out.println(toString(other, " - "));
	}
	public void multiply(Complex other){
		real = (getRealPart()*other.getRealPart())-(getImaginaryPart()*other.getImaginaryPart());
		imaginary = (getImaginaryPart()*other.getRealPart() + getRealPart()*other.getImaginaryPart());
		System.out.println(toString(other, " * "));
	}
	public void divide(Complex other){
		real = ((getRealPart()*other.getRealPart())+(getImaginaryPart()*other.getImaginaryPart()))/((Math.pow(other.getRealPart(),2) + Math.pow(other.getImaginaryPart(),2)));
		imaginary = ((getImaginaryPart()*other.getRealPart())+(getRealPart()*other.getImaginaryPart()))/((Math.pow(other.getRealPart(),2) + Math.pow(other.getImaginaryPart(),2)));
		System.out.println(toString(other, " / "));
	}
	
	
	public String toString(Complex other, String operator){
		String math = "("+getRealPart()+ " + " +getImaginaryPart()+"i)" + operator+ "("+other.getRealPart()+" + " + other.getImaginaryPart() + "i) = ";

		if(imaginary != 0.0){
			math = math + real + " + " + imaginary +"i";
		} else {
			math = math + real;
		}
		
		return math;
	}



	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}

}

/*
 * 	Programmer: TravisDelly
 *  Date: March 19th, 2015
 *  PointofProgram -> Learn loads about inheritance and polymorphism
 *  Assignment: 8.1
 */
public class Circle extends GeometricObject {
	
	private int Radius;
	
	protected Circle() {
		super();
		Radius = 0;
		// TODO Auto-generated constructor stub
	}

	protected Circle(String color, boolean filled, int Radius) {
		super(color, filled);
		// TODO Auto-generated constructor stub
		this.Radius = Radius;
	}
	
	public void setRadius(int Radius){
		this.Radius = Radius;
	}
	public double getRadius(){
		return this.Radius;
	}
	
	@Override
	public String toString(){
		return super.toString() + "\nRadius: " + this.Radius;
	}

	//Override SuperClass...
	@Override
	public double getArea() {
		return 2 * Radius;
	}

	@Override
	public double getPerimeter() {
		return 2 * Radius * Math.PI;
	}

	@Override
	public int compareTo(GeometricObject o) {
		if(getRadius() > ((Circle) o).getRadius()){
			return 1;
		}
		else{
			return 0;
		}
	}
	
	
}

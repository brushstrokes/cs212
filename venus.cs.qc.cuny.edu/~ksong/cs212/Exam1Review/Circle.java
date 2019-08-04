
public class Circle extends Shape {
	
	int radius;
	
	public Circle (int r) {
		radius = r;
	}
	
	// must implement area() because it is a subclass of Shape
	// must have the same return type and parameter(s)
	public double area() {
		return 3.14 * (radius * radius);
	}
	
	public String toString() {
		return "Circle!";
	}
	
	public void myMethod2() {
		// testing method left blank on purpose
	}

}

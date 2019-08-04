// In abstract classes, methods CAN be abstract
// (meaning, only declared, no body)

public abstract class Shape {
	
	String color;
	
	abstract double area();
	// But, regular classes can't have abstract methods
	
	public String toString() {
		return "Shape";
	}
	
	// Example on "compile-time polymorphism" or "method overloading"
	// methods contain the same name AND return type
	// but parameters must be different
	public void myMethod1() {
	}
	
	public void myMethod1(int m) {
	}

}

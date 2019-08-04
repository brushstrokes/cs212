
public class Main {
	
	public static void main(String[] args) {
		
		// abstract classes cannot be instantiated
		
		Circle c = new Circle(2);
		Shape s2 = new Circle(2);
		
		// accessing area()
		System.out.println(c.area());
		System.out.println(s2.area());
		
		// accessing myMethod1 & myMethod2
		c.myMethod1();
		c.myMethod2();
		s2.myMethod1();
		// s2.myMethod2();
			// Although s2 was a new Circle, it is a Shape type
			// thus it can only access methods listed in the Shape class
		
		// toString methods were implemented in both the Circle and Shape class
		System.out.println(c);
		System.out.println(s2);
			// s2 prints Circle, picks the "better" implementation catered to that object
			// // This is "runtime polymorphism" or "method overriding"
	}

}






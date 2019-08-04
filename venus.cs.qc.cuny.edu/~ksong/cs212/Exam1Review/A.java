
public interface A {
	
	// variables are static, final by default
	// methods are abstract and public by default
	
	
	int x = 5;
	// equivalent to static final int x = 5;
	// static: only one copy
	// final: can't change value
	// x = 4; will cause an error
	
	
	int compareTo(Object o);
	// public by default
	// do not implement (fill the body)
	
	
	// *** Classes can "implement" many interfaces
	// BUT they can only "extend" one class
	// public class A extends B implements C, D

	// Interfaces can "extend" many interfaces
	// public interface Z extends Y, X, W
	
}

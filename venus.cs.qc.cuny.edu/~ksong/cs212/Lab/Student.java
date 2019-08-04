
public class Student {
	
	// instance variables
	String lastName, firstName;
	private int ID;
	private double GPA;
	
	// class/static variables
	static int totalNumOfStudents = 0;
	static int idGenerator = 10000000;
	
	// Constructor
	public Student (String l, String f) {
		lastName = l;
		firstName = f;
		totalNumOfStudents++;
		ID = idGenerator++;
	}
	
	public int getID() {
		return ID;
	}
	
	public void printName() {
		System.out.println(lastName + ", " + firstName);
	}
	
}

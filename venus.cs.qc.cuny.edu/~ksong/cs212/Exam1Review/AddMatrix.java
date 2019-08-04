
// short matrix class that only contains the add method,
// to demonstrate how Exceptions are thrown
public class AddMatrix {

	// instance variables
	int[][] myMatrix;
	int row, col;

	// Constructor
	public AddMatrix(int[][] m) {
		myMatrix = m;
		row = m.length;
		col = m[0].length;
	}

	// add method
	public AddMatrix add(AddMatrix m) {

		// How to throw a customized Exception
		if (row != m.row || col != m.col)
			throw new IllegalArgumentException("Cannot add matrix.");

		AddMatrix a = new AddMatrix(new int[row][col]);
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				a.myMatrix[i][j] = myMatrix[i][j] + m.myMatrix[i][j];
			}
		}
		return a;

	}
}
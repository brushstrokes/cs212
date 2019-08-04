
public class MatrixDriver {

	public static void main(String[] args) {
		AddMatrix a = new AddMatrix(new int[][] { { 1, 2 }, { 2, 0 } });
		AddMatrix b = new AddMatrix(new int[][] { { 1, 2, 3 }, { 2, 0, 4 } } );
		
		try {
			a.add(b);
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
	}

}

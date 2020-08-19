package Q1_08_Zero_Matrix;

import CtCILibrary.AssortedMethods;

public class QuestionB_ {
	public static void nullifyRow(int[][] matrix, int row) {
		for (int j = 0; j < matrix[0].length; j++) {
			matrix[row][j] = 0;
		}
	}

	public static void nullifyColumn(int[][] matrix, int col) {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][col] = 0;
		}
	}		
	
	public static void setZeros(int[][] matrix) {
		boolean rowHasZero = false;
		boolean columnHasZero = false;
		for (int j = 0; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				rowHasZero = true;
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				columnHasZero = true;
			}
		}
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0; // first column at index i is 0 when there is a zero in row i (due to (i, j) position)
					matrix[0][j] = 0; // first row at index j is 0 when there is a zero in column j (due to (i, j) position)
				}
			}
		}

		// check if there is a zero at (i, 0), if it is zero, there is a zero in row i, nullify row i
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				nullifyRow(matrix, i);
			}
		}
		// check if there is a zero at (0, j) if it is zero, there is a zero in column j, nullify column j
		for (int j = 0; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				nullifyColumn(matrix, j);
			}
		}
		// check if the first row originally had a zero, if it had a zero, nullify 0th row
		if (rowHasZero) {
			nullifyRow(matrix, 0);
		}
		// check if the first column originally had a zero, if it had a zero, nullify 0th column
		if (columnHasZero) {
			nullifyColumn(matrix, 0);
		}
	}	
	
	public static boolean matricesAreEqual(int[][] m1, int[][] m2) {
		if (m1.length != m2.length || m1[0].length != m2[0].length) {
			return false;
		}
		
		for (int k = 0; k < m1.length; k++) {
			for (int j = 0; j < m1[0].length; j++) {
				if (m1[k][j] != m2[k][j]) {
					return false;
				}
			}
		}	
		return true;
	}
	
	public static int[][] cloneMatrix(int[][] matrix) {
		int[][] c = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				c[i][j] = matrix[i][j];
			}
		}
		return c;
	}
	
	public static void main(String[] args) {
		int nrows = 10;
		int ncols = 15;
		int[][] matrix = AssortedMethods.randomMatrix(nrows, ncols, -10, 10);		

		AssortedMethods.printMatrix(matrix);
		
		setZeros(matrix);
		
		System.out.println();
		
		AssortedMethods.printMatrix(matrix);
	}
}

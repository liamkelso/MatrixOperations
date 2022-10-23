public class MatrixCalculations {

	/**
	 * Adds two given matrices
	 * 
	 * @param matrixOne
	 * @param matrixTwo
	 * @return
	 */
	public static String addition(double[][] matrixOne, double[][] matrixTwo) {

		double[][] returnMatrix = new double[matrixOne.length][matrixTwo.length];

		for (int i = 0; i < matrixOne.length; i++) {
			for (int j = 0; j < matrixOne.length; j++) {
				returnMatrix[i][j] = matrixOne[i][j] + matrixTwo[i][j];
			}
		}

		return matrixToString(returnMatrix);
	}

	/**
	 * Subtracts two given matrices
	 * 
	 * @param matrixOne
	 * @param matrixTwo
	 * @return
	 */
	public static String subtraction(double[][] matrixOne, double[][] matrixTwo) {

		double[][] returnMatrix = new double[matrixOne.length][matrixTwo.length];

		for (int i = 0; i < matrixOne.length; i++) {
			for (int j = 0; j < matrixOne.length; j++) {
				returnMatrix[i][j] = matrixOne[i][j] - matrixTwo[i][j];
			}
		}

		return matrixToString(returnMatrix);
	}

	/**
	 * multiplies two given matrices
	 * 
	 * @param matrixOne
	 * @param matrixTwo
	 * @return
	 */
	public static double[][] multiplication(double[][] matrixOne, double[][] matrixTwo) {

		double[][] returnMatrix = new double[matrixOne.length][matrixTwo[0].length];
		for (int i = 0; i < matrixOne.length; i++) {
			for (int j = 0; j < returnMatrix[i].length; j++) {
				returnMatrix[i][j] = multiplicationHelper(matrixOne, matrixTwo, i, j);
			}
		}

		return returnMatrix;
	}

	/**
	 * A helper function for the multiplication of two given matrices
	 * 
	 * @param matrixOne
	 * @param matrixTwo
	 * @param i
	 * @param j
	 * @return
	 */
	public static double multiplicationHelper(double[][] matrixOne, double[][] matrixTwo, int i, int j) {

		double returnVal = 0.0;

		for (int k = 0; k < matrixTwo.length; k++) {
			returnVal += matrixOne[i][k] * matrixTwo[k][j];
		}

		return returnVal;

	}

	/**
	 * 
	 * @param matrix
	 * @return
	 */
	public static String transpose(double[][] matrix) {
		double[][] returnMatrix = new double[matrix[0].length][matrix.length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				returnMatrix[j][i] = matrix[i][j];
			}
		}
		return matrixToString(returnMatrix);
	}

	/**
	 * 
	 * @param power
	 * @param matrix
	 * @return
	 */
	public static String matrixPower(int power, double[][] matrix) {
		double[][] returnMatrix = matrix;
		for (int i = 0; i < power - 1; i++) {
			returnMatrix = multiplication(returnMatrix, matrix);
		}

		return matrixToString(returnMatrix);
	}

	/**
	 * Takes a string and converts to a matrix
	 * 
	 * @param matrixString
	 * @return a 2d double array
	 */
	public static double[][] stringToMatrix(String[][] matrixString) {
		double[][] returnMatrix = new double[matrixString.length][matrixString[0].length];
		for (int i = 0; i < matrixString.length; i++) {
			for (int j = 0; j < matrixString[0].length; j++) {
				returnMatrix[i][j] = Double.valueOf(matrixString[i][j]);
			}
		}
		return returnMatrix;

	}

	/**
	 * Takes a matrix and converts to a string
	 * 
	 * @param matrix
	 * @return a string representation of the matrix
	 */
	public static String matrixToString(double[][] matrix) {
		String matrixPrinted = "";
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrixPrinted += matrix[i][j] + "  ";
			}
			matrixPrinted += "\n";
		}
		return matrixPrinted;
	}

}

public class MatrixCalculations {

    /**
     * Adds two given matrices.
     * Assumes matrixOne and matrixTwo have the same dimensions.
     *
     * @param matrixOne the first matrix
     * @param matrixTwo the second matrix
     * @return a string representation of the sum matrix
     */
    public static String addition(double[][] matrixOne, double[][] matrixTwo) {
        int rows = matrixOne.length;
        int cols = matrixOne[0].length;
        double[][] returnMatrix = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                returnMatrix[i][j] = matrixOne[i][j] + matrixTwo[i][j];
            }
        }
        return matrixToString(returnMatrix);
    }

    /**
     * Subtracts two given matrices.
     * Assumes matrixOne and matrixTwo have the same dimensions.
     *
     * @param matrixOne the first matrix
     * @param matrixTwo the second matrix
     * @return a string representation of the difference matrix
     */
    public static String subtraction(double[][] matrixOne, double[][] matrixTwo) {
        int rows = matrixOne.length;
        int cols = matrixOne[0].length;
        double[][] returnMatrix = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                returnMatrix[i][j] = matrixOne[i][j] - matrixTwo[i][j];
            }
        }
        return matrixToString(returnMatrix);
    }

    /**
     * Multiplies two given matrices.
     * Assumes the number of columns in matrixOne equals the number of rows in matrixTwo.
     *
     * @param matrixOne the first matrix
     * @param matrixTwo the second matrix
     * @return the resulting matrix from multiplication
     */
    public static double[][] multiplication(double[][] matrixOne, double[][] matrixTwo) {
        int m = matrixOne.length;
        int n = matrixTwo[0].length;
        double[][] returnMatrix = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                returnMatrix[i][j] = multiplicationHelper(matrixOne, matrixTwo, i, j);
            }
        }
        return returnMatrix;
    }

    /**
     * A helper function for the multiplication of two given matrices.
     *
     * @param matrixOne the first matrix
     * @param matrixTwo the second matrix
     * @param i         the current row in matrixOne
     * @param j         the current column in matrixTwo
     * @return the computed value for cell (i, j) in the resulting matrix
     */
    public static double multiplicationHelper(double[][] matrixOne, double[][] matrixTwo, int i, int j) {
        double returnVal = 0.0;
        int commonDimension = matrixOne[0].length;  // equals matrixTwo.length if matrices are valid
        for (int k = 0; k < commonDimension; k++) {
            returnVal += matrixOne[i][k] * matrixTwo[k][j];
        }
        return returnVal;
    }

    /**
     * Returns the transpose of the given matrix.
     *
     * @param matrix the input matrix
     * @return a string representation of the transposed matrix
     */
    public static String transpose(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] returnMatrix = new double[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                returnMatrix[j][i] = matrix[i][j];
            }
        }
        return matrixToString(returnMatrix);
    }

    /**
     * Raises the given matrix to the specified power.
     * For power = 0, returns the identity matrix.
     * Negative powers are not supported.
     *
     * @param power  the exponent
     * @param matrix the input matrix
     * @return a string representation of the resulting matrix
     */
    public static String matrixPower(int power, double[][] matrix) {
        if (power < 0) {
            throw new IllegalArgumentException("Negative power not supported.");
        }
        if (power == 0) {
            // Create and return an identity matrix of appropriate size.
            int n = matrix.length;
            double[][] identity = new double[n][n];
            for (int i = 0; i < n; i++) {
                identity[i][i] = 1.0;
            }
            return matrixToString(identity);
        }

        double[][] returnMatrix = matrix;
        for (int i = 1; i < power; i++) {
            returnMatrix = multiplication(returnMatrix, matrix);
        }
        return matrixToString(returnMatrix);
    }

    /**
     * Converts a 2D String array to a 2D double array.
     *
     * @param matrixString a 2D array of strings representing numbers
     * @return a 2D double array
     */
    public static double[][] stringToMatrix(String[][] matrixString) {
        int rows = matrixString.length;
        int cols = matrixString[0].length;
        double[][] returnMatrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                returnMatrix[i][j] = Double.valueOf(matrixString[i][j]);
            }
        }
        return returnMatrix;
    }

    /**
     * Converts a matrix to a string representation.
     *
     * @param matrix the input matrix
     * @return a string representation of the matrix
     */
    public static String matrixToString(double[][] matrix) {
        StringBuilder sb = new StringBuilder();
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sb.append(matrix[i][j]).append("  ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}


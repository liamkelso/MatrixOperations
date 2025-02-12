import java.util.Scanner;

/**
 * Matrix operations main program.
 */
public class MatrixMain extends MatrixCalculations {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Hello and welcome to the Matrix Calculator.");
        System.out.println("Please select a calculation.");
        System.out.println("Type A for addition, S for subtraction, T for transpose, P for power, M for multiplication.");

        String calculation = userInput.nextLine().trim();

        // Allow both uppercase and lowercase inputs.
        while (!calculation.matches("(?i)a|s|t|p|m")) {
            System.out.println("Sorry, your input is not one of the options. Please try again.");
            System.out.println("Type A for addition, S for subtraction, T for transpose, P for power, M for multiplication.");
            calculation = userInput.nextLine().trim();
        }

        try {
            int rows = 0, cols = 0, rows2 = 0, cols2 = 0;

            // For operations that require two matrices.
            if (calculation.equalsIgnoreCase("A") ||
                calculation.equalsIgnoreCase("S") ||
                calculation.equalsIgnoreCase("M")) {

                System.out.println("Enter the number of rows for the first matrix:");
                rows = userInput.nextInt();
                System.out.println("Enter the number of columns for the first matrix:");
                cols = userInput.nextInt();

                System.out.println("Enter the number of rows for the second matrix:");
                rows2 = userInput.nextInt();
                System.out.println("Enter the number of columns for the second matrix:");
                cols2 = userInput.nextInt();

                // Validate dimensions.
                if (calculation.equalsIgnoreCase("A") || calculation.equalsIgnoreCase("S")) {
                    if (rows != rows2 || cols != cols2) {
                        System.out.println("Error: For addition and subtraction, both matrices must have the same dimensions.");
                        userInput.close();
                        return;
                    }
                } else if (calculation.equalsIgnoreCase("M")) {
                    if (cols != rows2) {
                        System.out.println("Error: For multiplication, the number of columns of the first matrix must equal the number of rows of the second matrix.");
                        userInput.close();
                        return;
                    }
                }
            } else { // For operations that require only one matrix (Transpose and Power).
                System.out.println("Enter the number of rows for the matrix:");
                rows = userInput.nextInt();
                System.out.println("Enter the number of columns for the matrix:");
                cols = userInput.nextInt();

                if (calculation.equalsIgnoreCase("P") && (rows != cols)) {
                    System.out.println("Error: For the power operation, the matrix must be square.");
                    userInput.close();
                    return;
                }
            }

            // Clear the newline left by nextInt.
            userInput.nextLine();

            // Prepare matrix string arrays.
            if (calculation.equalsIgnoreCase("A")) {
                String[][] matrix1 = new String[rows][cols];
                String[][] matrix2 = new String[rows][cols];
                
                System.out.println("Enter the elements for the first matrix:");
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        System.out.print("Element (" + (i + 1) + "," + (j + 1) + "): ");
                        matrix1[i][j] = userInput.next();
                    }
                }
                
                System.out.println("Enter the elements for the second matrix:");
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        System.out.print("Element (" + (i + 1) + "," + (j + 1) + "): ");
                        matrix2[i][j] = userInput.next();
                    }
                }
                
                double[][] m1 = stringToMatrix(matrix1);
                double[][] m2 = stringToMatrix(matrix2);
                System.out.println("Result of addition:");
                System.out.println(addition(m1, m2));
                
            } else if (calculation.equalsIgnoreCase("S")) {
                String[][] matrix1 = new String[rows][cols];
                String[][] matrix2 = new String[rows][cols];
                
                System.out.println("Enter the elements for the first matrix:");
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        System.out.print("Element (" + (i + 1) + "," + (j + 1) + "): ");
                        matrix1[i][j] = userInput.next();
                    }
                }
                
                System.out.println("Enter the elements for the second matrix:");
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        System.out.print("Element (" + (i + 1) + "," + (j + 1) + "): ");
                        matrix2[i][j] = userInput.next();
                    }
                }
                
                double[][] m1 = stringToMatrix(matrix1);
                double[][] m2 = stringToMatrix(matrix2);
                System.out.println("Result of subtraction:");
                System.out.println(subtraction(m1, m2));
                
            } else if (calculation.equalsIgnoreCase("M")) {
                // For multiplication, first matrix is of size (rows x cols) and
                // the second matrix is of size (rows2 x cols2), where cols == rows2.
                String[][] matrix1 = new String[rows][cols];
                String[][] matrix2 = new String[rows2][cols2];
                
                System.out.println("Enter the elements for the first matrix:");
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        System.out.print("Element (" + (i + 1) + "," + (j + 1) + "): ");
                        matrix1[i][j] = userInput.next();
                    }
                }
                
                System.out.println("Enter the elements for the second matrix:");
                for (int i = 0; i < rows2; i++) {
                    for (int j = 0; j < cols2; j++) {
                        System.out.print("Element (" + (i + 1) + "," + (j + 1) + "): ");
                        matrix2[i][j] = userInput.next();
                    }
                }
                
                double[][] m1 = stringToMatrix(matrix1);
                double[][] m2 = stringToMatrix(matrix2);
                System.out.println("Result of multiplication:");
                System.out.println(matrixToString(multiplication(m1, m2)));
                
            } else if (calculation.equalsIgnoreCase("T")) {
                String[][] matrix1 = new String[rows][cols];
                
                System.out.println("Enter the elements for the matrix:");
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        System.out.print("Element (" + (i + 1) + "," + (j + 1) + "): ");
                        matrix1[i][j] = userInput.next();
                    }
                }
                
                double[][] m1 = stringToMatrix(matrix1);
                System.out.println("Transpose of the matrix:");
                System.out.println(transpose(m1));
                
            } else if (calculation.equalsIgnoreCase("P")) {
                String[][] matrix1 = new String[rows][cols];
                
                System.out.println("Enter the elements for the matrix:");
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        System.out.print("Element (" + (i + 1) + "," + (j + 1) + "): ");
                        matrix1[i][j] = userInput.next();
                    }
                }
                
                System.out.print("Enter the power to which you want to raise the matrix: ");
                int power = userInput.nextInt();
                double[][] m1 = stringToMatrix(matrix1);
                System.out.println("Matrix raised to the power " + power + ":");
                System.out.println(matrixPower(power, m1));
            }
        } catch (Exception e) {
            System.out.println("Sorry, we experienced an error running the calculations on your matrix. "
                    + "Please try again and make sure all inputs are correct.");
        } finally {
            userInput.close();
        }
    }
}


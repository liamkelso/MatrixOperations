import java.util.Scanner;

/**
 * Matrix operations
 * 
 * @author lkel
 *
 */
public class MatrixMain extends MatrixCalculations {

	public static void main(String[] args) {

		String calculation = "";
		int columns = 0, rows = 0, columns2 = 0, rows2 = 0;
		String entry = "";

		@SuppressWarnings("resource")
		Scanner userInput = new Scanner(System.in);
		System.out.println("Hello and welcome to the Matrix Calculator.");
		System.out.println("Please select a calculation. Type A for addition, S for subtraction, T for transpose, P for power, M for multiplication.");
		calculation = userInput.nextLine();
		while (!calculation.matches("a|s|t|p|m|A|S|T|P|M")) {
			System.out.println("Sorry, your input is not one of the options. Please try again.");
			System.out.println("Please select a calculation. Type A for addition, S for subtraction, T for transpose, P for power, M for multiplication.");
			calculation = userInput.nextLine();
		}
		try {
		// For Subtraction
		if (calculation.equalsIgnoreCase("S")) {
			System.out.println("Please enter the number of rows your first martix has.");
			rows = userInput.nextInt();
			System.out.println("Please enter the number of columns your first martix has.");
			columns = userInput.nextInt();
			System.out.println("Please enter the number of rows your second martix has.");
			rows2 = userInput.nextInt();
			System.out.println("Please enter the number of columns your second martix has.");
			columns2 = userInput.nextInt();
			if (rows2 != rows || columns != columns2) {
				System.out.println("Sorry, you can only subtract matrices with the same dimensions");
			}
		}
		// addition
		else if (calculation.equalsIgnoreCase("A")) {
			System.out.println("Please enter the number of rows your first martix has.");
			rows = userInput.nextInt();
			System.out.println("Please enter the number of columns your first martix has.");
			columns = userInput.nextInt();
			System.out.println("Please enter the number of rows your second martix has.");
			rows2 = userInput.nextInt();
			System.out.println("Please enter the number of columns your second martix has.");
			columns2 = userInput.nextInt();
			if (rows2 != rows || columns != columns2) {
				System.out.println("Sorry, you can only add matrices with the same dimensions");
				System.exit(0);
			}
		}
		// mult
		else if (calculation.equalsIgnoreCase("m")) {
			System.out.println("Please enter the number of rows your first martix has.");
			rows = userInput.nextInt();
			System.out.println("Please enter the number of columns your first martix has.");
			columns = userInput.nextInt();
			System.out.println("Please enter the number of rows your second martix has.");
			rows2 = userInput.nextInt();
			System.out.println("Please enter the number of columns your second martix has.");
			columns2 = userInput.nextInt();
			if (columns != rows2) {
				System.out.println("Sorry, you can not do multiplication on matrices with these dimensions");
				System.exit(0);
			}

		} else {
			System.out.println("Please enter the number of rows your martix has.");
			rows = userInput.nextInt();
			System.out.println("Please enter the number of columns your martix has.");
			columns = userInput.nextInt();
		}
		

		String[][] matrix = new String[rows][columns];
		String[][] matrix2 = new String[rows2][columns2];

		// subtraction
		if (calculation.equalsIgnoreCase("S")) {
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					System.out.println("Please enter the " + (i + 1) + "," + (j + 1) + " element of your first matrix");
					entry = userInput.next();
					matrix[i][j] = entry;
				}
			}
			for (int i = 0; i < matrix2.length; i++) {
				for (int j = 0; j < matrix2[0].length; j++) {
					System.out
							.println("Please enter the " + (i + 1) + "," + (j + 1) + " element of your second matrix");
					entry = userInput.next();
					matrix2[i][j] = entry;
				}
			}
			double[][] tempMatrix = stringToMatrix(matrix);
			double[][] tempMatrix2 = stringToMatrix(matrix2);
			System.out.println(subtraction(tempMatrix, tempMatrix2));
		}

		// Addition
		if (calculation.equalsIgnoreCase("A")) {
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					System.out.println("Please enter the " + (i + 1) + "," + (j + 1) + " element of your first matrix");
					entry = userInput.next();
					matrix[i][j] = entry;
				}
			}
			for (int i = 0; i < matrix2.length; i++) {
				for (int j = 0; j < matrix2[0].length; j++) {
					System.out
							.println("Please enter the " + (i + 1) + "," + (j + 1) + " element of your second matrix");
					entry = userInput.next();
					matrix2[i][j] = entry;
				}
			}
			double[][] tempMatrix = stringToMatrix(matrix);
			double[][] tempMatrix2 = stringToMatrix(matrix2);
			System.out.println(addition(tempMatrix, tempMatrix2));
		}

		// multiplication
		if (calculation.equalsIgnoreCase("M")) {
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					System.out.println("Please enter the " + (i + 1) + "," + (j + 1) + " element of your first matrix");
					entry = userInput.next();
					matrix[i][j] = entry;
				}
			}
			for (int i = 0; i < matrix2.length; i++) {
				for (int j = 0; j < matrix2[0].length; j++) {
					System.out
							.println("Please enter the " + (i + 1) + "," + (j + 1) + " element of your second matrix");
					entry = userInput.next();
					matrix2[i][j] = entry;
				}
			}
			double[][] tempMatrix = stringToMatrix(matrix);
			double[][] tempMatrix2 = stringToMatrix(matrix2);
			System.out.println(matrixToString(multiplication(tempMatrix, tempMatrix2)));
		}

		// Transpose
		if (calculation.equalsIgnoreCase("T")) {
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					System.out.println("Please enter the " + (i + 1) + "," + (j + 1) + " element of your matrix");
					entry = userInput.next();
					matrix[i][j] = entry;
				}
			}
			double[][] tempMatrix = stringToMatrix(matrix);
			System.out.println(transpose(tempMatrix));
		}

		// Power
		if (calculation.equalsIgnoreCase("P")) {
			if (rows != columns) {
				System.out.println("Sorry, this operation will not work unless the matrix is a square matrix.");
			}
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					System.out.println("Please enter the " + (i + 1) + "," + (j + 1) + " element of your matrix");
					entry = userInput.next();
					matrix[i][j] = entry;
				}
			}
			System.out.println("Please enter the power you wish to raise your matrix to");
			int power = userInput.nextInt();
			double[][] tempMatrix = stringToMatrix(matrix);
			System.out.println(matrixPower(power, tempMatrix));
		}
		}catch(Exception e) {
			 System.out.println("Sorry, we experienced an error running the calculations on your matrix. Please try again and make sure"
			 		+ " all inputs are correct.");
		}
	}

}

package com.MalikMagic;

import java.util.Scanner;

/**
 * User interface for Magic Square application
 * 
 * @author Abdullah Malik
 *
 */
public class MagicSquare {
	public static void main(String[] args) {
		int[][] square = { { 8, 1, 6 }, { 3, 5, 7 }, { 4, 9, 2 }, };

		System.out.println("Scenario 1 : 2D array to be validated");
		displaySquare(square);
		checkSquare(square);

		// swap 2 values in the original square and recheck
		int temp = square[0][0];
		square[0][0] = square[2][2];
		square[2][2] = temp;

		System.out.println("Scenario 2 : 2D array to be validated");
		displaySquare(square);
		checkSquare(square);

		// obtain a valid dimension to create a magic square
		int n = getPositiveOddInteger();

		// create and display the square
		int[][] newSquare = createMagic(n);
		displaySquare(newSquare);

		// Checks if the square is magic
		if (isMagic(newSquare)) {
			System.out.println("Your a wizard squary, Magic constant is: " + getMagicConstant(newSquare));
		} else {
			System.out.println("Your a muggle squary");
		}
	}

	/**
	 * Validate if a square is considered magic. If it is magic the magic constant
	 * will be displayed.
	 * 
	 * @param square 2D array to be checked
	 */
	private static void checkSquare(int[][] square) {
		if (isMagic(square)) {
			// square is magical
			System.out.println("Your a wizard squary, Magic constant is: " + getMagicConstant(square));
		} else {
			// square is not magical
			System.out.println("Your a muggle squary");
		}
	}

	/**
	 * Obtain a positive odd value integer from the user.
	 * 
	 * @return int positive odd value
	 */
	private static int getPositiveOddInteger() {
		Scanner in = new Scanner(System.in);
		int n = 0;

		// loop to make sure input is in bounds (in this case only positive odd integer)
		boolean inboundInput = false;
		while (!inboundInput) {
			System.out.println("Please provide an odd value dimension for your magic square: ");
			if (in.hasNextInt()) {
				n = in.nextInt();

				// check the integer
				if (n > 0 && n % 2 != 0) {
					inboundInput = true;
				} else {
					// if not positive odd integer tell user
					System.out.println("Dimensions must be a positive odd integer.");
				}
			} else {
				in.nextLine();
				System.out.println("Dimensions must be a positive odd integer.");
			}
		}

		// return odd integer value and close scanner
		in.close();
		return n;
	}

	/**
	 * Validates if each row sum, column sum, and diagonal sum is the same.
	 * 
	 * @param grid two-dimensional array that is being verified
	 * @return boolean true if the array is magic, otherwise false
	 */
	private static boolean isMagic(int[][] grid) {
		int magicConstant = getMagicConstant(grid); // get magic constant for comparison later
		boolean isMagic = true; // innocent until proven guilty (true until proven false)

		// See if square is magical by checking the sum of the rows, columns and
		// diagonals
		// Check each row
		for (int i = 0; i < grid.length; i++) {
			// Find the sum of row #i.
			int sum = 0;
			for (int j = 0; j < grid.length; j++)
				sum += grid[i][j];

			// If this row does not equal magicConstant, then it is not a magic square
			if (sum != magicConstant)
				isMagic = false;
		}

		// Check each column
		for (int i = 0; i < grid.length; i++) {
			// Find the sum of column #i
			int sum = 0;
			for (int j = 0; j < grid.length; j++)
				sum += grid[i][j];

			// If this column does not equal magicConstant, then it is not a magic square
			if (sum != magicConstant)
				isMagic = false;
		}

		// Check forward diagonal.
		int fSum = 0;
		for (int i = 0; i < grid.length; i++) {
			fSum += grid[i][i];
		}
		if (fSum != magicConstant) {
			isMagic = false;
		}
		// Check backward diagonal.
		int bSum = 0;
		for (int i = 0; i < grid.length; i++) {
			bSum += grid[i][grid.length - i - 1];
		}
		if (bSum != magicConstant) {
			isMagic = false;
		}

		// return result
		return isMagic;
	}

	/**
	 * Creates and returns a magic square.
	 * 
	 * @param d the dimensions of the square
	 * @return int[][] a fully populated magic square
	 */
	private static int[][] createMagic(int d) {
		int[][] square = new int[d][d];

		int number = 1;
		int row = 0;
		int column = d / 2;
		int curr_row;
		int curr_col;
		while (number <= d * d) {
			square[row][column] = number;
			number++;
			curr_row = row;
			curr_col = column;
			row -= 1;
			column += 1;
			if (row == -1) {
				row = d - 1;
			}
			if (column == d) {
				column = 0;
			}
			if (square[row][column] != 0) {
				row = curr_row + 1;
				column = curr_col;
				if (row == -1) {
					row = d - 1;
				}
			}
		}

		return square;
	}

	/**
	 * Displays a 2D array in row major order
	 * 
	 * @param grid array to be displayed
	 */
	private static void displaySquare(int[][] grid) {
		// displays the square to the user

		for (int[] row : grid) {
			for (int value : row) {
				System.out.format("%4d ", value);
			}
			System.out.println();
		}
	}

	/**
	 * Obtain the magic constant of a previously validated magic square.
	 * 
	 * @param grid 2D array representing a magic square
	 * @return int magic constant
	 */
	private static int getMagicConstant(int[][] grid) {
		// magic constant is the sum of any dimension
		// calculate the row sum of the first row
		int total = 0;

		for (int j = 0; j < grid.length; j++) {
			total += grid[j][0];
		}

		return total;

	}
}

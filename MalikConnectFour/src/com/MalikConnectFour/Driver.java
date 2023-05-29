package com.MalikConnectFour;

import java.util.Scanner;

/*
 * PLEASE NOTE: this code is no longer maintained, use GUIDriver instead
 */

/**
 * (outdated) Core driver for connect four application
 * 
 * @author Abdullah Malik
 *
 */
public class Driver {

	public static void main(String[] args) {

		// Setup constants for the Board
		final int ROWS = 6;
		final int COLS = 7;

		// create the board
		Board board = new Board(ROWS, COLS);
		board.display();

		// console input
		Scanner in = new Scanner(System.in);
		int column = 0;
		CellState player = CellState.P1;
		boolean winner = false;

		while (winner == false) {
			column = getColumn(in, 1, COLS);
			board.placePiece(column, player);

			// Check for winners
			winner = board.isWinner(player);

			// display updated board
			board.display();

			// Take turns between players
			if (player == CellState.P1) {
				player = CellState.P2;
			} else if (player == CellState.P2) {
				player = CellState.P1;
			}

			// check for and display winners
			if (winner) {
				if (player == CellState.P1) {
					System.out.println("Player 1 won");
				} else {
					System.out.println("Player 2 won");
				}
			}
		}
	}

	/*
	 * 
	 * Helper method to ensure column value is valid.*
	 * 
	 * @param in
	 * 
	 * @return valid column number
	 */

	private static int getColumn(Scanner in, int min, int max) {
		boolean valid = false;
		int column = 0;

		// check for valid input
		while (!valid) {
			String prompt = String.format("Which column (%d,%d) :", min, max);
			System.out.print(prompt);
			if (in.hasNextInt()) {
				column = in.nextInt();
				if (column >= min && column <= max) {
					valid = true;
				} else {
					System.out.println("Invalid numeric value provided.");
				}
			} else {
				System.out.println("Not a number.");
			}
			in.nextLine();
		}
		return column;
	}
}
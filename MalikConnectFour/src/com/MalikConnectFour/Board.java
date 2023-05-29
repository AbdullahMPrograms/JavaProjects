package com.MalikConnectFour;

/**
 * Represents a 2 dimensional Board for Grid based games.
 * 
 * @author Abdullah Malik
 *
 */

public class Board {

	private Cell[][] board;
	private int rows;
	private int cols;
	int turn = 0;

	/**
	 * Constructor for Boards.
	 * 
	 * @param aRows number of rows in board
	 * @param aCols number of columns in board
	 */
	public Board(int aRows, int aCols) {
		board = new Cell[aRows][aCols];
		rows = aRows;
		cols = aCols;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				board[i][j] = new Cell(CellState.EMPTY); // no color
			}
		}
	}

	/**
	 * Obtain the current number of rows.
	 * 
	 * @return number of rows
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * adds a turn
	 * 
	 * @return added turn
	 */
	public int addTurn() {
		return turn++;
	}

	/**
	 * Obtain the current number of columns.
	 * 
	 * @return number of columns
	 */
	public int getCols() {
		return cols;
	}

	/**
	 * Check if a proposed location is valid.
	 * 
	 * @param rowIndex row index to check
	 * @param colIndex column index to check
	 * @return true if index value is valid, otherwise false
	 */
	public boolean isValid(int rowIndex, int colIndex) {
		return (rowIndex >= 0 && rowIndex < rows) && (colIndex >= 0 && colIndex < cols);
	}

	/**
	 * Displays board in driver
	 */
	public void display() {
		System.out.println("BOARD");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.printf("%s ", board[i][j]);
			}
			System.out.println();
		}
	}

	/**
	 * checks if column is full
	 * 
	 * @param col
	 * @return true if column is full, otherwise false
	 */
	public boolean isFull(int col) {
		return board[0][col - 1].getState() != CellState.EMPTY;
	}

	/**
	 * places pieces as selected by user
	 * 
	 * @param column
	 * @param player
	 */
	public void placePiece(int column, CellState player) {
		for (int i = rows - 1; i >= 0; i--) {
			if (board[i][column - 1].getState() == CellState.EMPTY) {
				board[i][column - 1].setState(player);
				break;
			}

		}
	}

	/**
	 * checks if a winner exists
	 * 
	 * @param player
	 * @return true if there is a winner, otherwise false
	 */
	public boolean isWinner(CellState player) {
		// check for 4 across
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length - 3; col++) {
				if (board[row][col].getState() == player && board[row][col + 1].getState() == player
						&& board[row][col + 2].getState() == player && board[row][col + 3].getState() == player) {
					return true;
				}
			}
		}
		// check for 4 up and down
		for (int row = 0; row < board.length - 3; row++) {
			for (int col = 0; col < board[0].length; col++) {
				if (board[row][col].getState() == player && board[row + 1][col].getState() == player
						&& board[row + 2][col].getState() == player && board[row + 3][col].getState() == player) {
					return true;
				}
			}
		}
		// check upward diagonal
		for (int row = 3; row < board.length; row++) {
			for (int col = 0; col < board[0].length - 3; col++) {
				if (board[row][col].getState() == player && board[row - 1][col + 1].getState() == player
						&& board[row - 2][col + 2].getState() == player
						&& board[row - 3][col + 3].getState() == player) {
					return true;
				}
			}
		}
		// check downward diagonal
		for (int row = 0; row < board.length - 3; row++) {
			for (int col = 0; col < board[0].length - 3; col++) {
				if (board[row][col].getState() == player && board[row + 1][col + 1].getState() == player
						&& board[row + 2][col + 2].getState() == player
						&& board[row + 3][col + 3].getState() == player) {
					return true;
				}
			}

		}
		return false;
	}

	/**
	 * return board
	 * 
	 * @return board
	 */
	public Cell[][] getBoard() {
		return board;
	}

	/**
	 * return # of turns
	 * 
	 * @return number of turns
	 */
	public int getTurn() {
		return turn;
	}
}
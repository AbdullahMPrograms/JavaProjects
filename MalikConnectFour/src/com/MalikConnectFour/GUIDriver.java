package com.MalikConnectFour;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * Graphical Driver for Connect 4 application
 * 
 * @author Abdullah Malik
 *
 */

public class GUIDriver extends Application {

	final int WIDTH = 800;
	final int HEIGHT = 900;
	final int NUM_COLUMNS = 7;
	final int NUM_ROWS = 6;
	// create the board
	Board board = new Board(NUM_ROWS, NUM_COLUMNS);
	// Initialize player as CellState
	CellState player = CellState.P1;
	int column = 0;
	boolean winner = false;
	boolean aiMode = false;
	private Button[][] locations = new Button[NUM_ROWS][NUM_COLUMNS];

	// method to switch user (player1 -> player2)
	private void switchUser() {
		if (player == CellState.P1) {
			player = CellState.P2;
		} else if (player == CellState.P2) {
			player = CellState.P1;
		}
	}

	// update board with information from user selection
	private void updateStuff(Board board, Button[][] locations) {
		Cell[][] cells = board.getBoard();
		for (int r = 0; r < cells.length; r++) {
			for (int c = 0; c < cells[0].length; c++) {
				if (cells[r][c].getState() == CellState.P1) {
					locations[r][c].setStyle("-fx-background-color: #FFFF00; ");

				} else if (cells[r][c].getState() == CellState.P2) {
					locations[r][c].setStyle("-fx-background-color: #FF0000; ");

				}
			}
		}
	}

	@Override
	public void start(Stage stage) throws Exception {
		// print board in driver for debugging
		board.display();

		// Title for Win
		Label winTitle = new Label();
		winTitle.setFont(new Font(80));
		winTitle.setAlignment(Pos.CENTER);

		// Title for Ties
		Label tieTitle = new Label("Tie Game");
		tieTitle.setFont(new Font(80));
		tieTitle.setAlignment(Pos.CENTER);

		// Button to reset game
		Button resetBtn = new Button();
		resetBtn.setText("Reset");
		resetBtn.setFont(new Font(24));
		resetBtn.setStyle("-fx-background-color: #999999");

		// Button to switch game mode (1v1 -> CPU)
		Button modeBtn = new Button();
		modeBtn.setText("1v1");
		modeBtn.setFont(new Font(24));
		modeBtn.setAlignment(Pos.CENTER_RIGHT);
		modeBtn.setStyle("-fx-background-color: #999999");

		VBox screen = new VBox(20);
		screen.setAlignment(Pos.CENTER);
		screen.setStyle("-fx-background-color: #0000FF;");
		HBox columnSelector = new HBox(5);
		// mBtns = "menu" buttons
		HBox mBtns = new HBox(WIDTH - 200 - resetBtn.getWidth() - modeBtn.getWidth());
		columnSelector.setAlignment(Pos.CENTER);
		mBtns.setAlignment(Pos.CENTER);

		FancyButton[] selectors = new FancyButton[NUM_COLUMNS]; // 7 buttons

		mBtns.getChildren().addAll(resetBtn, modeBtn);

		// buttons for selectors
		for (int i = 0; i < selectors.length; i++) {
			selectors[i] = new FancyButton(i + 1);
			selectors[i].setText(String.valueOf(i + 1));
			selectors[i].setFont(new Font(24));
			selectors[i].setTextAlignment(TextAlignment.CENTER);
			selectors[i].setStyle("-fx-background-color: #999999");
			selectors[i].setMinSize(WIDTH / NUM_COLUMNS - 7, WIDTH / NUM_COLUMNS - 7);

			// actions when selectors are clicked
			selectors[i].setOnAction(e -> {
				int col = ((FancyButton) e.getSource()).getColumn();
				// run conditions as long as board is not full and less than 42 turns
				if (!board.isFull(col) && board.getTurn() <= 42) {
					// two separate run conditions (1v1 vs cpu mode)
					if (aiMode == false) {
						// place piece add turn
						board.placePiece(col, player);
						board.addTurn();
					} else if (aiMode == true) {
						board.placePiece(col, player);
						board.addTurn();
						// check winner before ai places piece
						winner = board.isWinner(player);

						if (!winner) {
							// CPU "turn"
							switchUser(); // ai will now take place of p2
							col = (int) Math.floor(Math.random() * (7 - 1 + 1) + 1); // generate random column for ai to
																						// place in
							board.placePiece(col, player);
							board.addTurn();
						}

					}
					// put information on board
					updateStuff(board, locations);

					// Check for winners
					winner = board.isWinner(CellState.P1) || board.isWinner(CellState.P2);

					// update board in driver
					board.display();

					// if there is a winner remove selectors and display win message
					if (winner) {
						screen.getChildren().add(winTitle);
						screen.getChildren().remove(columnSelector);

						// win message based off of which player wins
						if (player == CellState.P1) {
							winTitle.setText("Player 1 won");
						} else if (player == CellState.P2) {
							winTitle.setText("Player 2 won");
						}
					}

					switchUser();

				}
				// if there are 42 turns the board is not full and if there are no winners it is
				// a tie
				if (board.getTurn() == 42) {
					screen.getChildren().add(tieTitle);
					screen.getChildren().remove(columnSelector);
				}
			});

			columnSelector.getChildren().add(selectors[i]);
		}
		// button to reset app
		resetBtn.setOnAction(e -> {
			System.out.println("Restarting app!");

			// close and rerun stage
			stage.close();

			// add runnable to event queue
			Platform.runLater(() -> {
				try {
					new GUIDriver().start(new Stage());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});
		});

		// switch from 1v1 mode to CPU mode
		modeBtn.setOnAction(e -> {
			if (aiMode == false) {
				aiMode = true;
				modeBtn.setText("CPU");
			} else if (aiMode == true) {
				aiMode = false;
				modeBtn.setText("1v1");
			}

		});

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);

		for (int r = 0; r < NUM_ROWS; r++) {
			for (int c = 0; c < NUM_COLUMNS; c++) {
				// Create a Button and add it to the grid
				Button button = new Button();
				Circle circle = new Circle(24);

				// set shape of pieces as circles
				// as is done in connect 4
				button.setShape(circle);
				button.setFont(new Font(24));

				button.setMinSize(WIDTH / NUM_COLUMNS - 7, WIDTH / NUM_COLUMNS - 7);

				// set location
				locations[r][c] = button;

				grid.setHgap(5);
				grid.setVgap(5);
				grid.add(button, c, r);

			}
		}

		// Add the selector buttons (HBox) to the screen VBox
		screen.getChildren().add(columnSelector);
		screen.getChildren().add(grid);
		screen.getChildren().add(mBtns);
		// screen.getChildren().add(menu);

		Scene scene = new Scene(screen, WIDTH, HEIGHT);

		// Add Scene to stage
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}

package com.MalikConnectFour;

import javafx.scene.control.Button;

public class FancyButton extends Button {
	private int column;

	FancyButton(int col) {
		super();
		column = col;
	}

	public int getColumn() {
		return column;
	}

}

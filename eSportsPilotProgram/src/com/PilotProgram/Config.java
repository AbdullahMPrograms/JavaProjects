package com.PilotProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Config {
	static int x = 0;
	static int y = 0;
	static int length = 0;
	static int width = 0;
	static int r = 0;
	static int g = 0;
	static int b = 0;

	public static void readConfig() throws Exception {
		// list that holds strings of a file
		List<String> listOfStrings = new ArrayList<String>();

		// load data from file
		BufferedReader bf = new BufferedReader(new FileReader("cfg" + Game.getGameInfo() + ".cfg"));

		// read entire line as string
		String line = bf.readLine();

		// checking for end of file
		while (line != null) {
			listOfStrings.add(line);
			line = bf.readLine();
		}

		// closing buffer reader object
		bf.close();

		// storing the data in arraylist to array
		String[] vars = listOfStrings.toArray(new String[0]);

		x = Integer.parseInt(vars[1]);
		y = Integer.parseInt(vars[3]);
		length = Integer.parseInt(vars[5]);
		width = Integer.parseInt(vars[7]);
		r = Integer.parseInt(vars[9]);
		g = Integer.parseInt(vars[11]);
		b = Integer.parseInt(vars[13]);
	}

	public static int getX() {
		return x;
	}

	public static int getY() {
		return y;
	}

	public static int getLength() {
		return length;
	}

	public static int getWidth() {
		return width;
	}

	public static int getR() {
		return r;
	}

	public static int getG() {
		return g;
	}

	public static int getB() {
		return b;
	}

}
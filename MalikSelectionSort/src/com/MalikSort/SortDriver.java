package com.MalikSort;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * User interface for Sorting Analysis application
 * 
 * @author Abdullah Malik
 *
 */

public class SortDriver {
	public static void main(String[] args) {
		System.out.println("Welcome to the Malik Sorting Analysis Program®");

		// obtain scanner input
		@SuppressWarnings("resource") // suppress scanner not closed
		Scanner in = new Scanner(System.in);
		int numsLength = 0;

		boolean loop = false;
		boolean inboundInput = false;
		while (!loop) {
			while (!inboundInput) {
				System.out.println("How much data should be sorted (-1 for predefined arrays)");
				// assign length of numbers to be sorted from user input
				numsLength = in.nextInt();
				// make sure menu select input is actually in bounds, loop menu until it is
				if (numsLength < -1 || numsLength == 0) {
					System.out.println("Input out of bounds");
				} else {
					inboundInput = true;
				}
			}

			if (numsLength > 0) {
				// let user know data is being sorted
				System.out.println("Sorting Data...");
				// get current time at start of sorting in ms
				long sortStartTime = System.currentTimeMillis();
				int[] unsortedNumbers = generateRandomArray(numsLength);
				@SuppressWarnings("unused")
				// run sorting algorithm using numsLength in random order
				int[] sortedNumbers = Sorts.selectionSort(unsortedNumbers);

				System.out.println("Your array contains " + numsLength + " items");
				// Output time taken to complete sorting in ms
				System.out.println(
						"Total time to sort the data was " + (System.currentTimeMillis() - sortStartTime) + " ms");
			}
			// run code segment for sort and time of sort for predefined arrays
			if (numsLength == -1) {
				boolean renameLoop = false;
				String fileName = "results.csv";
				int numChoice = 0;
				String directory = fileName;
				// rename loop so if the user chooses to rename the file the code segment will
				// be run again but with fileName to the users taste
				while (!renameLoop) {
					inboundInput = false;
					while (!inboundInput) {
						// ask user if they would like to export results.csv to the default directory or
						// if they would like to input their own directory
						System.out.println("*********MENU*********\r\n" + "Current Directory: " + "EclipseProject\\\r\n"
								+ "Current File Name: " + fileName + "\r\n" + "1 - Export File to Default Directory\r\n"
								+ "2 - Input Directory\r\n" + "3 - Rename File\r\n");
						System.out.println("Option: ");
						numChoice = in.nextInt();
						// make sure menu select input is actually in bounds, loop menu until it is
						if (numChoice > 3 || numChoice < 1) {
							System.out.println("Input out of bounds");
						} else {
							inboundInput = true;
						}
					}

					// export csv to default directory
					if (numChoice == 1) {
						System.out.println("Exporting file to default directory: EclipseProject\\" + fileName + "...");
						renameLoop = true;
					}
					// prompt user for desired path and export csv to desired path
					if (numChoice == 2) {
						in.nextLine();
						System.out.println("Input Desired Path to File: ");
						String desiredPathToFile = in.nextLine();
						System.out
								.println("Exporting file to directory: " + desiredPathToFile + "\\" + fileName + "...");
						directory = desiredPathToFile + "\\" + fileName;
						renameLoop = true;
					}
					if (numChoice == 3) {
						in.nextLine();
						System.out.println("Input Desired Name of File: ");
						fileName = in.nextLine();
					}
				}

				File inFile = new File(directory);
				try {
					try (FileWriter out = new FileWriter(inFile)) {
						int[] subArray = { 10000, 20000, 40000, 80000, 160000 };
						// get current time at start of sorting in ms
						long sortStartTime = System.currentTimeMillis();
						// run sorting algorithm multiple times for the amount of predefined arrays
						for (int i = 0; i < subArray.length; i++) {
							int[] numbers = generateRandomArray(subArray[i]);
							Sorts.selectionSort(numbers);
							out.write(numbers.length + ", " + (System.currentTimeMillis() - sortStartTime) + "\n");
						}
						// close file
						out.flush();
					}
					// let user know csv file was generated
					System.out.println("File: " + inFile + " was generated");

				} catch (IOException e) {
					// catch invalid input or invalid output has occurrence and let user know
					System.out.println("invalid input or invalid output has occurred.");
				}
			}
			// once code has run its course prompt user to exit the program
			boolean exit = false;
			// check if input is in bounds
			while (!exit) {
				System.out.println("3 - Exit Program");
				System.out.print("Option: ");
				if (in.nextInt() != 3) {
					System.out.println("Input out of bounds");
				} else {
					loop = true;
					System.out.println("Exiting Program...");
					// ASCII art of my logo :)
					System.out.println(",.................................................\r\n"
							+ "..................................................\r\n"
							+ "..................................................\r\n"
							+ "................................///...............\r\n"
							+ "............................./*.**//..............\r\n"
							+ ".....................,//.,//,.....//..............\r\n"
							+ ".................,///*/*/.*/..../*/*..............\r\n"
							+ "........**************//,......//,..,/,...........\r\n"
							+ ".........****,.*..*****,..........,,**............\r\n"
							+ "...........,****,.*******.......***...............\r\n"
							+ "....................***,,*../..,**................\r\n"
							+ "...................,********,..****...............\r\n"
							+ ".....................,*..,.**.*,***...............\r\n"
							+ ".........................,*******,*...............\r\n"
							+ "........................*..,***,*.................\r\n"
							+ "........................,*,,,**...................\r\n"
							+ ".........................,,,,.....................\r\n"
							+ "........................,,,.......................\r\n"
							+ "..................................................\r\n"
							+ "..................................................\r\n" + "");
					// close program
					System.exit(0);
				}
			}
		}
	}

	/**
	 * randomly generated numsLength amount of numbers
	 * 
	 * @param n
	 * @return
	 */
	public static int[] generateRandomArray(int n) {
		int[] data = new int[n];

		Random rand = new Random();
		for (int i = 0; i < data.length; i++) {
			data[i] = rand.nextInt(Integer.MAX_VALUE);
		}
		return data;
	}
}

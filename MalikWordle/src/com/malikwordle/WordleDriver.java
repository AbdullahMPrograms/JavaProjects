package com.malikwordle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class WordleDriver {

	public static void main(String[] args) {

		// Obtain the list of words
		ArrayList<String> words = new ArrayList<>();
		loadWordList(words);

		// Display total number of words
		System.out.println("I just loaded " + words.size() + " words.");

		// Ask user for length of words - challenge level
		Scanner in = new Scanner(System.in);
		System.out.println("How many letters? ");
		int numLetters = in.nextInt();
		in.nextLine();

		// make a new list
		ArrayList<String> revisedWords = generateWordList(words, numLetters);

		// Randomly select a word - index between 0 and last index
		Random rand = new Random();

		int location = rand.nextInt(revisedWords.size());
		String targetWord = revisedWords.get(location).toUpperCase();
		System.out.println(targetWord); // this for debugging (prints target word)

		int numGuess = 6;
		char alphabet[] = { 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K',
				'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M' };
		// main computation
		for (int i = 0; i <= (numGuess - 1); i++) {
			String guess = "";
			boolean valid = false;
			// determines if inputted guess is proper length
			while (!valid) {
				System.out.println("Guess " + (i + 1) + ":");
				guess = in.nextLine();
				if (guess.length() != numLetters) {
					System.out.println("Incorrect length!");
				} else {
					valid = true;
					guess = guess.toUpperCase();
				}
			}
			// checks if "guess" exists in revised words derived from text dictionary
			if (revisedWords.contains(guess)) {
				// all these if statements are just for the answer and post game feedback
				if (i == 0 && (guess.equals(targetWord))) {
					System.out.println("Genius!");
					System.out.print("You got it right!" + "\n"); // game end
					char[] answer = checkInput(numLetters, targetWord, guess);
					System.out.println(Arrays.toString(answer));
					break;
				}
				if (i == 1 && (guess.equals(targetWord))) {
					System.out.println("Magnificent!");
					System.out.print("You got it right!" + "\n"); // game end
					char[] answer = checkInput(numLetters, targetWord, guess);
					System.out.println(Arrays.toString(answer));
					break;
				}
				if (i == 2 && (guess.equals(targetWord))) {
					System.out.println("Impressive!");
					System.out.print("You got it right!" + "\n"); // game end
					char[] answer = checkInput(numLetters, targetWord, guess);
					System.out.println(Arrays.toString(answer));
					break;
				}
				if (i == 3 && (guess.equals(targetWord))) {
					System.out.println("Splendid!");
					System.out.print("You got it right!" + "\n"); // game end
					char[] answer = checkInput(numLetters, targetWord, guess);
					System.out.println(Arrays.toString(answer));
					break;
				}
				if (i == 4 && (guess.equals(targetWord))) {
					System.out.println("Great!");
					System.out.print("You got it right!" + "\n"); // game end
					char[] answer = checkInput(numLetters, targetWord, guess);
					System.out.println(Arrays.toString(answer));
					break;
				}
				if (i == 5 && (guess.equals(targetWord))) {
					System.out.println("Phew!");
					System.out.print("You got it right!" + "\n"); // game end
					char[] answer = checkInput(numLetters, targetWord, guess);
					System.out.println(Arrays.toString(answer));
					break;
				}
				if (i == 5) {
					System.out.println("Better luck next time :("); // game end
					char[] answer = checkInput(numLetters, targetWord, guess);
					System.out.println(Arrays.toString(answer));
					break;
				} else {
					char[] answer = checkInput(numLetters, targetWord, guess);
					System.out.println(Arrays.toString(answer));
					alphabet = remainingLetters(guess, answer, alphabet);
					// prints out the alphabet char
					System.out.println((Arrays.toString(alphabet).substring(1, 30)));
					System.out.println((Arrays.toString(alphabet).substring(31, 57)));
					System.out.println((Arrays.toString(alphabet).substring(58, 77)));
				}
			} else {
				System.out.println("This word is not in the dictionary.");
				i = i - 1;
			}

		}
		// print target word when not guessed at the end of the game
		System.out.println("The Word was: " + (targetWord));
	}

	/**
	 * Compares guessed word and target word to check if the characters of both are
	 * equal
	 * 
	 * @param numLetters
	 * @param targetWord
	 * @param guess
	 * @return
	 */
	private static char[] checkInput(int numLetters, String targetWord, String guess) {
		char guessLetters[] = guess.toCharArray();
		char letters[] = targetWord.toCharArray();
		char answerIndex[] = new char[numLetters];

		for (int i = 0; i <= (numLetters - 1); i++) {
			// if letters are the same "*"
			if (guessLetters[i] == letters[i]) {
				answerIndex[i] = '*';
			} else if (targetWord.contains(String.valueOf(guessLetters[i]))) {
				answerIndex[i] = '~';
			} else {
				answerIndex[i] = '-'; // letter does not exist in target word
			}
		}

		return answerIndex;
	}

	/**
	 * Generate revised words based on number of characters selected for the game
	 * 
	 * @param words
	 * @param wordSize
	 * @return
	 */
	private static ArrayList<String> generateWordList(ArrayList<String> words, int wordSize) {
		ArrayList<String> newWords = new ArrayList<>();
		for (String word : words)
			if (word.length() == wordSize) {
				newWords.add(word);
			}
		return newWords;
	}

	/**
	 * Load "words.txt" as dictionary for the game
	 * 
	 * @param words
	 */
	private static void loadWordList(ArrayList<String> words) {
		File f = new File("words.txt");

		try {
			Scanner inFile = new Scanner(f);
			while (inFile.hasNextLine()) {
				words.add(inFile.nextLine());
			}
			inFile.close();

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Removes letters from available alphabet if those letters are not present in
	 * target word
	 * 
	 * @param guess
	 * @param index
	 * @param alphabet
	 * @return
	 */
	private static char[] remainingLetters(String guess, char[] index, char[] alphabet) {
		char guessLetters[] = guess.toCharArray();
		for (int i = 0; i < index.length; i++) {
			// if guessed letter does not exist in target word
			if (index[i] == '-') {
				for (int z = 0; z < alphabet.length; z++) {
					if (guessLetters[i] == alphabet[z]) {
						alphabet[z] = '-'; // set char alphabet to strike out that incorrect letter

					}
				}
			}
		}
		return alphabet;
	}

}
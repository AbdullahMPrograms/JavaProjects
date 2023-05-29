package com.MalikBookReview;

import java.util.Scanner;

/**
 * User interface for book review application
 * 
 * @author Abdullah Malik
 *
 */
public class BookDriver {

	public static void main(String[] args) {

		Bookshelf shelf = new Bookshelf();

		// Obtain scanner input
		@SuppressWarnings("resource") // eclipse recommended this lmao gets rid of scanner not closed though
		Scanner in = new Scanner(System.in);
		int numChoice = 0;
		// Redirect menu choice
		boolean loop = false;
		boolean inboundInput;
		while (!loop) {
			int ISBN = 0;
			inboundInput = false;
			// make sure menu select input is actually in bounds, loop menu until it is
			while (!inboundInput) {
				// Print menu choices
				System.out.println("*********MENU*********\r\n" + "1 - Display the contents of the BookShelf\r\n"
						+ "2 - Add a book\r\n" + "3 - Review a book\r\n" + "4 - Remove a book\r\n"
						+ "5 - Display the reviews for a Book\r\n" + "6 - Quit\r\n");
				System.out.println("Option: ");
				numChoice = in.nextInt();
				in.nextLine();
				if (numChoice > 6 || numChoice < 1) {
					System.out.println("Input out of bounds");
				} else {
					inboundInput = true;
				}
			}

			if (numChoice == 1) {
				shelf.displayShelf();
			}

			if (numChoice == 2) {
				// store relevant data points regarding book in variables
				System.out.println("Input Author Name: ");
				String author = in.nextLine();
				System.out.println("Input Book Name: ");
				String title = in.nextLine();
				System.out.println("Input ISBN Number: ");
				ISBN = in.nextInt();
				// assign object Book newBook the above data points
				Book newBook = new Book(author, ISBN, title);
				// check if duplicate book is attempting to be added
				if (shelf.getBookUsingISBN(ISBN) != null) {
					System.out.println("Book already exists in the Bookshelf");
				} else {
					shelf.addBook(newBook);
				}
			}

			if (numChoice == 3) {
				String review = null;
				int rating = 0;
				/*
				 * this below segment is used a couple times throughout the program as it
				 * basically makes sure that the following code will only run if books are in
				 * the bookshelf otherwise there is no point in prompting the user for anything
				 */

				if (shelf.isEmpty()) {
					shelf.displayShelf();
				} else {
					shelf.displayShelf();
					System.out.println("Select book using IBSN: ");
					ISBN = in.nextInt();
					in.nextLine();
					System.out.println("Name of the Reviewer: ");
					String nameReviewer = in.nextLine();
					// make sure input is in bound for review rating
					boolean checkInput = false;
					while (!checkInput) {
						System.out.println("Rating out of 5: ");
						int temp = in.nextInt();
						in.nextLine();
						if (temp > 5 || temp < 1) {
							System.out.println("Input out of bounds");
						} else {
							rating = temp;
							checkInput = true;
						}
					}
					System.out.println("Would you like to add a comment? ");
					System.out.println("Input \"Yes\" to add a comment");
					if (in.nextLine().equalsIgnoreCase("yes")) {
						System.out.println("Comment: ");
						review = in.nextLine();
					} else {
						review = "";
					}

					Book b = shelf.getBookUsingISBN(ISBN);
					b.addReview(nameReviewer, rating, review);
				}
			}

			if (numChoice == 4) {
				if (shelf.isEmpty()) {
					shelf.displayShelf();
				} else {
					shelf.displayShelf();
					System.out.println("What is the ISBN: ");
					ISBN = in.nextInt();
					Book b = new Book("", ISBN, "");
					// check if book exists in shelf before removal
					if (shelf.exists(b)) {
						System.out.println("Book with ISBN: " + ISBN + " found and removed");
						shelf.removeBook(b);
					} else {
						System.out.println("Book not found ");
					}
				}
			}

			if (numChoice == 5) {
				if (shelf.isEmpty()) {
					shelf.displayShelf();
				} else {
					shelf.displayShelf();

					System.out.println("What is the ISBN: ");
					ISBN = in.nextInt();
					Book b = shelf.getBookUsingISBN(ISBN);
					if (b.isEmpty()) {
						System.out.println("There are no reviews for book ISBN: " + ISBN);
					} else {
						System.out.println("Overall Rating: " + String.format("%.2f", b.computeRating()));
						b.displayReviews(b);
					}

				}
			}

			if (numChoice == 6) {
				loop = true;
				System.out.println("Exiting Program...");
				System.exit(0);
			}

			boolean input = false;
			while (!input) {
				System.out.println("7 - Return to Menu ");
				System.out.print("Option: ");
				if (in.nextInt() != 7) {
					System.out.println("Input out of bounds");
				} else {
					input = true;
				}
			}
		}
	}
}
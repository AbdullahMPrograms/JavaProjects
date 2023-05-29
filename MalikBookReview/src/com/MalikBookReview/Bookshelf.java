package com.MalikBookReview;

import java.util.ArrayList;
import java.util.Collections;

public class Bookshelf {
	private ArrayList<Book> books;

	Bookshelf() {
		books = new ArrayList<>();
	}

	/**
	 * adds book as well as sorts books via ISBN
	 * 
	 * @param newBook
	 */
	public void addBook(Book newBook) {
		books.add(newBook);
		Collections.sort(books);
	}

	/**
	 * Displays books in bookshelf as well as checks to see if books exist in the
	 * bookshelf or not also adds book number for printing after books are sorted
	 */
	public void displayShelf() {
		// check if shelf is empty or not
		if (books.isEmpty()) {
			System.out.println("There are no books in the bookshelf");
		} else {
			System.out.println("There are " + books.size() + " books in the bookshelf");
		}

		for (int i = 0; i <= (books.size() - 1);) {
			for (Book b : books) {
				System.out.print((i + 1) + ". " + b + "\n"); // Adds #. for the books so they can be cataloged
																// numerically when sorted
				i++;
			}
		}

	}

	/**
	 * check to see if book already exists in the shelf
	 * 
	 * @param newBook
	 * @return
	 */
	public boolean exists(Book newBook) {
		if (books.indexOf(newBook) == -1) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * removes book
	 * 
	 * @param newBook
	 */
	public void removeBook(Book newBook) {
		books.remove(newBook);
	}

	/**
	 * Compare inputed book to existing book in shelf via ISBN
	 * 
	 * @param ISBN
	 * @return
	 */
	public Book getBookUsingISBN(int ISBN) {
		Book obj = null;
		for (Book b : books) {
			if (b.getISBN() == ISBN) {
				obj = b;
			}
		}
		return obj;
	}

	/**
	 * returns whether or not there are any books
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		if (books.isEmpty()) {
			return true;
		}
		return false;
	}
}

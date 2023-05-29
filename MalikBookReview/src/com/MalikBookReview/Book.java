package com.MalikBookReview;

import java.util.ArrayList;

public class Book implements Comparable<Book> {
	private String Author;
	private int ISBN;
	private String Title;

	private ArrayList<BookReview> reviews;

	/**
	 * assigns data points to Book with through user input
	 * 
	 * @param NameA
	 * @param Number
	 * @param NameB
	 */
	Book(String NameA, int Number, String NameB) {
		Author = NameA;
		ISBN = Number;
		Title = NameB;
		reviews = new ArrayList<>();
	}

	/**
	 * gets ISBN
	 * 
	 * @return
	 */
	public int getISBN() {
		return ISBN;
	}

	/**
	 * gets reviews
	 * 
	 * @return
	 */
	public ArrayList<BookReview> getReviews() {
		return reviews;
	}

	/**
	 * calculate average for book review rating
	 * 
	 * @return
	 */
	public double computeRating() {
		double rating = 0;
		for (BookReview b : reviews) {
			rating = rating + b.returnRating();
		}
		rating = rating / reviews.size();
		return rating;

	}

	/**
	 * used to sort book numerically via ISBN
	 */
	@Override
	public int compareTo(Book b) {
		if (b.getISBN() < getISBN()) {
			return 1;
		}
		if (b.getISBN() > getISBN()) {
			return -1;
		}
		return 0;
	}

	/**
	 * compared ISBN of inputed book against bookshelf to see if any other books
	 * with the same ISBN exist (we dont want that)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Book) {
			Book b = (Book) obj;
			if (ISBN == (b.getISBN())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * displays formatted values for books in shelf
	 */
	@Override
	public String toString() {
		return String.format("ISBN: %d  Title: %s  Author : %s", ISBN, Title, Author);
	}

	/**
	 * 
	 * Add review to Book b
	 * 
	 * @param nameReviewer
	 * @param rating
	 * @param review
	 */
	public void addReview(String nameReviewer, int rating, String review) {
		BookReview b = new BookReview(nameReviewer, rating, review);
		reviews.add(b);
	}

	/**
	 * check to see if book ISBN has any reviews
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		if (reviews.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * displays reviews
	 * 
	 * @param b
	 */
	public void displayReviews(Book b) {
		for (BookReview reviews : b.getReviews()) {
			System.out.println(reviews.toString());
		}
	}

}

package com.MalikBookReview;

public class BookReview {
	private String Name;
	private int Rating;
	private String Review;

	/**
	 * Retrieves data points from input via user and assigns it to a review object
	 * review object values are then assigned to object
	 * 
	 * @param nameReviewer
	 * @param rating
	 * @param review
	 */
	BookReview(String nameReviewer, int rating, String review) {
		Name = nameReviewer;
		Rating = rating;
		Review = review;
	}

	/**
	 * Put reviews into formatted string
	 * 
	 * @return
	 */
	@Override
	public String toString() {
		return String.format("Name: %s  Rating: %d  Review: %s", Name, Rating, Review);
	}

	/**
	 * returns rating
	 * 
	 * @return
	 */
	public int returnRating() {
		return Rating;
	}
}

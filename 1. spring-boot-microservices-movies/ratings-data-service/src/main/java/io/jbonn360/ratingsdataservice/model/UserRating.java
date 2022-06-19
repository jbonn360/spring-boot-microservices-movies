package io.jbonn360.ratingsdataservice.model;

public class UserRating {
	private int userId;
	private int rating;
	
	public UserRating(int userId, int rating) {
		this.userId = userId;
		this.rating = rating;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
}

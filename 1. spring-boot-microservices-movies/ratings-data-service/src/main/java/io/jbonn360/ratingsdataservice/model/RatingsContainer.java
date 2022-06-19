package io.jbonn360.ratingsdataservice.model;

import java.util.List;

public class RatingsContainer<T> {
	private List<T> ratings;
	
	public RatingsContainer(List<T> ratings) {
		this.ratings = ratings;
	}

	public List<T> getRatings() {
		return ratings;
	}
}

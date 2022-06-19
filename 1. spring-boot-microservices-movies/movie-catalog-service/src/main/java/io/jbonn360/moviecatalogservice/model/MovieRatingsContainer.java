package io.jbonn360.moviecatalogservice.model;

import java.util.List;

public class MovieRatingsContainer {
	private List<MovieRating> ratings;
	
	public MovieRatingsContainer() { }
 	
	public MovieRatingsContainer(List<MovieRating> ratings) {
		this.ratings = ratings;
	}
	
	public List<MovieRating> getRatings() {
		return ratings;
	}
}

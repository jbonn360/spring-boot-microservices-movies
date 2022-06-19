package io.jbonn360.moviecatalogservice.model;

import java.util.List;

public class UserRatingsContainer {
	private List<UserRating> ratings;
	
	public UserRatingsContainer() { }
 	
	public UserRatingsContainer(List<UserRating> ratings) {
		this.ratings = ratings;
	}
	
	public List<UserRating> getRatings() {
		return ratings;
	}
}

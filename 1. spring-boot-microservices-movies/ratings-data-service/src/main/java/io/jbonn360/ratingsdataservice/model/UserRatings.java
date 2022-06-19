package io.jbonn360.ratingsdataservice.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserRatings {
	private HashMap<Integer, List<MovieRating>> userRatings;

	public UserRatings() {
		userRatings = new HashMap<Integer, List<MovieRating>>();
	}

	public void addUserRatings(int userId, List<MovieRating> ratings) {
		userRatings.put(userId, ratings);
	}

	public List<MovieRating> getUserRatings(int userId) {
		return userRatings.get(userId);
	}

	public List<UserRating> getMovieRatings(int movieId) {
		final List<UserRating> result = new ArrayList<UserRating>();

		Optional<MovieRating> curRating = null;

		for (Map.Entry<Integer, List<MovieRating>> entry : userRatings.entrySet()) {
			curRating = entry.getValue().stream().filter(rating -> rating.getMovieId() == movieId).findFirst();

			if (curRating.isPresent())
				result.add(new UserRating(entry.getKey(), curRating.get().getRating()));
		}

		return result;
	}
}

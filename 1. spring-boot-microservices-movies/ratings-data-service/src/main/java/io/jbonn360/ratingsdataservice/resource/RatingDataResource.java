package io.jbonn360.ratingsdataservice.resource;

import java.util.Arrays;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jbonn360.ratingsdataservice.model.MovieRating;
import io.jbonn360.ratingsdataservice.model.RatingsContainer;
import io.jbonn360.ratingsdataservice.model.UserRating;
import io.jbonn360.ratingsdataservice.model.UserRatings;

@RestController
@RequestMapping("/ratingsdata")
public class RatingDataResource {
	private final UserRatings userRatings = new UserRatings();
	
	public RatingDataResource() {
		userRatings.addUserRatings(1, Arrays.asList(
				new MovieRating(1, 4), 		// Jurassic Park
				new MovieRating(2, 1), 		// Her
				new MovieRating(3, 5), 		// Saving Private Ryan
				new MovieRating(4, 9000)));	// Pulp Fiction
		
		userRatings.addUserRatings(2, Arrays.asList(
				new MovieRating(1, 3), 		// Jurassic Park
				new MovieRating(2, 7), 		// Her
				new MovieRating(3, 9), 		// Saving Private Ryan
				new MovieRating(4, 2)));	// Pulp Fiction
		
		userRatings.addUserRatings(3, Arrays.asList(
				new MovieRating(1, 2), 		// Jurassic Park
				new MovieRating(2, 1600), 		// Her
				new MovieRating(3, 9), 		// Saving Private Ryan
				new MovieRating(4, 900)));	// Pulp Fiction
	}
	


	@RequestMapping("/{movieId}")
	public RatingsContainer<UserRating> getMovieRatings(@PathVariable("movieId") final int movieId) {
		// return new Rating(movieId, 4);
		//return ratings.getUserRatings().stream().filter(movie -> movie.getMovieId() == movieId).findFirst()
		//		.orElse(null);		
		return new RatingsContainer<UserRating>(userRatings.getMovieRatings(movieId));
	}

	@RequestMapping("/users/{userId}")
	public RatingsContainer<MovieRating> getUserRatings(@PathVariable("userId") final int userId) {		
		return new RatingsContainer<MovieRating>(userRatings.getUserRatings(userId));
	}
}

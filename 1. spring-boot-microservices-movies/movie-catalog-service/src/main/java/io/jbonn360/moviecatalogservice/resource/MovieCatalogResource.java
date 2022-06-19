package io.jbonn360.moviecatalogservice.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.jbonn360.moviecatalogservice.model.CatalogItem;
import io.jbonn360.moviecatalogservice.model.Movie;
import io.jbonn360.moviecatalogservice.model.MovieCatalog;
import io.jbonn360.moviecatalogservice.model.MovieRating;
import io.jbonn360.moviecatalogservice.model.MovieRatingsContainer;
import io.jbonn360.moviecatalogservice.model.UserRatingsContainer;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
//	@Autowired
//	private WebClient.Builder webClientBuilder;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/{userId}")
	public MovieCatalog getCatalog(@PathVariable("userId") final int userId) {
		// get all rated movie id's
		final MovieRatingsContainer ratings = restTemplate
				.getForObject("http://ratings-data-service/ratingsdata/users/" + userId, MovieRatingsContainer.class);

		final List<CatalogItem> result = ratings.getRatings().stream().map(rating -> getCatalogItem(rating))
				.collect(Collectors.toList());

		// Never return a List of items in a JSON endpoint to preserve backward
		// compatibility (example adding a field)
		// and to reduce complexity when deserializing to Java object (to avoid usage of
		// ParameterizedType)
		return new MovieCatalog(result);
	}

	@RequestMapping("/movies/{movieId}")
	public UserRatingsContainer getUserRatings(@PathVariable("movieId") final int movieId) {
		final UserRatingsContainer ratings = restTemplate
				.getForObject("http://ratings-data-service/ratingsdata/" + movieId, UserRatingsContainer.class);
		
		return ratings;
	}

	private CatalogItem getCatalogItem(MovieRating rating) {
		final Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(),
				Movie.class);
		return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
	}

//	private CatalogItem getCatalogItem(Rating rating) {
//	Movie movie = webClientBuilder.build()
//			.get()
//			.uri("http://localhost:8082/movies/" + rating.getMovieId())
//			.retrieve()
//			.bodyToMono(Movie.class)
//			.block();
//
//	return new CatalogItem(movie.getName(), "Test", rating.getRating());
//}
}

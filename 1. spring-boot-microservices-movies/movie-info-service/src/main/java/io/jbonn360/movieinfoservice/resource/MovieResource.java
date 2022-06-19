package io.jbonn360.movieinfoservice.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jbonn360.movieinfoservice.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieResource {
	private List<Movie> movies = Arrays.asList(new Movie(1, "Jurassic Park", "Dinosaur Film"),
			new Movie(2, "Her", "Beta Male Entertainment"),
			new Movie(3, "Saving Private Ryan", "Honour, Strength, and Glory!"),
			new Movie(4, "Pulp Fiction", "Crime and Drama"));

	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable final int movieId) {
		return movies.stream().filter(movie -> movie.getMovieId() == movieId).findFirst().orElse(null);
	}

}

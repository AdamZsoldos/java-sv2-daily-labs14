package day02;

import java.util.ArrayList;
import java.util.List;

public class MovieService {

    private final List<Movie> movies = new ArrayList<>();

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> getMoviesFeaturingActor(String actorName) {
        return movies.stream()
                .filter(movie -> movie.getActors().stream()
                        .anyMatch(actor -> actor.equals(actorName))
                )
                .toList();
    }

    public int getLengthOfLongestMovie() {
        return movies.stream()
                .mapToInt(Movie::getLengthInMinutes)
                .max()
                .orElseThrow(() -> new IllegalStateException("Empty"));
    }
}

package day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {

    MovieService movieService = new MovieService();
    Movie m1 = new Movie("The Thing", 109, List.of("Kurt Russell", "Keith David", "Wilford Brimley"));
    Movie m2 = new Movie("Invasion of the Body Snatchers", 115, List.of("Donald Sutherland", "Brooke Adams", "Jeff Goldblum"));
    Movie m3 = new Movie("The Hateful Eight", 168, List.of("Samuel L. Jackson", "Kurt Russell", "Jennifer Jason Leigh"));

    @BeforeEach
    void setUp() {
        movieService.addMovie(m1);
        movieService.addMovie(m2);
        movieService.addMovie(m3);
    }

    @Test
    void testGetMoviesFeaturingActor() {
        assertEquals(List.of(m1, m3), movieService.getMoviesFeaturingActor("Kurt Russell"));
    }

    @Test
    void testGetLengthOfLongestMovie() {
        assertEquals(168, movieService.getLengthOfLongestMovie());
    }

    @Test
    void testGetLengthOfLongestMovieEmptyList() {
        Exception e = assertThrows(IllegalStateException.class, () -> new MovieService().getLengthOfLongestMovie());
        assertEquals("Empty", e.getMessage());
    }
}

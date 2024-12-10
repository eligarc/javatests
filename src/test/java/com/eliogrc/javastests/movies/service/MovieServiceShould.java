package com.eliogrc.javastests.movies.service;

import com.eliogrc.javastests.movies.data.MovieRepository;
import com.eliogrc.javastests.movies.model.Genre;
import com.eliogrc.javastests.movies.model.Movie;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MovieServiceShould {
    private MovieService movieService;

    @Before
    public void setUp() throws Exception {
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);

        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, Genre.ACTION),
                        new Movie(2, "Memento", 113, Genre.THRILLER),
                        new Movie(3, "There's Something About Marty", 119, Genre.COMEDY),
                        new Movie(4, "Super 8", 112, Genre.THRILLER),
                        new Movie(5, "Scream", 111, Genre.HORROR),
                        new Movie(6, "Home Alone", 103, Genre.COMEDY),
                        new Movie(7, "Matrix", 136, Genre.ACTION)
                )
        );

        movieService = new MovieService(movieRepository);
    }

    @Test
    public void return_movies_by_genre() {

        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);

        assertThat(getMovieIds(movies), is(Arrays.asList(3, 6)));
    }

    @Test
    public void return_movies_by_length() {
        Collection<Movie> movies = movieService.findMoviesByLength(119);

        assertThat(getMovieIds(movies), is(Arrays.asList(2,3,4,5,6)));

    }

    private static List<Integer> getMovieIds(Collection<Movie> movies) {
        List<Integer> movieIds = movies.stream().map(Movie::getId).collect(Collectors.toList());
        return movieIds;
    }
}
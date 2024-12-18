package com.eliogrc.javastests.movies.data;

import com.eliogrc.javastests.movies.model.Movie;

import java.util.Collection;

public interface MovieRepository {
    Movie findById(long id);

    Collection<Movie> findAll();

    void saveOrUpdate(Movie movie);
}

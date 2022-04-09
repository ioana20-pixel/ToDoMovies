package com.example.todomovies.data.repository;

import com.example.todomovies.data.api.MovieApi;
import com.example.todomovies.data.model.MoviesList;

import retrofit2.Call;

public class TvRepository {
    private static TvRepository instance = null;
    private final MovieApi api;

    private TvRepository(MovieApi api) {
        this.api = api;
    }

    public static TvRepository getInstance(MovieApi api) {
        if (instance == null)
            instance = new TvRepository(api);
        return instance;
    }

    public Call<MoviesList> getTvByCategory(String category) {
        return api.listOfMovies(category);
    }
}

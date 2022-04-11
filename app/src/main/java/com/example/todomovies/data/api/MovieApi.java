package com.example.todomovies.data.api;

import com.example.todomovies.data.model.MoviesList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MovieApi {

    @GET("tv/{category}")
    Call<MoviesList> listOfMovies(
            @Path("category") String category
    );
}

package com.example.todomovies.data.api;

import com.example.todomovies.data.model.TvDetailsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class TvDetailsApi {
    //https://api.themoviedb.org/3/tv/84958?api_key=3133b12095185ad24d14551d402e8a5c
    @GET("tv/{tv_id}")
    public Call<TvDetailsResponse> getMovieDetails(@Path("tv_id") int tvId) {
        return null;
    }
}

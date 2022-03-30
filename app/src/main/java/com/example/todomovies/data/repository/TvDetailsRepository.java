package com.example.todomovies.data.repository;

import com.example.todomovies.data.api.TvDetailsApi;
import com.example.todomovies.data.model.TvDetailsResponse;

import retrofit2.Call;

public class TvDetailsRepository {
    private static TvDetailsRepository instance = null;

    private final TvDetailsApi tvDetailsApi;

    private TvDetailsRepository(TvDetailsApi tvDetailsApi) {
        this.tvDetailsApi = tvDetailsApi;
    }

    public static TvDetailsRepository getInstance(TvDetailsApi tvDetailsApi) {
        if (instance == null)
            instance = new TvDetailsRepository(tvDetailsApi);

        return instance;
    }

    public Call<TvDetailsResponse> getTvDetails(int id) {
        return tvDetailsApi.getMovieDetails(id);
    }
}

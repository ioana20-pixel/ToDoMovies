package com.example.todomovies.data.api;

import com.example.todomovies.data.model.Configuration;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Config {
    @GET("configuration")
    Call<Configuration> getConfiguration();
}

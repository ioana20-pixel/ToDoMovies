package com.example.todomovies.utils;

import com.example.todomovies.data.api.ApiClient;
import com.example.todomovies.data.model.Configuration;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Constants {
    public final static String BASE_URL = "https://api.themoviedb.org/3/";
    public final static String API_KEY = "3133b12095185ad24d14551d402e8a5c";
    public static final String CATEGORY_POPULAR = "popular";
    public static String IMAGE_BASE_URL;
    public final static String CATEGORY_TOP_RATED = "top_rated";

    public static void setImageBaseUrl() {
        ApiClient.getConfigApi().getConfiguration().enqueue(new Callback<Configuration>() {
            @Override
            public void onResponse(@NotNull Call<Configuration> call, @NotNull Response<Configuration> response) {
                IMAGE_BASE_URL = response.body().getImages().getSecureBaseUrl() + response.body().getImages().getPosterSizes().get(5);
            }

            @Override
            public void onFailure(Call<Configuration> call, Throwable t) {
            }
        });
    }}

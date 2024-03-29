package com.example.todomovies.utils;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.todomovies.data.api.ApiClient;
import com.example.todomovies.data.repository.config.ConfigBackendRepository;
import com.example.todomovies.data.repository.config.TheMovieDbConfigRepository;

public class Constants {
    public final static String BASE_URL = "https://api.themoviedb.org/3/";
    public final static String API_KEY = "3133b12095185ad24d14551d402e8a5c";
    public static final String CATEGORY_POPULAR = "popular";
    public static String IMAGE_BASE_URL;
    public final static String CATEGORY_TOP_RATED = "top_rated";

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void setImageBaseUrl() {
        ConfigBackendRepository.getInstance().getConfig(configuration -> {
            if (configuration == null) {
                TheMovieDbConfigRepository.getInstance(ApiClient.getConfigApi()).getConfig(configuration1 ->
                        IMAGE_BASE_URL = configuration1.getImages().getSecureBaseUrl() + configuration1.getImages().getPosterSizes().get(5));
            } else
                IMAGE_BASE_URL = configuration.getImages().getSecureBaseUrl() + configuration.getImages().getPosterSizes().get(5);

        });
    }}

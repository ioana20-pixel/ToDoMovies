package com.example.todomovies.ui.details;

import com.example.todomovies.data.model.TvDetailsResponse;

import java.util.function.Consumer;

public interface TvDetailsRepository {
    void getTvDetails(int id, Consumer<TvDetailsResponse> consumer);

}

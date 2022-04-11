package com.example.todomovies.data.repository.towatch;

import com.example.todomovies.data.model.TvDetailsResponse;

import java.util.List;
import java.util.function.Consumer;

public interface ToWatchRepository {
    void insert(TvDetailsResponse result);
    void delete(TvDetailsResponse result);
    void getAll(Consumer<List<TvDetailsResponse>> consumer);
    void findById(int id, Consumer<TvDetailsResponse> consumer);
}

package com.example.todomovies.data.repository;

import com.example.todomovies.data.model.Result;

import java.util.List;
import java.util.function.Consumer;

public interface TvRepository {
    void getByCategory(String category, Consumer<List<Result>> consumer);

}

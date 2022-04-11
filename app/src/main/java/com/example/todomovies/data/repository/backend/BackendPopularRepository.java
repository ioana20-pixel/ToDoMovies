package com.example.todomovies.data.repository.backend;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.todomovies.data.model.Result;
import com.example.todomovies.data.repository.TvRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BackendPopularRepository implements TvRepository {
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void getByCategory(String category, Consumer<List<Result>> consumer) {

        consumer.accept(new ArrayList<>());
    }
}

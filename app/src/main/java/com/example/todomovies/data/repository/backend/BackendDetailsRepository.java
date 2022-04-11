package com.example.todomovies.data.repository.backend;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.todomovies.data.model.TvDetailsResponse;
import com.example.todomovies.ui.details.TvDetailsRepository;

import java.util.function.Consumer;

public class BackendDetailsRepository implements TvDetailsRepository {
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void getTvDetails(int id, Consumer<TvDetailsResponse> consumer) {

        consumer.accept(null);
    }
}

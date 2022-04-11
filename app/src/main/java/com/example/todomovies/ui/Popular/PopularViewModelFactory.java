package com.example.todomovies.ui.Popular;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.todomovies.data.repository.TvRepository;

public class PopularViewModelFactory implements ViewModelProvider.Factory {
    private final TvRepository tvRepository;
    private final TvRepository backendPopularRepository;
    public PopularViewModelFactory(TvRepository tvRepository, TvRepository backendPopularRepository) {
        this.tvRepository = tvRepository;
        this.backendPopularRepository=backendPopularRepository;
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(PopularViewModel.class))
            return (T) new PopularViewModel(tvRepository, backendPopularRepository);
        throw new IllegalArgumentException("Unknown View Model Class");
    }
}

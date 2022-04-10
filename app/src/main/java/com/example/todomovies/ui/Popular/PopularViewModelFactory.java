package com.example.todomovies.ui.Popular;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.todomovies.data.repository.TvRepository;

public class PopularViewModelFactory implements ViewModelProvider.Factory {
    private final TvRepository tvRepository;

    public PopularViewModelFactory(TvRepository tvRepository) { this.tvRepository = tvRepository; }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(PopularViewModel.class))
            return (T) new PopularViewModel(tvRepository);
        throw new IllegalArgumentException("Unknown View Model Class");
    }
}

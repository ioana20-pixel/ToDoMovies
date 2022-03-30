package com.example.todomovies.ui.details;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.todomovies.data.repository.TvDetailsRepository;

import org.jetbrains.annotations.NotNull;

public class DetailsViewModelFactory implements ViewModelProvider.Factory{
    private final TvDetailsRepository detailsRepository;
    private final int id;

    public DetailsViewModelFactory(TvDetailsRepository detailsRepository, int id) {
        this.detailsRepository = detailsRepository;
        this.id = id;
    }

    @NonNull
    @NotNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull @NotNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(DetailsViewModel.class))
            return (T) new DetailsViewModel(detailsRepository, id);

        throw new IllegalArgumentException("Unknown View Model Class");
    }
}
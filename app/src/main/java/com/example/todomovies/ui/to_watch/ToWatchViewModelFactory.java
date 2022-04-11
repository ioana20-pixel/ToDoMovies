package com.example.todomovies.ui.to_watch;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.todomovies.data.repository.towatch.ToWatchRepository;

public class ToWatchViewModelFactory implements ViewModelProvider.Factory {
    private final ToWatchRepository toWatchRepository;

    public ToWatchViewModelFactory(ToWatchRepository toWatchRepository){
        this.toWatchRepository = toWatchRepository;
    }

    @NonNull
    @Override
    public<T extends ViewModel> T create(@NonNull Class<T> modelClass){
        if (modelClass.isAssignableFrom(ToWatchViewModel.class))
            return (T) new ToWatchViewModel(toWatchRepository);
        throw new IllegalArgumentException("Unknown View Model Class");
    }
}

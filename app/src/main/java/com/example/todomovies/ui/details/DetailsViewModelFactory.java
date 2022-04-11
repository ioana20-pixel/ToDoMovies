package com.example.todomovies.ui.details;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.todomovies.data.repository.towatch.ToWatchRepository;
import com.example.todomovies.data.repository.towatch.ToWatchRoomRepository;

import org.jetbrains.annotations.NotNull;

public class DetailsViewModelFactory implements ViewModelProvider.Factory{
    private final TvDetailsRepository detailsRepository;
    private final ToWatchRepository toWatchRepository;
    private final TvDetailsRepository backendDetailsRepository;

    private final int id;

    public DetailsViewModelFactory(TvDetailsRepository detailsRepository, ToWatchRepository toWatchRepository, int id, TvDetailsRepository backendDetailsRepository) {
        this.detailsRepository = detailsRepository;
        this.toWatchRepository = toWatchRepository;
        this.backendDetailsRepository = backendDetailsRepository;

        this.id = id;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @NonNull
    @NotNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull @NotNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(DetailsViewModel.class))
            return (T) new DetailsViewModel(detailsRepository, toWatchRepository, id, backendDetailsRepository);

        throw new IllegalArgumentException("Unknown View Model Class");
    }
}

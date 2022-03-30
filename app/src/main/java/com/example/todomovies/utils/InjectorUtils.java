package com.example.todomovies.utils;

import com.example.todomovies.data.api.ApiClient;
import com.example.todomovies.data.repository.TvDetailsRepository;
import com.example.todomovies.ui.details.DetailsViewModelFactory;

public class InjectorUtils {
    private static InjectorUtils instance = null;

    private InjectorUtils() {
    }

    public static InjectorUtils getInstance() {
        if (instance == null)
            instance = new InjectorUtils();
        return instance;
    }

    public DetailsViewModelFactory provideDetailsViewModelFactory(int id) {
        TvDetailsRepository repository = TvDetailsRepository.getInstance(ApiClient.getTvDetailsApi());
        return new DetailsViewModelFactory(repository, id);
    }
}

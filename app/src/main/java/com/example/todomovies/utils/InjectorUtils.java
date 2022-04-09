package com.example.todomovies.utils;

import android.content.Context;

import com.example.todomovies.data.api.ApiClient;
import com.example.todomovies.data.repository.TvRepository;
import com.example.todomovies.data.repository.auth.FirebaseAuthRepository;
import com.example.todomovies.data.repository.ToWatchRepository;
import com.example.todomovies.data.repository.TvDetailsRepository;
import com.example.todomovies.data.repository.db.ToWatchDatabase;
import com.example.todomovies.login_screen.register.RegisterViewModelFactory;
import com.example.todomovies.ui.TopRated.TopRatedViewModelFactory;
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

    public DetailsViewModelFactory provideDetailsViewModelFactory(int id, Context context) {
        TvDetailsRepository tvDetailsRepository = TvDetailsRepository.getInstance(ApiClient.getTvDetailsApi());
        ToWatchRepository toWatchRepository= ToWatchRepository.getInstance(ToWatchDatabase.getInstance(context).toWatchDao());
        return new DetailsViewModelFactory(tvDetailsRepository, toWatchRepository, id);
    }

    public RegisterViewModelFactory provideRegisterViewModelFactory() {
        return new RegisterViewModelFactory(FirebaseAuthRepository.getInstance());
    }

    public TopRatedViewModelFactory provideTopRatedViewModelFactory() {
        return new TopRatedViewModelFactory(TvRepository.getInstance(ApiClient.getMovieApi()));
    }
}

package com.example.todomovies.utils;

import android.content.Context;

import com.example.todomovies.data.api.ApiClient;
import com.example.todomovies.data.repository.TvRetrofitRepository;
import com.example.todomovies.data.repository.auth.FirebaseAuthRepository;
import com.example.todomovies.data.repository.backend.BackendDetailsRepository;
import com.example.todomovies.data.repository.backend.BackendPopularRepository;
import com.example.todomovies.data.repository.backend.BackendTopRatedRepository;
import com.example.todomovies.data.repository.db.ToWatchDatabase;
import com.example.todomovies.data.repository.towatch.ToWatchRepository;
import com.example.todomovies.data.repository.towatch.ToWatchRoomRepository;
import com.example.todomovies.login_screen.register.RegisterViewModelFactory;
import com.example.todomovies.ui.Popular.PopularViewModelFactory;
import com.example.todomovies.ui.TopRated.TopRatedViewModelFactory;
import com.example.todomovies.ui.details.DetailsViewModelFactory;
import com.example.todomovies.ui.details.TvDetailsRetrofitRepository;
import com.example.todomovies.ui.to_watch.ToWatchViewModelFactory;

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
        TvDetailsRetrofitRepository tvDetailsRetrofitRepository = TvDetailsRetrofitRepository.getInstance(ApiClient.getTvDetailsApi());
        ToWatchRepository toWatchRoomRepository= ToWatchRoomRepository.getInstance(ToWatchDatabase.getInstance(context).toWatchDao());
        return new DetailsViewModelFactory(tvDetailsRetrofitRepository, toWatchRoomRepository, id, new BackendDetailsRepository()); //needs fixes
    }

    public RegisterViewModelFactory provideRegisterViewModelFactory() {
        return new RegisterViewModelFactory(FirebaseAuthRepository.getInstance());
    }

    public TopRatedViewModelFactory provideTopRatedViewModelFactory() {
        return new TopRatedViewModelFactory(TvRetrofitRepository.getInstance(ApiClient.getMovieApi()), new BackendTopRatedRepository());
    }

    public PopularViewModelFactory providePopularViewModelFactory() {
        return new PopularViewModelFactory(TvRetrofitRepository.getInstance(ApiClient.getMovieApi()), new BackendPopularRepository());
    }

    public ToWatchViewModelFactory provideToWatchViewModelFactory(Context context) {
        return new ToWatchViewModelFactory(ToWatchRoomRepository.getInstance(ToWatchDatabase.getInstance(context).toWatchDao()));
    }
}

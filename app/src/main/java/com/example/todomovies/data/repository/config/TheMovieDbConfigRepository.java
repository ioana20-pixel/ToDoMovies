package com.example.todomovies.data.repository.config;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.todomovies.data.api.ConfigApi;
import com.example.todomovies.data.model.Configuration;

import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TheMovieDbConfigRepository implements ConfigRepository{
    private static TheMovieDbConfigRepository instance = null;
    private final ConfigApi configApi;

    private TheMovieDbConfigRepository(ConfigApi configApi) {
        this.configApi = configApi;
    }

    public static TheMovieDbConfigRepository getInstance(ConfigApi configApi) {
        synchronized (TheMovieDbConfigRepository.class) {
            if (instance == null)
                instance = new TheMovieDbConfigRepository(configApi);
        }
        return instance;
    }

    @Override
    public void getConfig(Consumer<Configuration> consumer) {
        configApi.getConfiguration().enqueue(new Callback<Configuration>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(@NotNull Call<Configuration> call, @NotNull Response<Configuration> response) {
                consumer.accept(response.body());
            }

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onFailure(@NotNull Call<Configuration> call, @NotNull Throwable t) {
                consumer.accept(null);
            }
        });
    }
}

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

public class ConfigRetrofitRepository implements ConfigRepository{
    private static ConfigRetrofitRepository instance = null;
    private final ConfigApi configApi;

    private ConfigRetrofitRepository(ConfigApi configApi) {
        this.configApi = configApi;
    }

    public static ConfigRetrofitRepository getInstance(ConfigApi configApi) {
        if (instance == null)
            instance = new ConfigRetrofitRepository(configApi);
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

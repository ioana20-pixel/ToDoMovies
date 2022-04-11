package com.example.todomovies.data.repository.config;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.todomovies.data.model.Configuration;

import java.util.function.Consumer;

public class ConfigBackendRepository implements ConfigRepository{
    private static ConfigBackendRepository instance = null;

    private ConfigBackendRepository(){}

    public static ConfigBackendRepository getInstance() {
        if (instance == null)
            instance = new ConfigBackendRepository();
        return instance;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void getConfig(Consumer<Configuration> consumer) {
        //TODO implement method
        consumer.accept(null);
    }
}

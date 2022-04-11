package com.example.todomovies.data.repository.config;

import com.example.todomovies.data.model.Configuration;

import java.util.function.Consumer;

public interface ConfigRepository {
    void getConfig(Consumer<Configuration> consumer);

}

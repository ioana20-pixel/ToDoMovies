package com.example.todomovies.data.repository;

import com.example.todomovies.data.model.AuthState;

import java.util.function.Consumer;

public interface RemoteLoginRepository {
    void login(String email, String password, Consumer<AuthState> consumer);

    boolean isLogged();
}

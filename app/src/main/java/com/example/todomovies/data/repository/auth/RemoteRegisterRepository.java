package com.example.todomovies.data.repository.auth;

import com.google.firebase.auth.AuthResult;

import com.example.todomovies.data.model.AuthState;

import java.util.function.Consumer;

public interface RemoteRegisterRepository {
    void register(String email, String password, Consumer<AuthState> consumer);
}

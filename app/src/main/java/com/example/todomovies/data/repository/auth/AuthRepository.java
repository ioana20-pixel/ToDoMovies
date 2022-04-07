package com.example.todomovies.data.repository.auth;

import androidx.lifecycle.LiveData;

import com.example.todomovies.data.model.AuthState;

public interface AuthRepository {
    void register(String email, String password);
    void addAuthenticationSuccessListener(AuthenticationSuccessListener listener);
}

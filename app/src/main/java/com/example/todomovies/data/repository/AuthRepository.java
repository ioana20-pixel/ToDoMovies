package com.example.todomovies.data.repository;

import androidx.lifecycle.LiveData;

import com.example.todomovies.data.model.AuthState;

public interface AuthRepository {
    void register(String email, String password);
    LiveData<AuthState> getRegisterIsSuccessful();
}

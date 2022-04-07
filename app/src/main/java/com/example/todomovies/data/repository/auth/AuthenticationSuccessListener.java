package com.example.todomovies.data.repository.auth;

import com.example.todomovies.data.model.AuthState;

public interface AuthenticationSuccessListener {
    void onReceived(AuthState authState);

}

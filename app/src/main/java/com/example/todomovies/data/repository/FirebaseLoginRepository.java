package com.example.todomovies.data.repository;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.example.todomovies.data.model.AuthState;
import com.google.firebase.auth.FirebaseAuth;

import java.util.function.Consumer;

public class FirebaseLoginRepository implements RemoteLoginRepository{
    private FirebaseAuth auth;

    public FirebaseLoginRepository() {
        auth = FirebaseAuth.getInstance();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void login(String email, String password, Consumer<AuthState> consumer) {
        auth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener(
                        authResult -> consumer.accept(new AuthState(true)))
                .addOnFailureListener(e -> consumer.accept(new AuthState(e.getMessage())));

    }

    @Override
    public boolean isLogged() {
        if (auth.getCurrentUser() != null) {
            return true;
        } else {
            return false;
        }
    }
}

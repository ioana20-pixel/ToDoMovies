package com.example.todomovies.data.repository.auth;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.todomovies.data.model.AuthState;
import com.google.firebase.auth.FirebaseAuth;

public class FirebaseAuthRepository implements AuthRepository {
    private static FirebaseAuthRepository instance = null;
    private final FirebaseAuth firebaseAuth;
    private AuthenticationSuccessListener listener;

    private FirebaseAuthRepository() {
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public static FirebaseAuthRepository getInstance() {
        if (instance == null)
            instance = new FirebaseAuthRepository();
        return instance;
    }

    @Override
    public void register(String email, String password) {
        AuthState authState = new AuthState();
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener(authResult -> listener.onReceived(new AuthState(true)))
                .addOnFailureListener(e -> listener.onReceived(new AuthState(e.getMessage())));
    }

    @Override
    public void addAuthenticationSuccessListener(AuthenticationSuccessListener listener) {
        this.listener = listener;
    }
}

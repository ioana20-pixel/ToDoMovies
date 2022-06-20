package com.example.todomovies.data.repository.auth;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.todomovies.data.model.AuthState;
import com.google.firebase.auth.FirebaseAuth;

import java.util.function.Consumer;

public class FirebaseRegisterRepository implements RemoteRegisterRepository {
    private static FirebaseRegisterRepository instance = null;
    private final FirebaseAuth firebaseAuth;

    private FirebaseRegisterRepository() {
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public static FirebaseRegisterRepository getInstance() {
        if (instance == null)
            instance = new FirebaseRegisterRepository();
        return instance;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void register(String email, String password, Consumer<AuthState> consumer) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener(authResult -> consumer.accept(new AuthState(true)))
                .addOnFailureListener(e -> consumer.accept(new AuthState(e.getMessage())));
    }

}

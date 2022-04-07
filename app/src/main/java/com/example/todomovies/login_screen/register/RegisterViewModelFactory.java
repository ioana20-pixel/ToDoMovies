package com.example.todomovies.login_screen.register;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.todomovies.data.repository.AuthRepository;
import com.example.todomovies.data.repository.FirebaseAuthRepository;
import com.example.todomovies.ui.base.BaseViewModel;

import org.jetbrains.annotations.NotNull;

public class RegisterViewModelFactory extends BaseViewModel {
    private AuthRepository authRepository;

    public RegisterViewModelFactory(FirebaseAuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public RegisterViewModelFactory(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }
}

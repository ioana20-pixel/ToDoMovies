package com.example.todomovies.login_screen.register;

import com.example.todomovies.data.repository.FirebaseAuthRepository;
import com.example.todomovies.ui.base.BaseViewModel;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class RegisterViewModel extends BaseViewModel {
    private final FirebaseAuthRepository authRepository;

    public RegisterViewModel(FirebaseAuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public Task<AuthResult> register(String email, String password) {
        return authRepository.register(email, password);
    }
}

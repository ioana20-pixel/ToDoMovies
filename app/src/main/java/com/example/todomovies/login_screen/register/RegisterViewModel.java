package com.example.todomovies.login_screen.register;

import androidx.lifecycle.LiveData;

import com.example.todomovies.data.model.AuthState;
import com.example.todomovies.data.repository.AuthRepository;
import com.example.todomovies.data.repository.FirebaseAuthRepository;
import com.example.todomovies.ui.base.BaseViewModel;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class RegisterViewModel extends BaseViewModel {
    private final AuthRepository authRepository;
    public LiveData<AuthState> registerSuccess;

    public RegisterViewModel(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public void register(String email, String password) {
        authRepository.register(email, password);
        registerSuccess = authRepository.getRegisterIsSuccessful();
    }
}

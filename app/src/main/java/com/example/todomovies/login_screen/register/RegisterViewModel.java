package com.example.todomovies.login_screen.register;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.todomovies.data.model.AuthState;
import com.example.todomovies.data.repository.auth.AuthRepository;
import com.example.todomovies.ui.base.BaseViewModel;

public class RegisterViewModel extends BaseViewModel {
    private final AuthRepository authRepository;
    private final MutableLiveData<AuthState> _registerSuccess = new MutableLiveData<>();
    public LiveData<AuthState> registerSuccess = _registerSuccess;

    public RegisterViewModel(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public void register(String email, String password) {
        authRepository.register(email, password, _registerSuccess::postValue);
    }
}

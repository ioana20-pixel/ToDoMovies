package com.example.todomovies.login_screen.login;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.todomovies.data.repository.FirebaseLoginRepository;
import com.example.todomovies.login_screen.login.viewmodel.LoginViewModel;

public class LoginViewModelFactory implements ViewModelProvider.Factory {
    private final FirebaseLoginRepository userRepository;


    public LoginViewModelFactory( FirebaseLoginRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> viewModelClass) {
        if (viewModelClass.isAssignableFrom(LoginViewModel.class)) {
            //noinspection unchecked
            return (T) new LoginViewModel(userRepository);
        }
        throw new IllegalStateException("Unable to create " + viewModelClass.getName());
    }
}

package com.example.todomovies.login_screen.register;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.todomovies.data.repository.auth.FirebaseRegisterRepository;
import com.example.todomovies.data.repository.auth.RemoteRegisterRepository;

import org.jetbrains.annotations.NotNull;

public class RegisterViewModelFactory implements ViewModelProvider.Factory {
        private final RemoteRegisterRepository remoteRegisterRepository;

    public RegisterViewModelFactory(RemoteRegisterRepository remoteRegisterRepository) {
        this.remoteRegisterRepository = remoteRegisterRepository;
    }


    @NonNull
    @NotNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull @NotNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(RegisterViewModel.class))
            return (T) new RegisterViewModel(remoteRegisterRepository);
        throw new IllegalArgumentException("Unknown View Model Class");
    }
}

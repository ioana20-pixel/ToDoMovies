package com.example.todomovies.ui.base;

import androidx.annotation.NonNull;

public interface ViewModelComponent<VM extends BaseViewModel> {
    @NonNull
    VM createViewModel();
}

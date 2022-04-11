package com.example.todomovies.ui.to_watch;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.todomovies.data.model.TvDetailsResponse;
import com.example.todomovies.data.repository.towatch.ToWatchRepository;
import com.example.todomovies.ui.base.BaseViewModel;

import java.util.List;
import java.util.function.Consumer;

public class ToWatchViewModel extends BaseViewModel {
    private final ToWatchRepository toWatchRepository;

    private MutableLiveData<List<TvDetailsResponse>> _toWatchTvs = new MutableLiveData<>();
    public LiveData<List<TvDetailsResponse>> favTvs = _toWatchTvs;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public ToWatchViewModel(ToWatchRepository toWatchRepository){
        this.toWatchRepository = toWatchRepository;
        getToWatch();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void getToWatch(){
        toWatchRepository.getAll(tvDetailsResponses -> _toWatchTvs.postValue(tvDetailsResponses));
    }

    public void delete(TvDetailsResponse tvDetailsResponse) {
        toWatchRepository.delete(tvDetailsResponse);
    }
}

package com.example.todomovies.ui.TopRated;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.todomovies.data.model.MoviesList;
import com.example.todomovies.data.model.Result;
import com.example.todomovies.data.repository.TvRepository;
import com.example.todomovies.ui.base.BaseViewModel;
import com.example.todomovies.utils.Constants;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopRatedViewModel extends BaseViewModel {
    private final TvRepository tvRepository;

    private final MutableLiveData<List<Result>> _topRatedTvs = new MutableLiveData<>();
    public LiveData<List<Result>> topRatedTvs = _topRatedTvs;

    public TopRatedViewModel(TvRepository tvRepository) {
        this.tvRepository = tvRepository;
        getTopRated();
    }

    private void getTopRated() {
        tvRepository.getByCategory(Constants.CATEGORY_TOP_RATED, _topRatedTvs::postValue);
    }
}

package com.example.todomovies.ui.TopRated;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
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
import java.util.function.Consumer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopRatedViewModel extends BaseViewModel {
    private final TvRepository tvRepository;
    private final TvRepository backendTopRatedRepository;

    private final MutableLiveData<List<Result>> _topRatedTvs = new MutableLiveData<>();
    public LiveData<List<Result>> topRatedTvs = _topRatedTvs;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public TopRatedViewModel(TvRepository tvRepository, TvRepository backendTopRatedRepository) {
        this.tvRepository = tvRepository;
        this.backendTopRatedRepository=backendTopRatedRepository;
        getTopRated();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void getTopRated() {
        tvRepository.getByCategory(Constants.CATEGORY_TOP_RATED, new Consumer<List<Result>>() {
            @Override
            public void accept(List<Result> results) {
                if(results.isEmpty()){
                    tvRepository.getByCategory(Constants.CATEGORY_TOP_RATED, new Consumer<List<Result>>() {
                        @Override
                        public void accept(List<Result> results) {
                            _topRatedTvs.postValue(results);
                        }
                    });
                }else{
                    _topRatedTvs.postValue(results);
                }
            }
        });    }
}

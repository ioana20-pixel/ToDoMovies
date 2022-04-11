package com.example.todomovies.ui.Popular;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.todomovies.data.model.Result;
import com.example.todomovies.data.repository.TvRepository;
import com.example.todomovies.ui.base.BaseViewModel;
import com.example.todomovies.utils.Constants;

import java.util.List;
import java.util.function.Consumer;

public class PopularViewModel extends BaseViewModel {
    private final TvRepository tvRepository;
    private final TvRepository backendPopularRepository;

    private final MutableLiveData<List<Result>> _popularTvs = new MutableLiveData<>();
    public LiveData<List<Result>> popularTvs = _popularTvs;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public PopularViewModel(TvRepository tvRepository, TvRepository backendPopularRepository) {
        this.tvRepository = tvRepository;
        this.backendPopularRepository= backendPopularRepository;
        getPopular();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void getPopular() {
        backendPopularRepository.getByCategory(Constants.CATEGORY_POPULAR, new Consumer<List<Result>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void accept(List<Result> results) {
                if(results.isEmpty()){
                    tvRepository.getByCategory(Constants.CATEGORY_POPULAR, new Consumer<List<Result>>() {
                        @Override
                        public void accept(List<Result> results) {
                            _popularTvs.postValue(results);
                        }
                    });
                }else {
                    _popularTvs.postValue(results);
                }
            }
        });
    }
}

package com.example.todomovies.ui.Popular;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.todomovies.data.model.Result;
import com.example.todomovies.data.repository.TvRepository;
import com.example.todomovies.ui.base.BaseViewModel;
import com.example.todomovies.utils.Constants;

import java.util.List;

public class PopularViewModel extends BaseViewModel {
    private final TvRepository tvRepository;

    private final MutableLiveData<List<Result>> _popularTvs = new MutableLiveData<>();
    public LiveData<List<Result>> popularTvs = _popularTvs;

    public PopularViewModel(TvRepository tvRepository) {
        this.tvRepository = tvRepository;
        getPopular();
    }

    private void getPopular() {
        tvRepository.getByCategory(Constants.CATEGORY_POPULAR, _popularTvs::postValue);

    }
}

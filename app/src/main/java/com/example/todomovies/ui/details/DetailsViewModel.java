package com.example.todomovies.ui.details;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.todomovies.data.model.TvDetailsResponse;
import com.example.todomovies.data.repository.towatch.ToWatchRepository;
import com.example.todomovies.data.repository.towatch.ToWatchRoomRepository;
import com.example.todomovies.ui.base.BaseViewModel;

public class DetailsViewModel extends BaseViewModel {
    private final TvDetailsRepository detailsRepository;
    private final ToWatchRepository toWatchRepository;

    private final MutableLiveData<TvDetailsResponse> _tvDetails = new MutableLiveData<>();
    public LiveData<TvDetailsResponse> tvDetails = _tvDetails;

    private final MutableLiveData<TvDetailsResponse> _toWatchTv = new MutableLiveData<>();
    public LiveData<TvDetailsResponse> toWatchTv = _toWatchTv;


    public DetailsViewModel(TvDetailsRepository detailsRepository, ToWatchRepository toWatchRepository, int id) {

        this.detailsRepository = detailsRepository;
        this.toWatchRepository = toWatchRepository;
        setTv(id);
    }

    private void setTv(int id) {
        detailsRepository.getTvDetails(id, _tvDetails::postValue);
    }

    public void checkIfAlreadyAdded(int id) {
        toWatchRepository.findById(id, _toWatchTv::postValue);
    }

    public void addToWatch(TvDetailsResponse tv) {
        toWatchRepository.insert(tv);
    }
}

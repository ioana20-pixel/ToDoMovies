package com.example.todomovies.ui.details;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.todomovies.data.model.TvDetailsResponse;
import com.example.todomovies.data.repository.towatch.ToWatchRoomRepository;
import com.example.todomovies.ui.base.BaseViewModel;

public class DetailsViewModel extends BaseViewModel {
    private final TvDetailsRepository detailsRepository;
    private final ToWatchRoomRepository toWatchRoomRepository;

    private final MutableLiveData<TvDetailsResponse> _tvDetails = new MutableLiveData<>();

    public LiveData<TvDetailsResponse> tvDetails = _tvDetails;

    public DetailsViewModel(TvDetailsRepository detailsRepository, ToWatchRoomRepository toWatchRoomRepository, int id) {

        this.detailsRepository = detailsRepository;
        this.toWatchRoomRepository = toWatchRoomRepository;
        setTv(id);
    }

    private void setTv(int id) {
        detailsRepository.getTvDetails(id, _tvDetails::postValue);
    }

    public void checkIfAlreadyAdded(int id, DetailsActivity.FindTvListener listener) {
        new Thread(() -> {
            if (toWatchRoomRepository.findById(id) != null)
                listener.onReceived(true);
        }).start();
    }

    public void addToWatch(TvDetailsResponse tv) {
        new Thread(() -> toWatchRoomRepository.insert(tv)).start();
    }
}

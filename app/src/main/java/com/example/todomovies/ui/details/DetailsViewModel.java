package com.example.todomovies.ui.details;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.todomovies.data.model.TvDetailsResponse;
import com.example.todomovies.data.repository.towatch.ToWatchRepository;
import com.example.todomovies.data.repository.towatch.ToWatchRoomRepository;
import com.example.todomovies.ui.base.BaseViewModel;

import java.util.function.Consumer;

public class DetailsViewModel extends BaseViewModel {
    private final TvDetailsRepository detailsRepository;
    private final ToWatchRepository toWatchRepository;
    private final TvDetailsRepository backendDetailsRepository;

    private final MutableLiveData<TvDetailsResponse> _tvDetails = new MutableLiveData<>();
    public LiveData<TvDetailsResponse> tvDetails = _tvDetails;

    private final MutableLiveData<TvDetailsResponse> _toWatchTv = new MutableLiveData<>();
    public LiveData<TvDetailsResponse> toWatchTv = _toWatchTv;


    @RequiresApi(api = Build.VERSION_CODES.N)
    public DetailsViewModel(TvDetailsRepository detailsRepository, ToWatchRepository toWatchRepository, int id, TvDetailsRepository backendDetailsRepository) {

        this.detailsRepository = detailsRepository;
        this.toWatchRepository = toWatchRepository;
        this.backendDetailsRepository = backendDetailsRepository;
        setTv(id);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setTv(int id) {
        backendDetailsRepository.getTvDetails(id, new Consumer<TvDetailsResponse>() {
            @Override
            public void accept(TvDetailsResponse tvDetailsResponse) {
                if (tvDetailsResponse == null) {
                    detailsRepository.getTvDetails(id, new Consumer<TvDetailsResponse>() {
                        @Override
                        public void accept(TvDetailsResponse tvDetailsResponse) {
                            _tvDetails.postValue(tvDetailsResponse);
                        }
                    });

                }

                else _tvDetails.postValue(tvDetailsResponse);

            }
        });    }

    public void checkIfAlreadyAdded(int id) {
        toWatchRepository.findById(id, _toWatchTv::postValue);
    }

    public void addToWatch(TvDetailsResponse tv) {
        toWatchRepository.insert(tv);
    }
}

package com.example.todomovies.ui.details;

import android.os.Handler;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.todomovies.data.model.TvDetailsResponse;
import com.example.todomovies.data.repository.ToWatchRepository;
import com.example.todomovies.data.repository.TvDetailsRepository;
import com.example.todomovies.ui.base.BaseViewModel;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsViewModel extends BaseViewModel {
    private final TvDetailsRepository detailsRepository;
    private final ToWatchRepository toWatchRepository;

    private final MutableLiveData<TvDetailsResponse> _tvDetails = new MutableLiveData<>();

    public LiveData<TvDetailsResponse> tvDetails = _tvDetails;

    public DetailsViewModel(TvDetailsRepository detailsRepository, ToWatchRepository toWatchRepository, int id) {

        this.detailsRepository = detailsRepository;
        this.toWatchRepository = toWatchRepository;
        setTv(id);
    }

    private void setTv(int id) {
        Call<TvDetailsResponse> responseCall = detailsRepository.getTvDetails(id);
        responseCall.enqueue(new Callback<TvDetailsResponse>() {
            @Override
            public void onResponse(@NotNull Call<TvDetailsResponse> call, @NotNull Response<TvDetailsResponse> response) {
                if (response.code() == 200) {
                    TvDetailsResponse tv = response.body();
                    if (tv != null)
                        _tvDetails.postValue(tv);
                } else
                    Log.i("DetailsViewModel", response.message());
            }

            @Override
            public void onFailure(@NotNull Call<TvDetailsResponse> call, @NotNull Throwable t) {
                Log.e("DetailsViewModel", t.getMessage());
            }
        });
    }

    public void checkIfAlreadyAdded(int id, DetailsActivity.FindTvListener listener) {
        new Thread(() -> {
            if (toWatchRepository.findById(id) != null)
                listener.onReceived(true);
        }).start();
    }

    public void addToWatch(TvDetailsResponse tv) {
        new Thread(() -> toWatchRepository.insert(tv)).start();
    }
}

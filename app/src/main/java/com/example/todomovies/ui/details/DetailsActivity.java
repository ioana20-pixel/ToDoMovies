package com.example.todomovies.ui.details;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.todomovies.R;
import com.example.todomovies.data.api.ApiClient;
import com.example.todomovies.data.model.TvDetailsResponse;
import com.example.todomovies.data.api.TvDetailsApi;
import com.example.todomovies.databinding.ActivityDetailsBinding;
import com.example.todomovies.utils.Constants;

import org.jetbrains.annotations.NotNull;

//import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_details);

        initUiTest();
    }
    private void bindUI(TvDetailsResponse tv) {
        Glide.with(getApplicationContext())
                .load(Constants.IMAGE_BASE_URL + tv.getBackdropPath())
                .into(binding.ivBackdrop);
        Glide.with(getApplicationContext())
                .load(Constants.IMAGE_BASE_URL + tv.getPosterPath())
                .into(binding.ivPoster);
        binding.tvTitle.setText(tv.getName());
        binding.tvRating.setText("Rating: " + tv.getVoteAverage());
        binding.tvOverview.setText(tv.getOverview());
        binding.tvSeasons.setText(String.valueOf(tv.getNumberOfSeasons()));
        binding.tvEpisodes.setText(String.valueOf(tv.getNumberOfEpisodes()));
        binding.tvStatus.setText(tv.getStatus());
        binding.tvTagline.setText(tv.getTagline());
    }

    private void initUiTest() {

        TvDetailsApi tvApi = ApiClient.getTvDetailsApi();
        int id = getIntent().getExtras().getInt("id");

        Call<TvDetailsResponse> responseCall = tvApi.getMovieDetails(id);
        responseCall.enqueue(new Callback<TvDetailsResponse>() {
            @Override
            public void onResponse(@NotNull Call<TvDetailsResponse> call, @NotNull Response<TvDetailsResponse> response) {
                if (response.code() == 200) {
                    TvDetailsResponse tv = response.body();
//                    Log.v("ioana", tv.toString());
                    if (tv != null) {
                        Glide.with(getApplicationContext())
                                .load(Constants.IMAGE_BASE_URL + tv.getBackdropPath())
                                .into(binding.ivBackdrop);
                        Glide.with(getApplicationContext())
                                .load(Constants.IMAGE_BASE_URL + tv.getPosterPath())
                                .into(binding.ivPoster);
                        binding.tvTitle.setText(tv.getName());
                        binding.tvRating.setText("Rating: " + tv.getVoteAverage());
                        binding.tvOverview.setText(tv.getOverview());
                        binding.tvSeasons.setText(String.valueOf(tv.getNumberOfSeasons()));
                        binding.tvEpisodes.setText(String.valueOf(tv.getNumberOfEpisodes()));
                        binding.tvStatus.setText(tv.getStatus());
                        binding.tvTagline.setText(tv.getTagline());

                    }

                } else {
                    Log.v("ioana", response.message());
                }
            }

            @Override
            public void onFailure(@NotNull Call<TvDetailsResponse> call, @NotNull Throwable t) {
                Log.v("ioana", t.getMessage());
            }
        });



    }
}

package com.example.todomovies.ui.details;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.todomovies.R;
import com.example.todomovies.data.api.ApiClient;
import com.example.todomovies.data.model.TvDetailsResponse;
import com.example.todomovies.data.api.TvDetailsApi;
import com.example.todomovies.data.repository.ToWatchRepository;
import com.example.todomovies.data.repository.db.ToWatchDatabase;
import com.example.todomovies.databinding.ActivityDetailsBinding;
import com.example.todomovies.utils.Constants;
import com.example.todomovies.utils.InjectorUtils;

import org.jetbrains.annotations.NotNull;

//import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*
How to start a Details activity:
Intent intent = new Intent(this, DetailsActivity.class);
intent.putExtra("id", tvId);
startActivity(intent);
 */

public class DetailsActivity extends AppCompatActivity {
    private ActivityDetailsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int id = getIntent().getExtras().getInt("id");
        DetailsViewModelFactory factory = InjectorUtils.getInstance().provideDetailsViewModelFactory(id);
        DetailsViewModel viewModel = new ViewModelProvider(this, factory).get(DetailsViewModel.class);

        viewModel.tvDetails.observe(this, this::bindUI);
    }

    private void bindUI(TvDetailsResponse tv) {
        ToWatchRepository repo = ToWatchRepository.getInstance(ToWatchDatabase.getInstance(getApplicationContext()).toWatchDao());
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

        if (repo.findById(tv.getId()) != null)
            binding.btnAddFavorite.setEnabled(false);

        binding.btnAddFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repo.insert(tv);
                binding.btnAddFavorite.setEnabled(false);            }
        });

    }

    }


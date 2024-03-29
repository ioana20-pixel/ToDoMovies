package com.example.todomovies.ui.details;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.todomovies.data.model.TvDetailsResponse;
import com.example.todomovies.data.repository.db.ToWatchDatabase;
import com.example.todomovies.data.repository.towatch.ToWatchRoomRepository;
import com.example.todomovies.databinding.ActivityDetailsBinding;
import com.example.todomovies.ui.base.BaseActivity;
import com.example.todomovies.utils.Constants;
import com.example.todomovies.utils.InjectorUtils;

import org.jetbrains.annotations.NotNull;

/*
How to start a Details activity:
Intent intent = new Intent(this, DetailsActivity.class);
intent.putExtra("id", tvId);
startActivity(intent);
 */

public class DetailsActivity extends BaseActivity<DetailsViewModel> {
    private ActivityDetailsBinding binding;

    @NotNull
    @Override
    public DetailsViewModel createViewModel() {
        int id = getIntent().getExtras().getInt("id");
        DetailsViewModelFactory factory = InjectorUtils.getInstance().provideDetailsViewModelFactory(id, getApplicationContext());
        return new ViewModelProvider(this, factory).get(DetailsViewModel.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel.toWatchTv.observe(this, tvDetailsResponse -> binding.btnAddToWatch.setEnabled(tvDetailsResponse == null));
        viewModel.tvDetails.observe(this, this::bindUI);
    }

    private void bindUI(TvDetailsResponse tv) {
        ToWatchRoomRepository repo = ToWatchRoomRepository.getInstance(ToWatchDatabase.getInstance(getApplicationContext()).toWatchDao());
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


        viewModel.checkIfAlreadyAdded(tv.getId());

        binding.btnAddToWatch.setOnClickListener(view -> {
            viewModel.addToWatch(tv);
            binding.btnAddToWatch.setEnabled(false);

        });

    }

}


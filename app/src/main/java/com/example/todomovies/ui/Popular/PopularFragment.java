package com.example.todomovies.ui.Popular;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todomovies.GenAdapter;
import com.example.todomovies.R;
import com.example.todomovies.data.api.ApiClient;
import com.example.todomovies.data.api.MovieApi;
import com.example.todomovies.data.model.MoviesList;
import com.example.todomovies.data.model.Result;
import com.example.todomovies.databinding.FragmentPopularBinding;
import com.example.todomovies.ui.base.BaseFragment;
import com.example.todomovies.ui.details.DetailsActivity;
import com.example.todomovies.utils.InjectorUtils;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PopularFragment extends BaseFragment<PopularViewModel> {

    private FragmentPopularBinding binding;

    @NotNull
    @NonNull
    @Override
    public PopularViewModel createViewModel() {
        PopularViewModelFactory factory = InjectorUtils.getInstance().providePopularViewModelFactory();
        return new ViewModelProvider(this, factory).get(PopularViewModel.class);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstance) {
        super.onViewCreated(view, savedInstance);
        viewModel.popularTvs.observe(getViewLifecycleOwner(), this::bindUI);
    }

    private void bindUI(List<Result> movieResult) {
        binding.recyclerVpopular.setLayoutManager(new LinearLayoutManager(getContext()));
        GenAdapter adapter = new GenAdapter(getContext(), movieResult, id -> {
            Intent intent = new Intent(getContext(), DetailsActivity.class);
            intent.putExtra("id", id);
            startActivity(intent);
        });
        binding.recyclerVpopular.setAdapter(adapter);
    }
}

package com.example.todomovies.ui.Popular;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.todomovies.GenAdapter;
import com.example.todomovies.data.model.Result;
import com.example.todomovies.databinding.FragmentPopularBinding;
import com.example.todomovies.ui.base.BaseFragment;
import com.example.todomovies.ui.details.DetailsActivity;
import com.example.todomovies.utils.InjectorUtils;

import org.jetbrains.annotations.NotNull;

import java.util.List;

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

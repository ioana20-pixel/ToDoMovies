package com.example.todomovies.ui.to_watch;

import static java.security.AccessController.getContext;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todomovies.R;
import com.example.todomovies.data.model.TvDetailsResponse;
import com.example.todomovies.data.repository.db.ToWatchDatabase;
import com.example.todomovies.data.repository.towatch.ToWatchRoomRepository;
import com.example.todomovies.ui.base.BaseFragment;
import com.example.todomovies.ui.details.DetailsActivity;
import com.example.todomovies.utils.InjectorUtils;

import java.util.ArrayList;
import java.util.List;

public class ToWatchFragment extends BaseFragment<ToWatchViewModel> {
    @NonNull
    @Override
    public ToWatchViewModel createViewModel() {
        ToWatchViewModelFactory toWatchViewModelFactory = InjectorUtils.getInstance().provideToWatchViewModelFactory(getContext());
        return new ViewModelProvider(this, toWatchViewModelFactory).get(ToWatchViewModel.class);
    }

    private RecyclerView recyclerView;
    private List<TvDetailsResponse> movieList = new ArrayList<>();
    private MoviesListener listener;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_towatch, container, false);

        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstance) {
        super.onViewCreated(view, savedInstance);
        viewModel.favTvs.observe(getViewLifecycleOwner(), new Observer<List<TvDetailsResponse>>() {
            @Override
            public void onChanged(List<TvDetailsResponse> tvDetailsResponses) {
                recyclerView = view.findViewById(R.id.recycler_vtowatch);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                ToWatchAdapter adapter = new ToWatchAdapter(getContext(), tvDetailsResponses, new ToWatchAdapter.ItemClickListener() {
                    @Override
                    public void onItemClicked(int id) {
                        Intent intent = new Intent(getContext(), DetailsActivity.class);
                        intent.putExtra("id", id);
                        startActivity(intent);
                    }
                }) {
//                    @Override
//                    public void onItemClicked(int id) {
//                        Intent intent = new Intent(getContext(), DetailsActivity.class);
//                        intent.putExtra("id", id);
//                        startActivity(intent);
//                    }
                };
                recyclerView.setAdapter(adapter);
            }
        });


    }

    public interface MoviesListener {
        void onReceived(List<TvDetailsResponse> movies);
    }

}

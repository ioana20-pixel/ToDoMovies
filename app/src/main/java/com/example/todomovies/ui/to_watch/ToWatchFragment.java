package com.example.todomovies.ui.to_watch;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.todomovies.R;
import com.example.todomovies.data.model.TvDetailsResponse;
import com.example.todomovies.data.repository.ToWatchRepository;
import com.example.todomovies.data.repository.db.ToWatchDatabase;
import com.example.todomovies.ui.details.DetailsActivity;

import java.util.ArrayList;
import java.util.List;

public class ToWatchFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<TvDetailsResponse> movieList = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_towatch, container, false);
        movieList = ToWatchRepository.getInstance(ToWatchDatabase.getInstance(getContext()).toWatchDao()).getAll();

        // retrofit

        recyclerView = view.findViewById(R.id.recycler_vtowatch);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ToWatchAdapter adapter = new ToWatchAdapter(getContext(), movieList, new ToWatchAdapter.ItemClickListener() {
            @Override
            public void onItemClicked(int id) {
                Intent intent = new Intent(getContext(), DetailsActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);


        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstance) {
        super.onViewCreated(view, savedInstance);


    }

}

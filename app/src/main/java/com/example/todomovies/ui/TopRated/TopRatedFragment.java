package com.example.todomovies.ui.TopRated;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.todomovies.GenAdapter;
import com.example.todomovies.R;
import com.example.todomovies.data.api.ApiClient;
import com.example.todomovies.data.api.MovieApi;
import com.example.todomovies.data.model.MoviesList;
import com.example.todomovies.data.model.Result;
import com.example.todomovies.ui.details.DetailsActivity;

public class TopRatedFragment extends Fragment {

    public static String BASE_URL = "https://api.themoviedb.org/3/";
    public static String API_KEY = "0a416fc6c49f4a04db6e3bd398ef8579";
    public static String CATEGORY = "top-rated";


    private RecyclerView recyclerView;
    private List<Result> movieList = new ArrayList<>();
    private MutableLiveData<List<Result>> list = new MutableLiveData<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_top_rated, container, false);


        Call<MoviesList> call = ApiClient.getMovieApi().listOfMovies(CATEGORY);

        call.enqueue(new Callback<MoviesList>() {
            @Override
            public void onResponse(Call<MoviesList> call, Response<MoviesList> response) {
                if (response.code() != 200) {
                    //handle the error and display it
                    return;
                }
                List<Result> movieList = new ArrayList<>();
                MoviesList movies = response.body();
                for (Result movie : movies.getResults()) {
                    movieList.add(movie);
                }

                list.postValue(movieList);

            }

            @Override
            public void onFailure(Call<MoviesList> call, Throwable t) {
            }
        });

        list.observe(getViewLifecycleOwner(), movieResult -> {
            recyclerView = view.findViewById(R.id.recycler_vtoprated);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            GenAdapter adapter = new GenAdapter(getContext(), movieResult, new GenAdapter.ItemClickListener() {
                @Override
                public void onItemClicked(int id) {
                    Intent intent = new Intent(getContext(), DetailsActivity.class);
                    intent.putExtra("id", id);
                    startActivity(intent);
                }
            });            recyclerView.setAdapter(adapter);
            recyclerView.setHasFixedSize(true);


        });

        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstance) {
        super.onViewCreated(view, savedInstance);





    }

    private void PutDataIntoRecyclerView(List<Result> movieList) {
//        movieList.forEach(m -> {
//            Log.v("CNT", m.getName());
//        });
        //recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
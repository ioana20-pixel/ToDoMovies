package com.example.todomovies.data.repository;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.todomovies.data.model.Result;
import com.example.todomovies.data.model.TvDetailsResponse;

import java.util.List;

@Dao
public interface ToWatchDao {
    @Insert
    long insertToWatch(TvDetailsResponse result);

    @Delete
    int deleteToWatch(TvDetailsResponse result);

    @Query("SELECT * FROM towatch")
    List<TvDetailsResponse> getAllToWatch();

    @Query("SELECT * FROM towatch where id = :id")
    TvDetailsResponse findById(int id);
}

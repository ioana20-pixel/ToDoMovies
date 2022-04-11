package com.example.todomovies.data.repository.towatch;

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
    static List<TvDetailsResponse> getAllToWatch() {
        return null;
    }

    @Query("SELECT * FROM towatch where id = :id")
    static TvDetailsResponse findById(int id) {
        return null;
    }
}

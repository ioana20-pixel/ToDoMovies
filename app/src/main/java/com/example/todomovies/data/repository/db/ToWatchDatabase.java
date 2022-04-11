package com.example.todomovies.data.repository.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.todomovies.data.model.TvDetailsResponse;
import com.example.todomovies.data.repository.towatch.ToWatchDao;

@Database(entities = {TvDetailsResponse.class}, version = 1)
public abstract class ToWatchDatabase extends RoomDatabase {
    public abstract ToWatchDao toWatchDao();

    private static ToWatchDatabase instance = null;

    public static ToWatchDatabase getInstance(Context context){
        if (instance == null)
            instance = Room.databaseBuilder(context, ToWatchDatabase.class, "towatch_database").allowMainThreadQueries().build();

        return instance;
    }
}

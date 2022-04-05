package com.example.todomovies.data.repository;

import com.example.todomovies.data.model.Result;
import com.example.todomovies.data.model.TvDetailsResponse;

public class ToWatchRepository {
    private final ToWatchDao toWatchDao;

    private static ToWatchRepository instance = null;

    private ToWatchRepository(ToWatchDao toWatchDao){
        this.toWatchDao = toWatchDao;
    }

    public static ToWatchRepository getInstance(ToWatchDao toWatchDao) {
        if (instance == null)
            instance = new ToWatchRepository(toWatchDao);

        return instance;
    }

    public long insert(TvDetailsResponse result) {
        return toWatchDao.insertToWatch(result);
    }

    public int delete(TvDetailsResponse result){
        return toWatchDao.deleteToWatch(result);
    }
}

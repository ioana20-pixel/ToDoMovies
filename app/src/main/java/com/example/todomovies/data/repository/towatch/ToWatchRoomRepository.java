package com.example.todomovies.data.repository.towatch;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.todomovies.data.model.TvDetailsResponse;

import java.util.List;
import java.util.function.Consumer;

public class ToWatchRoomRepository implements ToWatchRepository{
    private final ToWatchDao toWatchDao;

    private static ToWatchRoomRepository instance = null;

    private ToWatchRoomRepository(ToWatchDao toWatchDao) {
        this.toWatchDao = toWatchDao;
    }

    public static ToWatchRoomRepository getInstance(ToWatchDao toWatchDao) {
        if (instance == null)
            instance = new ToWatchRoomRepository(toWatchDao);

        return instance;
    }

    @Override
    public void insert(TvDetailsResponse result) {
        new Thread(() -> toWatchDao.insertToWatch(result)).start();
    }

    @Override
    public void delete(TvDetailsResponse result) {
        new Thread(() -> toWatchDao.deleteToWatch(result)).start();

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void getAll(Consumer<List<TvDetailsResponse>> consumer) {
        new Thread(() -> {
            List<TvDetailsResponse> tvs = toWatchDao.getAllToWatch();
            consumer.accept(tvs);
        }).start();    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void findById(int id, Consumer<TvDetailsResponse> consumer) {
        new Thread(() -> consumer.accept(toWatchDao.findById(id))).start();
    }
}

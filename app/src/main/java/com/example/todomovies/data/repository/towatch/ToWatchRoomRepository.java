package com.example.todomovies.data.repository.towatch;

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
        new Thread(() -> toWatchDao.insertToWatch(result));
    }

    @Override
    public void delete(TvDetailsResponse result) {
        new Thread(() -> toWatchDao.deleteToWatch(result));

    }

    @Override
    public void getAll(Consumer<List<TvDetailsResponse>> consumer) {
        consumer.accept(toWatchDao.getAllToWatch());
    }

    @Override
    public void findById(int id, Consumer<TvDetailsResponse> consumer) {
        consumer.accept(toWatchDao.findById(id));
    }
//
//    public List<TvDetailsResponse> getAll() {
//        return favoritesDao.getAllFavorites();
//    }
//
//    public TvDetailsResponse findById(int id) {
//        return favoritesDao.findById(id);
//    }
}

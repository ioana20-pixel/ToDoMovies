package com.example.todomovies.ui.to_watch;

import androidx.fragment.app.Fragment;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "To Watch Movies")
public class ToWatchFragment extends Fragment {
    @PrimaryKey
    private int id;
}

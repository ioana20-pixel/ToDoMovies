package com.example.todomovies.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Configuration {
    @SerializedName("images")
    private Images images;

    @SerializedName("change_keys")
    private List<String> changeKeys;

    public Images getImages(){
        return images;
    }

    public List<String> getChangeKeys(){
        return changeKeys;
    }
}
